# Seven Senders Task 1 - Web testing

Web automation using selenium, maven and testNG 

Test case document: [pdf](./test-cases.pdf)

## Prerequisites
- maven
- Chrome version 86 (as chromedriver version is 86)

## Running test suite

- `mvn test` - maven will download dependencies and run the test suite 

## Ideas for further enhancements

- Configure [allure-maven](https://github.com/allure-framework/allure-maven) plugin to integrate [Allure reports](http://allure.qatools.ru/)
- Screenshot captures on failure.
- Support for headless options for CI/CD pipeline.
- Support for cross browsers testing using multiple browser drivers.
