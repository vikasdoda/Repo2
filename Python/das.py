import subprocess
import os
import json
import time
print("hello")
os.system("ls -ltr")

project_name="BBAND-DAS-NEW-APP-TEST"
pool_name="IOS-C"
project_arn=""
device_pool_arn=""
create_upload_arn=""

home_dir = os.system("cd ~")
os.system("pwd")
print("cd ~ ran with exit code %d" % home_dir)


#-----------------------------------------------------------------------------------------------------------------------------------------------------------

#list_files = subprocess.run(["ls","../../..", "-ltr"], stdout=subprocess.DEVNULL)
deviceFarm_Projects = subprocess.run(["aws","devicefarm", "--region=us-west-2", "--profile=nvsit-poweruser-sso", "list-projects"], stdout=subprocess.PIPE, text=True)


print(deviceFarm_Projects.stdout)

pro = json.loads(deviceFarm_Projects.stdout)

print(pro)


for project in pro["projects"]:
    print(project["name"])
    if (project["name"] == project_name):
        print("project found")
        project_arn = project["arn"]
        print (f"project arn = {project_arn}")
        break
        

#-----------------------------------------------------------------------------------------------------------------------------------------------------------


deviceFarm_Pools = subprocess.run(["aws","devicefarm", "--region=us-west-2", "--profile=nvsit-poweruser-sso", "list-device-pools", "--arn", project_arn], stdout=subprocess.PIPE, text=True)

print(deviceFarm_Pools.stdout)

devicePools = json.loads(deviceFarm_Pools.stdout)

print(devicePools)


for device in devicePools["devicePools"]:
    print(device["name"])
    if (device["name"] == pool_name):
        print("device Pool found")
        device_pool_arn = device["arn"]
        print (f"project arn = {device_pool_arn}")
        break

#-----------------------------------------------------------------------------------------------------------------------------------------------------------

print("------------------------------------------------------------------------")
print("--------------------Create Upload Ref App-------------------------------")
print("------------------------------------------------------------------------")

#with open('ios-dasapp.ipa','r') as f:
    
create_upload_cmd = subprocess.run(["aws","devicefarm","create-upload", "--region=us-west-2", "--profile=nvsit-poweruser-sso", "--project-arn", project_arn , "--name", "ios-dasapp.ipa", "--type", "IOS_APP"], stdout=subprocess.PIPE, text=True)


print(create_upload_cmd.stdout)

create_upload_json = json.loads(create_upload_cmd.stdout)

create_upload_arn = create_upload_json["upload"]["arn"]
create_upload_url = create_upload_json["upload"]["url"]

print(create_upload_arn)
print(create_upload_url)


print("------------------------------------------------------------------------")
print("--------------------Curl command to upload Ref App----------------------")
print("------------------------------------------------------------------------")

curl_cmd = subprocess.run(["curl","-T","./ios-dasapp.ipa",create_upload_url], stdout=subprocess.PIPE, text=True)

print(curl_cmd.stdout)



time.sleep(20)
print("------------------------------------------------------------------------")
print("--------------------Get the status of  upload Ref App-------------------")
print("------------------------------------------------------------------------")


get_ref_app_upload_status = subprocess.run(["aws","devicefarm","get-upload", "--region=us-west-2", "--profile=nvsit-poweruser-sso", "--arn", create_upload_arn], stdout=subprocess.PIPE, text=True)

print(get_ref_app_upload_status.stdout)
get_ref_app_upload_status_json = json.loads(get_ref_app_upload_status.stdout)


if(get_ref_app_upload_status_json["upload"]["status"]=="SUCCEEDED"):
    print("---------------------------------------------All Good----------------------")



#-----------------------------------------------------------------------------------------------------------------------------------------------------------

print("------------------------------------------------------------------------")
print("--------------------Create Upload Test Package-------------------------------")
print("------------------------------------------------------------------------")

#with open('ios-dasapp.ipa','r') as f:

create_upload_testpackage_cmd = subprocess.run(["aws","devicefarm","create-upload", "--region=us-west-2", "--profile=nvsit-poweruser-sso", "--project-arn", project_arn , "--name", "DasTestApplication_ONE-iOS.zip", "--type", "APPIUM_JAVA_TESTNG_TEST_PACKAGE"], stdout=subprocess.PIPE, text=True)


print(create_upload_testpackage_cmd.stdout)

create_upload_testpackage_json = json.loads(create_upload_testpackage_cmd.stdout)

create_upload_testpackage_arn = create_upload_testpackage_json["upload"]["arn"]
create_upload_testpackage_url = create_upload_testpackage_json["upload"]["url"]

print(create_upload_testpackage_arn)
print(create_upload_testpackage_url)


print("------------------------------------------------------------------------")
print("--------------------Curl command to upload Ref App----------------------")
print("------------------------------------------------------------------------")

curl_cmd = subprocess.run(["curl","-T","./DasTestApplication_ONE-iOS.zip",create_upload_testpackage_url], stdout=subprocess.PIPE, text=True)

print(curl_cmd.stdout)



print("------------------------------------------------------------------------")
print("--------------------Get the status of  upload Ref App-------------------")
print("------------------------------------------------------------------------")

time.sleep(20)

get_testpackage_upload_status = subprocess.run(["aws","devicefarm","get-upload", "--region=us-west-2", "--profile=nvsit-poweruser-sso", "--arn", create_upload_testpackage_arn], stdout=subprocess.PIPE, text=True)

print(get_testpackage_upload_status.stdout)
get_testpackage_upload_status_json = json.loads(get_testpackage_upload_status.stdout)


if(get_testpackage_upload_status_json["upload"]["status"]=="SUCCEEDED"):
    print("---------------------------------------------All Good----------------------")


print("------------------------------------------------------------------------")
print("--------------------schedule a test run --------------------------------")
print("------------------------------------------------------------------------")

special_cmd = "testSpecArn=arn:aws:devicefarm:us-west-2::upload:1502522c-e4d2-4387-9c8e-95aedf626985,"+"type=APPIUM_JAVA_TESTNG,"+"testPackageArn="+ create_upload_testpackage_arn

print(special_cmd)

#cmd_build = ["aws","devicefarm","schedule-run", "--region=us-west-2", "--profile=nvsit-poweruser-sso", "--project-arn", project_arn, "--app-arn", create_upload_arn , "--device-pool-arn", device_pool_arn, "--name", "TESTUSINGPYTHON", "--test", "testSpecArn=arn:aws:devicefarm:us-west-2::upload:1502522c-e4d2-4387-9c8e-95aedf626985", "type=APPIUM_JAVA_TESTNG", "testPackageArn=",create_upload_testpackage_arn]


#get_test_run_upload_status = subprocess.run(["aws","devicefarm","schedule-run", "--region=us-west-2", "--profile=nvsit-poweruser-sso", "--project-arn", project_arn, "--app-arn", create_upload_arn , "--device-pool-arn", device_pool_arn, "--name", "TESTUSINGPYTHON", "--test","testSpecArn=arn:aws:devicefarm:us-west-2::upload:1502522c-e4d2-4387-9c8e-95aedf626985,","type=APPIUM_JAVA_TESTNG,",testpackarn], stdout=subprocess.PIPE, text=True)

get_test_run_upload_status = subprocess.run(["aws","devicefarm","schedule-run", "--region=us-west-2", "--profile=nvsit-poweruser-sso", "--project-arn", project_arn, "--app-arn", create_upload_arn , "--device-pool-arn", device_pool_arn, "--name", "TESTUSINGPYTHON", "--test", special_cmd], stdout=subprocess.PIPE, text=True)

print(get_test_run_upload_status.stdout)
get_testpackage_upload_status_json = json.loads(get_testpackage_upload_status.stdout)

    
