In order to run my automation script you need to install maven and set up the environment variables.
M2_HOME = till the parent directory. C:\apache-maven-3.3.3\
Path = till the bin directory. ;C:\apache-maven-3.3.3\bin

Once maven is set up, go to the runnable batch file that is present in the project.
Edit any of the batch file and place the path for the command cd theproject path

All you need to do is double click on the batch file, say mvncleaninstallrunner and it will execute the script.
Don't close the batch file even though the test cases are done. Wait till the Jettyrunner is going to run.
This will generate a report in the target folder.
In order to see the report,once the jetty server is up and running just open any browser you wish to see the report and type localhost:8080.
In the command line you will be able to see a statement Started JettyServer.(you just need to wait for this step)


Coming to the Automation project, 
I have a package which contains a class called Maincontroller.
This contains all the annotations that are required for the testng to run my automation test scripts.
I have written this class in such a way that it will facilitate all my test cases to be independent of each other.
This class reads data from a property file called ApplicationSetUp.properties.
This property file will contain my url and which browser I need to run. All you need to do in order to change the 
browser is to go into this property and type chrome,firefox,ie,ghost,htmlunit.(Ghost and HTMLUnit are headerless browsers that are used for faster execution of testcases).
The same way whatever URL is provided will be opened.


Another package called pageobjects is used to act as a repository for all the pageobjects for my application under test. This is called Page Object Model. I have implemented Page Object Model using a class called as PageFactory which is a part of Selenium. This package contains all my webelements(pageobjects) and my methods that are defined.
Another use of PageFactory class would be to facilitate the use of annotations like @FindBy
The usual way to locate a Webelement is using a statement like the one below.
driver.findElement(By.xpath("xpath of the element")).
This is quite tedious.Instead I can simply use @FindBy(xpath="xpath of the element")
For every page a new class is created and the pageobjects related to the particular page are stored and also the methods that are need to be defined are defined in every class.

The package testmethods contains classes which extends the MainController for using the driver instance.
The classes under this package contains all @Test testng annotations methods that initializes the pageobjects and also
call the necessary methods from the page objects class. 
This facilitaties in providing clarity on what the test case and how it is called.

The utils package contains custom libraries that I have wrote in order for me to facilitate in writing my automation scripts.

Screenshot class helps me take a screenshot if at all my test case fails. The method in this class is called by a method that is present Maincontroller.(The method having @AfterMethod annotation). This particular method runs after every @Test method and checks if the test case is failed. If it is, then a screenshot is taken.

SearchData is a class which contains a static method which in order to facilitate me in reading property files based on two parameters. Filepath and the key you want to read.

Waiting is a class which contains all my explicitwaits. The reason why I wrote this is because everytime I have to wait for a particular element based on some condition I needed to type a complicated line like this.
WebDriverWait wait = new WebDriverWait(driver,10);
wait.until(ExpectedConditions.elementToBeClickable(element));

instead now that I have written methods for every condition that there is for a webelement,
all I need to do is Waiting.explicitWaitElementToBeClickable(driver,10);

To finish things off, in order to run our scripts through maven I need to provide the name of my testng.xml file.
			<plugin>
        			<groupId>org.apache.maven.plugins</groupId>
        			<artifactId>maven-surefire-plugin</artifactId>
        			<version>2.18.1</version>
        			<configuration>
          			<suiteXmlFiles>
            		<suiteXmlFile>testng.xml</suiteXmlFile>
          			</suiteXmlFiles>
        			</configuration>
      			</plugin>

The reason why I have used testng over junit is because it provides more features like more number of annotations, it has its own Report Generator(which I have not used), parallel execution of test cases can be done, Support of Data-driven testing using an annotation called @DataProvider(which I have not used since I am taking data from the property file which is named SearchData.properties) and so on. Too many features over Junit.

I hope I have been lucid which this document.
