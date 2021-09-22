
# Web Automated Tests

This project is a template to create tests for the Web platforms. The tests assist in verifying the stability of the environments and also help us understand what features
are not working as expected. By default, Maven is used to executing all the commands for this repository. 

# Used Technologies

The automatic tests are developed using:
- Java
- Selenium
- Cucumber
- Maven

## Setting up the application
Clone the repository from bitbucket with the following command

```bash 
git clone git@github.com:diogo-brandao1/web-automation-template.git

cd web-automation-template
```

## Install the dependencies 

```bash
mvn install
```
## Installing Plugins - IntelliJ IDE

In the event that you are using IntelliJ, you will need to install the following plugins on your IDE: Java and Gherkin Substeps IntelliJ plugins. 

## Project Setup & Driver Information

To run the project on either Linux, Windows, or Mac operating systems, you require to have a driver that is specific to your operating system. The different driver configuration properties for different operating systems can be found in the directory `src/test/resources/os`. The drivers required by selenium to run your project can be found in the directory `drivers > [operation_system_name]` in the project root. 

## Running tests in Different Environments

The way this project has been set up, the tests can be run in different environments either TEST, UXT or UAT. These environments can be added when the need arises. 
The configuration for which environments are currently supported can be found on the "resources > env" folder. 

To run the tests we just need to execute the command line
```bash
mvn clean verify -Dcucumber.options="features/BingSearch.feature"
```
And exists 3 ways to select an environment to run the tests:
1) We can send the parameter on the command line adding the "```-Denv=<environment_name>```" (example:)
   - ```mvn clean verify -Denv=uat -Dcucumber.options="features/BingSearch.feature"```
2) We can add the parameter ```env=<environment_name>``` on the ```config.properties``` file
   - ```env=test```
3) In case we don't send the variable on the ```command line``` or has on the ```config.properties``` will be select as the default environment. The variable has the name ```environmentDefault``` and is on the file ```src > test > java > Steps > DriverConfigs.java```
   - ```private static String environmentDefault = "test";```
   
When running our tests, the system will use some priority. The system will try to read from the ```command line``` but if the variable is not present, will try to read on the ```config.properties``` file Only if is not present there, will use the default value.
After picking the environment variable the system will read the respective configuration file. And this file needed to be present on the directory ``` src > test > resources > env``` with the name ```config.<environment_name>.properties```.

## Running tests selecting the browser
To run the tests on a specific browser we can select one of the 2 ways to do it:
1) We can send the parameter on the command line adding the "```-Dbrowser=<browser_name>```" (example:)
   - ```mvn clean verify --Dbrowser=chrome -Dcucumber.options="features/BingSearch.feature"```
2) We can add the parameter ```browser=<environment_name>``` on the ```config.properties``` file
   - ```browser=chrome```

When running our tests, the system will use some priority. The system will try to read from the ```command line``` but if the variable is not present, will try to read on the ```config.properties``` file but if is missing, will throw an error.
After picking the browser variable the system will check all the configurations to start that browser and lunch it, but if the browser doesn't have the configurations on the file ```src > test > java > Steps > DriverConfigs.java``` will throw the error.

## Running tests using @tags
From the command above we can also send some more options which determine which set of data to use when running our tests `-Dcucumber.options="--tags @uxt" `. This section tells Cucumber and maven that we want to use the test data that is tagged as  `@uxt`. 

In our tests, we have defined data for different environments as we are separating the tests to run independently by every defined environment.

```gherkin
Scenario Outline: Business - Do the login with correct credentials
    Given i am in the business login page
    And i change the language to english
    And change language successfully
    Then i want to login with "<username>" and "<password>"
    And i confirm i am in select context page

  @test
    Examples:
      | username | password |
      | business.company | Password1* |

  @uxt
    Examples:
      | username | password |
      | uxt.company | Password1* |

  @uat
    Examples:
      | username | password |
      | uat.company | Password1* |

```

In the above `Scenario Outline`, we can run our tests with any set of the defined data above, either `@test` or `@uxt` or `@uat`. These configurations can be changed when executing commands on the command line. 

## Running tests - Using the terminal
The following GIF shows how you can run tets using the IDE terminal 

![ Terminal test run ](./assets/test-run-cli.gif)

## Running tests on IntelliJ - Using the IDE
The following GIF shows how you can run tests using the IDE and cucumber. 

![ IDE test run ](./assets/test-run-intellij.gif)

It is important to note, that with the configuration on the GIF done, you can run, whole folders like `business` or even subfolders like `auth` and even single `.feature` files, just by right-clicking and using the run option for cucumber as long as you have the plugins mentioned above installed. 

## Contributing

To contribute to this repository, create a branch from the master branch, then make your changes and create a pull request against the master branch. 

Before creating a pull request, make sure you run your tests locally and ensure that they are passing before creating a pull request. 

### Need further help? ###

Feel free to contact Diogo Brandão (Bring's Automation Web Specialist) or Pedro Silveira (The QA team leader)

### Architecture ###

```tree
.
├── drivers                                     -> Directory with one folder for each operative system inside with all the drivers for that system
│   ├── linux
│   ├── mac
│   │   ├── chromedriver                        -> chrome driver for mac
│   │   ├── geckodriver
│   │   └── msedgedriver
│   └── windows
├── features                                    -> where all the features files should be
├── src
│   └── test
│       ├── java
│       │   ├── Components                      -> where all the Singular Objects are present (menus, datepickers, etc...) 
│       │   ├── Config                          -> where all the configurations to start the tests are present
│       │   │   ├── OSConfiguration             -> class to check what operative system are present on the computer
│       │   │   └── ReadPropFile                -> class to read the configuration properties files
│       │   ├── PageObjects                     -> where all the page objects are present (1 class = 1 page)
│       │   ├── Steps                           -> where the cucumber phrases are defined to corresponding to actions
│       │   └── Util                            -> auxiliary classes/functions
│       └── resources
│           ├── env
│           │   ├── config.properties           -> main configuration properties file
│           │   ├── config.uat.properties       -> UAT configuration properties file
│           │   └── config.test.properties
│           └── os
│               ├── config.linux.properties
│               ├── config.mac.properties       -> MAC configuration properties file
│               └── config.windows.properties
├── pom.xml                                     -> maven configurations
└── README.md                                   -> instructions file
```