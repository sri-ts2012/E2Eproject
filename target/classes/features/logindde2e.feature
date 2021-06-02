Feature: Login to the application
Scenario Outline: Positive test validating Login
Given Initilize the browser with chrome
And Navigate to "http://qaclickacademy.com"  site
And click on login link to land on secure sign page
When user enter <username> and <password> and logs in
Then verify that user is successfully logged in

Examples:
|username	|password	|
|abc@xyz.com	|haha	|
|sdf@rew.com	|dsd	|
		
