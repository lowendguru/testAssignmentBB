# testAssignmentBB

# Documents

The following documents can be found in the /docs folder.
* Test Plan - computer-database.docx: Test approach and definitions.
* Test Cases - computer-database.xlsx: Includes a sheet with a suite of Test Cases for manual execution called "Functional Test Cases". Also has a sheet called "Test Summary" with summary data about test results and feature coverage. Finally, this file has a sheet called "Defects" with the description of issues found during test execution. Video or picture files with evidence of the defects can be found in the /docs/bug_evidence folder.


# Automated Test Suite

These tests are written in Java using 'Selenium' and 'testNG' as a testing framework with Maven as dependency manager. 
The test suite contains test cases which represent a small portion of the full manual test suite. These test the basic core functionality of the 'computer-database' app.
The tests were designed to be executed on Google Chrome as it is the browser with the biggest market share at the time of these tests.


### Computer-Database functional Tests

The automated test suite has four test cases:

- CreateComputerTest: Creates a computer using random valid values.

- ReadComputerTest: Creates a computer as precondition. Finds the computer and accesses the Edit view to check the values match the ones passed at the time of creation.

- UpdateComputerTest: Creates a computer as precondition. Finds the computer and accesses the Edit view to change all fields with a different set of valid random values.

- DeleteComputerTest: Creates a computer as precondition. Deletes the computer. Checks that the computer is no longer available. 



## Preconditions

The requirements to run this automated tests are:
- Maven
- Java 1.8
- Google Chrome 77 (or newer version)

### Maven project

This is a maven project. All dependencies are managed automatically and is OS agnostic. Chrome webdriver is managed as a maven dependency.

The test suite can be executed via command line. 
```
    $mvn clean test
```
This will run all the tests and results will be available in the /test-output/${timestamp} folder. Every execution creates a new /${timestamp} subfolder. This way all previous executions are saved for future reference.



### Structure
#### Page Object classes
The classes in the "pages" package provide access to the WebElements necessary to interact with all the pages in the web app. This abstraction layer allows for easy code maintenance in the case of changes in the UI. 
#### Test classes
The test classes located under the "tests" package hold the test cases that verify the expected behavior of the application. All tests extend the BaseTest class, thus allowing its methods to be reusable and maintainable.
#### Utils classes
The classes under the "utils" package are auxiliary classes with reusable code.
#### Properties file
The "datafile.properties" file in the resources/dataFiles folder has several parameters used during test execution. This prevents values from being hardcoded in the test classes thus allowing for easy code maintenance.



