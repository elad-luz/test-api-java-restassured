# Automatic API Tests on JavaInfra -&- RestAssured

1. Set a Java based API test for analyzing a requests' replied-response (made in 2 types of infras: JavaClasses -&- RestAssured).
2. Project demonstrates the ability to make Test automation on API (using: https://jsonplaceholder.typicode.com).
    - This Project uses 2 Types of Java-Based Methods, to perform the same task
        - 1st is in a Pure-Java Infra (where I built my own infrastructure, that Sends a Request and parse the Returned Response as an Object, on which Asserts could be done).
        - 2ed is in RestAssured Infra (where I use it to send requests & test the API & generate Allure report of 3 TestCases: 1 Disabled, 2 Passed, 3 Failed).

Note: I will soon, also add another repo, for performing Automation on API using: POSTMAM \ Playwright & Python.

## Overview

The primary goal of this project is to perform a DEMO on Test-Capability, while testing several API requests (Java-Tests Run as stand alone -&- The RestAssured Run via Maven).

## Project Structure

- `<ROOT>\src\main\java\API_JavaTestingInfra` : This directory contains the classes for a pure Java-infra (tests-class is: ApiClientTest).
- `<ROOT>\src\test\java` : This directory contains the test classes, with Test scenarios & Utilities:
- `\api\restAssured` : This directory contains the test classes, for RestAssured API test-scenarios (tests-class is: ApiClientTest).
- `\utilities` : This directory contains the varied utilities for Running the Tests properly.
- `<ROOT>\src\test\resources` : This directory contains config-params & data-sources, to be used during tests.

##  Running Tests Locally

Installation, Setup and Run Test (after preparing it properly):

1. Pre-Condition - having Visual-Studio-Code (or any other alternative equivalent), Java -&- Maven.
2. Install relevant dependencies: java etc.
3. Clone this GIT repository to your local machine.
4. To run the Java-API tests locally, using VCS:
    - RightClick ApiClientTest.java (under: `src\main\java\API_JavaTestingInfra`) -&- Click: Run Java (till done) →
    - See results in Terminal...
5. Running the RestAssured & Selenium tests-cases locally, using the 'Command-Line' (CMD):
    - Open CMD & open the project-root (e.g. `cd C:\Users\USER\eclipse-workspace\<project>`).
    - issue maven command  →  `mvn clean test -DsuiteXmlFile=testng.xml` (till finish).
    - For generating the Allure-Test-Results html report, run via same CMD the following command  →  `mvn allure:serve` (will open).

Enjoy...
Elad Luz

