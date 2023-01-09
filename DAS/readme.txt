Eclipse: Import Project from folder => Select the EclipseProject folder

Right click on Project (MyFirstApp in Project Explorer on the left) => Maven => Update project => Update snapshots
Right click on Project (MyFirstApp in Project Explorer on the left) => Run As Maven Install => This command shall download all dependencies from pom.xml file and save them in C:\<User>\.m2 folder.
Right click on Project (MyFirstApp in Project Explorer on the left) => Maven build
If a window appears to ask for some configuration, write "install" in Goals and continue.

Possible errors
If some kind of check jdk is installed instead of a jre:
1) Open your Eclipse, click on Windows -> Preferences -> Java -> Installed JREs
Verify that the checked JRE refers to a JDK : Select the checked JRE and click Edit… and change the path to the JDK home.
2) Right click on project (MyFirstApp in Project Explorer on the left)
-> Properties -> Java Compiler -> At the bottom, click "Execution Environments" and check-in a jdk or jre in the right pane