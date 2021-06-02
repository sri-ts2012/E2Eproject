Feature: Login to the application
Scenario: Positive test validating Login
Given Initilize the browser with chrome
And Navigate to "http://qaclickacademy.com"  site
And click on login link to land on secure sign page
When user enter "test99@gmail.com" and "123456" and logs in
Then verify that user is successfully logged in