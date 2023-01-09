package com.nagra;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.JavascriptExecutor;


import com.google.common.collect.ImmutableMap;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.remote.HideKeyboardStrategy;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.Keys;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.junit.AfterClass;

public class DasTest {

    protected AppiumDriver < MobileElement > driver;
    
    
    //For IOS

	DesiredCapabilities capabilities = new DesiredCapabilities();

	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Tokens']")
	MobileElement tokenLabel;
                        
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name='DASApplication-iOS']/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]")
	@AndroidFindBy(id = "dasUrlValue")
	MobileElement dasUrlValueElement;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name='DASApplication-iOS']/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[4]")
	@AndroidFindBy(id = "tokensValue")
	MobileElement tokensValue;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name='DASApplication-iOS']/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[5]")
	@AndroidFindBy(id = "sessionKeyListValue")
	MobileElement sessionKeyListValue;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name='DASApplication-iOS']/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSwitch")
	@AndroidFindBy(id = "persistedLicenseCheckbox")
	MobileElement persistedLicenseCheckbox;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name='DASApplication-iOS']/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[6]")
	@AndroidFindBy(id = "importStatusValue")
	MobileElement importStatusValue;
	                    
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name='DASApplication-iOS']/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[9]")
	@AndroidFindBy(id = "inputBufferValue")
	MobileElement inputBufferValue;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name='DASApplication-iOS']/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[10]")
	@AndroidFindBy(id = "keyIdValue")
	MobileElement keyIdValue;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name='DASApplication-iOS']/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[11]")
	@AndroidFindBy(id = "IVValue")
	MobileElement IVValue;
	    
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name='DASApplication-iOS']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[12]")
	@AndroidFindBy(id = "outputValue")
	MobileElement outputValue;
	                    
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Decrypt']")
	@AndroidFindBy(id = "decryptButton")
	MobileElement decryptButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Encrypt']")
	@AndroidFindBy(id = "encryptButton")
	MobileElement encryptButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sign']")
	@AndroidFindBy(id = "SignButton")
	MobileElement signButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Verify']")
	@AndroidFindBy(id = "verifyButton")
	MobileElement verifyButton;

	@iOSXCUITFindBy(accessibility = "Get License")
	@AndroidFindBy(xpath = "//XCUIElementTypeStaticText[@name='Get License']")
	MobileElement getLicenseButton;
	
	@iOSXCUITFindBy(accessibility = "Return")
	@AndroidFindBy(xpath = "//XCUIElementTypeStaticText[@name='Return']")
	MobileElement returnKey;
	

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Reset']")
	@AndroidFindBy(id = "resetButton")
	MobileElement resetButton;

	/* iOS specific UI elements */

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name='DASApplication-iOS']/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[3]")
	MobileElement pvs_urlElement;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name='DASApplication-iOS']/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]")
	MobileElement opVaultElement;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name='DASApplication-iOS']/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[8]")
	MobileElement model;

    String JSONexpectedOutput;
    String gTestFilePattern = "";
    String gPlatform = "";
    String gDasUrl = "";
    String gToken = "";
    String gOpvault = "";
    String gOpvault1 = "";
    String gOpvault2 = "";
    String gPVSUrl = "";

    @BeforeClass
    public void setUp() throws MalformedURLException {
        System.out.println("----------------------------In @BeforeClass Start-------------------------------------\n");

        //Get configuration file from resources folder. Was copied according to Profile selected
        String fileName = new String("/Config.json");
        InputStream inputJson = getClass().getResourceAsStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputJson));
        String platform = "NotSet", dasUrl = "NotSet", token = "NotSet", pvsUrl = "NotSet", opVault = "NotSet",opVault1 = "NotSet",opVault2 = "NotSet";

        try {
            JSONParser jsonparser = new JSONParser();
            JSONObject obj = (JSONObject) jsonparser.parse(br);
            platform = obj.get("Platform").toString();
            dasUrl = obj.get("DAS_URL").toString();
            token = obj.get("TOKEN").toString();

            if (platform.equals("iOS")) {
                pvsUrl = obj.get("PVS_URL").toString();
                opVault = obj.get("OP_VAULT").toString();
                opVault1 = obj.get("OP_VAULT1").toString();

                opVault2= obj.get("OP_VAULT2").toString();

            }

        } catch (Exception e) {
            // TODO: handle exception
        }

        System.out.println("Parameterized platform value is : " + platform);
        System.out.println("Parameterized url value is : " + dasUrl);
        System.out.println("Parameterized token value is : " + token);
        System.out.println("Parameterized pvsUrl value is : " + pvsUrl);
        System.out.println("Parameterized opVault value is : " + opVault);
        System.out.println("Parameterized opVault1 value is : " + opVault1);

        System.out.println("Parameterized opVault2 value is : " + opVault2);


        gPlatform = platform;
        gDasUrl = dasUrl;
        gToken = token;
        gPVSUrl = pvsUrl;
        gOpvault = opVault;
        gOpvault1 = opVault1;

        gOpvault2 = opVault2;

        

        if (gPlatform.equals("Android")) {
            // Set android deviceName desired capability. Set your device name.
            //capabilities.setCapability("deviceName", "Chetan phone");
           // capabilities.setCapability("UDID", "RZ8NA07FX1A");
            //   capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
            capabilities.setCapability("platformName", "Android");
         //   capabilities.setCapability("appium-version", "1.7.2");
            //  capabilities.setCapability(CapabilityType.VERSION, "8.0.0");
            capabilities.setCapability("appPackage", "com.nagra.das");
            capabilities.setCapability("appActivity", "com.nagra.das.MainActivity");
            gTestFilePattern = "Android";
        } else if (gPlatform.equals("iOS")) {

            // In case of appium running on AWS    	
            capabilities.setCapability("deviceName", "iPhone");
            //     capabilities.setCapability("browserName", "Safari");      
            capabilities.setCapability("platformName", "iOS");
           capabilities.setCapability("udid","00008020-0011188A1A50003A");
           // capabilities.setCapability("udid","027310cb43d683cc12ee881b7ba7dd6c18ba38a0");
            //capabilities.setCapability("platformVersion", "12.1");
        //    capabilities.setCapability("appium-version", "1.7.2");
            //capabilities.setCapability("appPackage", "com.nagra.es.DASApplication-iOS");
            //capabilities.setCapability("appPackage","589A6FZ678.com.nagra.es.DASApplication-iOS");
            //capabilities.setCapability("bundleId", "com.nagra.es.DASApplication-iOS");
            //capabilities.setCapability("bundleId", "com.example.DASApplication-iOS");
            capabilities.setCapability("appPackage", "com.nagra.DASApplication-iOS");
			capabilities.setCapability("bundleId", "com.nagra.DASApplication-iOS");
            capabilities.setCapability("automationName", "XCUITest");
			capabilities.setCapability("sendKeyStrategy", "setvalue");
			capabilities.setCapability("noReset", false);


            capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
            gTestFilePattern = "IOs";

        }

        capabilities.setCapability("sendKeyStrategy", "grouped");
        capabilities.setCapability("interKeyDelay", "10");

        capabilities.setCapability("resetKeyboard", true);
        capabilities.setCapability("unicodeKeyboard", true);

        capabilities.setCapability("ignoreUnimportantViews", true);
        capabilities.setCapability("disableAndroidWatchers", true);
        capabilities.setCapability("newCommandTimeout", "0");

        // Following 2 capabilities are to make sure that the app data ( Persistence License) is not cleared if case when we restart the app in IOS. Android do not support Persistence License  
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("fullReset", false);


        // Created object of RemoteWebDriver will all set capabilities.
        // Set appium server address and port number in URL string.
        // It will launch calculator app in android device.
        this.driver = new AppiumDriver < MobileElement > (
            //  new URL("http://10.3.0.235:4723/wd/hub"), //if it needs to use locally started server
             //new URL("http://10.0.26.55:4723/wd/hub"), //if it needs to use locally started server
           //new URL("http://10.3.0.226:4723/wd/hub"),
           //new URL("http://10.3.0.245:4723/wd/hub"),
        		new URL("http://0.0.0.0:4723/wd/hub"),
            //then the target_ip is 127.0.0.1 or 0.0.0.0
            //the default port is 4723
            capabilities);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        System.out.println("----------------------------In @BeforeClass End-------------------------------------\n");

    }

    @Test
    public void DAS() throws Exception {

        System.out.println("----------------------------Nominal Test Case Started---------------------------------");

        SoftAssert assertSoft = new SoftAssert(); // Use softAssert to prevent exiting test on first error

        //Get file from resources folder
        String fileName = new String("/TestVectors/testVector" + gTestFilePattern + ".json");
        System.out.println("JSON FILE NAME = " + fileName);
        
        System.out.println("JSON FILE NAME = " + fileName);


        // Have to use getReousrceAsStream because on AWS, application is executed from a jar file
        InputStream inputJson = getClass().getResourceAsStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputJson));

        JSONParser jsonparser = new JSONParser();
        JSONObject obj = (JSONObject) jsonparser.parse(br);
        JSONArray dasTestOperationArray = (JSONArray) obj.get("operations");

        driver.rotate(ScreenOrientation.LANDSCAPE);

        
        // Cleaning inputs
        resetButton.click();
      //  driver.hideKeyboard();

        for (int i = 0; i < dasTestOperationArray.size(); i++) {
            JSONObject jsonItem = (JSONObject) dasTestOperationArray.get(i);
            String JSONusage = jsonItem.get("usage").toString();

            if (JSONusage.equals("decrypt") ||
                JSONusage.equals("encrypt") ||
                JSONusage.equals("sign") ||
                JSONusage.equals("verify")
            ) {
                performCryptoOperation(jsonItem, assertSoft);
            } else if (JSONusage.equals("getLicense")) {
                performGetLicense(jsonItem, assertSoft);
            } else {
                System.out.println("Unknown usage found :" + JSONusage);
            }
        }
        System.out.println("----------------------------Nominal Test Case Successfully Executed---------------------------------");

        if (gPlatform.equals("iOS"))

        {

            System.out.println("----------------------------Persistence Test case Started in case of IOS---------------------------------");

         
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

         

            getLicenseButton.click();
            

            System.out.println("----------------get license button clicked---------------- ");
            
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            System.out.println("----------------first sleep finished---------------- ");
            System.out.println("Result----- " + importStatusValue.getText());
            AssertJUnit.assertEquals("Test failed becasue license is persistent", "OK", importStatusValue.getText());

            //Get file from resources folder
            String restartfileName = new String("/TestVectors/testRestart" + gTestFilePattern + ".json");
            System.out.println("Restart JSON FILE NAME = " + restartfileName);

            // Have to use getReousrceAsStream because on AWS, application is executed from a jar file
            InputStream inputJson_restart = getClass().getResourceAsStream(restartfileName);
            BufferedReader br_restart = new BufferedReader(new InputStreamReader(inputJson_restart));

            JSONParser jsonparser_restart = new JSONParser();
            JSONObject obj_restart = (JSONObject) jsonparser_restart.parse(br_restart);
            JSONArray dasTestOperationArray_restart = (JSONArray) obj_restart.get("operations");

            for (int i = 0; i < dasTestOperationArray_restart.size(); i++) {
                JSONObject jsonItem = (JSONObject) dasTestOperationArray_restart.get(i);
                String JSONusage = jsonItem.get("usage").toString();

                System.out.println("");

                if (JSONusage.equals("decrypt") ||
                    JSONusage.equals("encrypt") ||
                    JSONusage.equals("sign") ||
                    JSONusage.equals("verify")
                ) {
                    performCryptoOperation(jsonItem, assertSoft);

                } else {
                    System.out.println("Unknown usage found :" + JSONusage);
                }
            }
            System.out.println("----------------------------Persistence Test case Successfully finished---------------------------------");

        }
        assertSoft.assertAll();

    }



    private void performGetLicense(JSONObject jsonInput, SoftAssert assertSoft) {
        System.out.println("\n---In Get License method Start---------------------------------");
        String testName = jsonInput.get("testName").toString();
        String JSONsessionKeyListValue = jsonInput.get("sessionKeys").toString();


        System.out.println("----------------------------------------------------------");
        System.out.println("Session Keys:  " + JSONsessionKeyListValue);
        System.out.println("----------------------------------------------------------");

        String JSONpersistedLicense = jsonInput.get("persistedLicense").toString();

        
        //driver.rotate(ScreenOrientation.LANDSCAPE);

        // Cleaning inputs
       resetButton.click();



        System.out.println("Step name = " + testName);


        if (gPlatform.equals("iOS")) {
          // ((AppiumDriver) driver).closeApp();
           //((AppiumDriver) driver).closeApp();
           //driver.quit();
       }
        	
            //opVaultElement.setValue(gOpvault);
           
            //pvs_urlElement.setValue(gPVSUrl);
                 driver.rotate(ScreenOrientation.PORTRAIT);
                
  

        dasUrlValueElement.setValue(gDasUrl);
    
        tokensValue.setValue(gToken);
 

        sessionKeyListValue.sendKeys(JSONsessionKeyListValue);
        
        
        opVaultElement.getText();
        System.out.println("########################################################################################");

        System.out.println(opVaultElement.getText());
        System.out.println(pvs_urlElement.getText());
        System.out.println(dasUrlValueElement.getText());
        System.out.println(tokensValue.getText());
        System.out.println(sessionKeyListValue.getText());
        
        System.out.println("########################################################################################");

        if (JSONpersistedLicense.equals("true")) {
            if (gPlatform.equals("Android")) {
                persistedLicenseCheckbox.click();
            }
        }
        
        
        // importStatusValue.click();
        
       returnKey.click(); 
       
       getLicenseButton.click();
       
       System.out.println("Result----- " + importStatusValue.getText());

        System.out.println("----------------get license button clicked---------------- ");
        
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        System.out.println("----------------first sleep finished---------------- ");


     
          getLicenseButton.click();
          try {
           Thread.sleep(30000);
          } catch (InterruptedException e1) {
           // TODO Auto-generated catch block
           e1.printStackTrace();
          }
          System.out.println("----------------second sleep finished---------------- ");
        
       
        /*
          System.out.println("----------------B55555555---------------- ");
          try
          {
        WebDriver webDriver = null;
        //  Wait wait = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
          Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
        		    .withTimeout(30, TimeUnit.SECONDS) // set the timeout
        		    .pollingEvery(1, TimeUnit.SECONDS);
         
          Boolean waitingElement = wait.until(new Function<WebDriver, Boolean>() {
              public Boolean apply(WebDriver driver) {
            	  return importStatusValue.getText().equals("OK");
                }
              });
          }
          catch
          (org.openqa.selenium.TimeoutException e) {
        	   System.out.println("Timeout occurs awaiting expected output");
          }
          
          System.out.println("----------------B666666---------------- ");
          
         */


        /*
  try {

   WebDriverWait wait = new WebDriverWait(driver, 15);
   wait.until(new Function < WebDriver, Boolean > () {
    public Boolean apply(WebDriver driver) {
     System.out.println("Apply function => " + importStatusValue.getText());
     return importStatusValue.getText().equals("OK");
    }
   });
  } catch (org.openqa.selenium.TimeoutException e) {
   System.out.println("Timeout occurs awaiting expected output");
  }

*/
        //System.out.println("----------------Before AssertJUnit---------------- ");
        System.out.println("Result----- " + importStatusValue.getText());

        //   assertSoft.assertEquals(importStatusValue.getText(), "OK");
   AssertJUnit.assertEquals("Test failed because license is not received within a time limit or PVS is not working in case of iOS", "OK", importStatusValue.getText());
        //  System.out.println("----------------After AssertJUnit---------------- ");
        /*    
//  System.out.println("11111");
//  if (!importStatusValue.getText().equals("OK") || model.getText().equals("NOK") ) 
 // {
//   System.out.println("22222");
//   assert  importStatusValue.getText().equals("OK") || importStatusValue.getText() == null : "Test failed becasue license is not received within a time limit or PVS is not working";
//   System.out.println("3333");
  System.out.println("Test failed because");
  
  } else {
   System.out.println("Test success");
  }
*/

        //  driver.getKeyboard().sendKeys(Keys.RETURN);
        if (gPlatform.equals("iOS")) {
        //    returnKey.click(); 

           // driver.getKeyboard().sendKeys(Keys.RETURN);
        }
        System.out.println("----------------------------Finished Getting License---------------------------------");
    }

    @SuppressWarnings("deprecation")
	private void performCryptoOperation(JSONObject jsonInput, SoftAssert assertSoft) {
        // Cleaning inputs
    	
    	//driver.rotate(ScreenOrientation.LANDSCAPE);
    	//resetButton.click();
        //driver.rotate(ScreenOrientation.PORTRAIT);
    	
        System.out.println("----------------------------In the the crypto operations method Start-------------------------------------");

        String testName = jsonInput.get("testName").toString();
        String JSONinputBuffer = jsonInput.get("inputBuffer").toString().replaceAll("\"", "\\\\\"").replaceAll("\r", "").replaceAll("\n", "");
        String JSONkeyId = jsonInput.get("keyId").toString();
        String JSONiv = "";
        String JSONusage = jsonInput.get("usage").toString();
        JSONexpectedOutput = jsonInput.get("expectedOutput").toString().replaceAll("\"", "\\\\\"").replaceAll("\r", "").replaceAll("\n", "");


        if (JSONusage.equals("decrypt") || JSONusage.equals("encrypt") || JSONusage.equals("verify") || JSONusage.equals("sign")) {
        	
            
        	inputBufferValue.clear();
        	keyIdValue.clear();
        	IVValue.clear();
        	
        	if (JSONusage.equals("decrypt") || JSONusage.equals("encrypt") || JSONusage.equals("verify")) {
             JSONiv = jsonInput.get("iv").toString();
        	}
            //   System.out.println("----------------------------In the Encrpyt or decrpyt  Before Key Return-------------------------------------");
        }
        
      
        if (JSONusage.equals("decrypt") || JSONusage.equals("encrypt") || JSONusage.equals("verify") || JSONusage.equals("sign")) {
        	
       
        System.out.println("Step name = " + testName);
        System.out.println("Json=" + jsonInput.toString());

        System.out.println("\n----------------All the crypto values----------------------------");
        System.out.println("JSONInputBuffer = " + JSONinputBuffer);
        System.out.println("JSONkeyId = " + JSONkeyId);
        System.out.println("JSONiv = " + JSONiv);
        System.out.println("JSONusage = " + JSONusage);
        System.out.println("JSONexpectedOutput = " + JSONexpectedOutput);

        inputBufferValue.click();
        inputBufferValue.sendKeys(JSONinputBuffer);

        if (gPlatform.equals("iOS")) {
            returnKey.click(); 

   //         driver.getKeyboard().sendKeys(Keys.RETURN);
        }
        // driver.getKeyboard().sendKeys(Keys.RETURN);


        keyIdValue.click();
        keyIdValue.sendKeys(JSONkeyId);

        if (gPlatform.equals("iOS")) {
            returnKey.click(); 

        	//       driver.getKeyboard().sendKeys(Keys.RETURN);
        }
        //  driver.getKeyboard().sendKeys(Keys.RETURN);

        
        if (JSONusage.equals("decrypt") || JSONusage.equals("encrypt") || JSONusage.equals("verify") ) {
        IVValue.click();
        IVValue.sendKeys(JSONiv);

        if (gPlatform.equals("iOS")) {
            returnKey.click(); 

//            driver.getKeyboard().sendKeys(Keys.RETURN);
        	}
        }
        
      }
        // driver.getKeyboard().sendKeys(Keys.RETURN);

        if (JSONusage.equals("decrypt")) {
            System.out.println("\n----------------Before Decrypt button----------------------------");
            decryptButton.click();
        } else if (JSONusage.equals("encrypt")) {
            System.out.println("\n----------------Before Encrypt button----------------------------");
            encryptButton.click();
        } else if (JSONusage.equals("sign")) {
            System.out.println("\n----------------Before Sign button----------------------------");
            signButton.click();
        } else if (JSONusage.equals("verify")) {
            System.out.println("\n----------------Before Verify button----------------------------");
            verifyButton.click();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }


        try {
            // 3 seconds time out for crypto operation
            WebDriverWait waitCrypto = new WebDriverWait(driver, 3);
            waitCrypto.until(new Function < WebDriver, Boolean > () {
                public Boolean apply(WebDriver driver) {
                    return outputValue.getText().replaceAll("\r", "").replaceAll("\n", "").replaceAll(" ", "").trim().equals(JSONexpectedOutput);
                }
            });
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("Timeout occurs awaiting expected output");
        }

        //  System.out.println("-----------------------------Before printing output value--------------------------------------------");
        System.out.println("Actual Out" + outputValue.getText());
        //  System.out.println("-----------------------------After Printing Output Value--------------------------------------------");

        // Workaround: hereunder we remove extra space in middle of output. Probably added by Appium. Working locally 
        if (outputValue == null || outputValue.getText().equals("")) {
            assertSoft.assertFalse(true, "Test failed");
            return;
        }

        AssertJUnit.assertEquals(JSONexpectedOutput, outputValue.getText().replaceAll("\r", "").replaceAll("\n", "").replaceAll(" ", "").trim());

        if (!outputValue.getText().replaceAll("\r", "").replaceAll("\n", "").replaceAll(" ", "").trim().equals(JSONexpectedOutput)) {
            System.out.println("Returned=" + outputValue.getText().replaceAll("\r", "").replaceAll("\n", "").replaceAll(" ", "").trim());
            System.out.println("Expected=" + JSONexpectedOutput);
            System.out.println("Test failed");
        } else {
            System.out.println("Test success");
        }
    }

    @AfterClass
    public void End() {
        System.out.println("----------------------------DasTests Exiting Test-------------------------------------");
        capabilities.setCapability("resetKeyboard", false);
        capabilities.setCapability("unicodeKeyboard", false);

        capabilities.setCapability("ignoreUnimportantViews", false);
        capabilities.setCapability("disableAndroidWatchers", false);

        ((AppiumDriver) driver).closeApp();
        driver.quit();
    }
}