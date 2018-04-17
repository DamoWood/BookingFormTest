# Booking Form Test
Repo for manual and automated testing of http://hotel-test.equalexperts.io/.
## Manual 
A more comprehensive breakdown of the manual tests carried out can be found in the excel sheet BookingFormTest.xlsx. Sheet 1 has a breakdown of tests, sheet 2 has a list of potential bugs. 

Summary:
- High level acceptance tests carried out to make sure the form works as expected. 
- Functional tests to verify the form meets (assumed) requirements
- Testing of the http requests and responses. For example missing headers, checking the response bodies 
- Cross browser and responsiveness testing on a variety of devices, OS's, browsers and screen sizes.
- Accessibility testing 
- General exploratory testing
- I did a little testing using Gattling but I saw other people were using the same web page so I didn't push it. Response times were acceptable when doing 1 request a second. 

## Automated
The automated tests are written in Java using Selenium and Cucumber. To run them clone the repo and either run:
~~~~
mvn test
~~~~
or open in an IDE and run the RunTest.java class.

Results can be seen in the IDE, terminal or under target/cucumber-reports/index.html

Note:
Some of the steps are empty. This is because instead of repeating the setup pieces in multiple steps I have pulled them out. This means the step is empty but I have left them in as it makes the Gherkin feature files read much better. 

## Further testing
- Stress and load testing the API calls. 
- Automate the API testing.  
- Add a properties/configuration file to the automated tests which would allow running against different browsers, or different base urls easier. 
- Implement Selenium PageFactory. I didn't see this existed and sort of wrote it manually. Using an off the shelf solution would probably be the way forward. 
