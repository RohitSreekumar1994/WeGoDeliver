# Test Automation Suite for WeGoDeliver Application

The Test Automation suite for Testing the app __WeGoDeliver Web Application__ is developed using the industry-best technologies such as __Selenium__, __Java__, __Cucumber__ and __TestNG__.

This Suite consists of __3 Test Cases__ which can be used to Test the application

The web related Test Cases can be executed either in  **Chrome** or a **Firefox** browsers

##### Technology Used:
* [Java](https://www.java.com/en/)
* [Selenium](https://www.selenium.dev/)
* [Cucumber](https://cucumber.io/)
* [TestNG](https://testng.org/doc/)
* [Maven](https://maven.apache.org/)
* [Extent Reports](https://www.extentreports.com/)


##### The Test Cases focused here are :
1. _Create Odder Manually_ functionality
2. _Import Order details from CSV_ Functionality
3. _Geocode API Test_ Functionality



## Pre-requisites for Test Execution
1. Java 1.8 or greater
2. Chrome (or Firefox) browser
3. Chrome Driver ([https://chromedriver.chromium.org/downloads](https://chromedriver.chromium.org/downloads))
4. (Optional) Gekho Driver(for firefox) ([https://github.com/mozilla/geckodriver/releases](https://github.com/mozilla/geckodriver/releases))   
4. Intellij or Eclipse IDE (Optional)


### Overview About Project Structure:
* The Test Cases are written in simple __Cucumber BDD__ format, which can be found under [src/test/java/features](src/test/java/features)
* For each steps present in the cucumber BDD feature file,the corresponding _Step Definitions_ can be found under [src/test/java/steps](src/test/java/steps)
* The triggering point of this suite are the __TestNg XML__ files which are present under [src/test/java/testNG](src/test/java/testNG)
* The __POM__ package ([src/test/java/POM](src/test/java/POM))  contains all the Elements and Methods corresponding to each screen in the application
* The __runner__ package([src/test/java/runner](src/test/java/runner)) contains the _Cucumber Runner Classes_ for each Test Cases
* After the Test Execution, a detailed report is generated with screenshots for the Test Cases, which can be found under _reports_ ([src/test/reports](src/test/reports))
* The **env.properties** file holds the information of the device and other related properties ([src/main/resources/env.properties](src/main/resources/env.properties))



## Instructions for Running

1. Clone the repository
2. Configure the **env.properties** file
    1. Specify the ```` driver.name ````
    2. Specify the driver path```webdriver.chrome.driver``` (or ```webdriver.gecko.driver``` if the browser if firefox) 
    3. Enter the ```apiKey``` which is required for executing the Geocode Test Case


#### Execution Option 1 - (Using an IDE):
1. Open the project in any IDE such as Eclipse or Intellij
2. Install the Maven dependencies
3. Run the **TestNG XML** file for the required Test Case from [src/test/java/testNG](src/test/java/testNG)
4. After Execution, the reports are generated as an HTML file, which can be found under [src/test/reports](src/test/reports). Please open the reports in a Web Browser, preferably Chrome


#### Execution Option 2 - Command Line Execution
1. Navigate to the root folder where pom.xml is present
2. Install the Maven dependencies using the command ``` mvn -B -f pom.xml install```
3. Start the execution for the required Test Case by triggering the __TestNG XML__ file using Maven Surefire Plugin as follows:
    1. For _Create Odder Manually_, please run:  ``` mvn -B -f pom.xml test -Dsurefire.suiteXmlFiles=src/test/java/testNG/CreateOrderTest.xml```
    2. For _Import Order details from CSV_ please run: ``` mvn -B -f pom.xml test -Dsurefire.suiteXmlFiles=src/test/java/testNG/ImportOrderTest.xml```
    3. For _Geocode API Test_ please run: ``` mvn -B -f pom.xml test -Dsurefire.suiteXmlFiles=src/test/java/testNG/GeocodeTest.xml```
4. After Execution, the reports would be generated as an HTML file, which can be found under [src/test/reports](src/test/reports). Please open the reports in a Web Browser, preferably Chrome
