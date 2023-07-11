Feature: Login page feature

Background: 
Given User is on login page

Scenario: Title of the Login Page
When user gets the title of the page
Then page title should be "Account Login"

Scenario: Forgot password link

Then forgot password link should be displayed


Scenario:  Login with valid credentials


When user enters valid username "suraj@gmail.com"
And user enters valid passeword "Myninja@6456"
And user clicks on login button
Then user gets the title of the page
And page title should be "My Account"


