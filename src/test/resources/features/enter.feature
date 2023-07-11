Feature: Login for all the valid user

Scenario Outline: Login user with valid credentials

Given User is on registration page
When User enters valid userName "<userName>"
And User enters valid "<password>"
And User clicks on login button
Then User gets the title of the page "My Account"
Then Close the browser

		Examples: 
	| userName         |   password     |
 	|	suraj@gmail.com  |   Myninja@6456 | 
	|	suraj@gmail.com  |   Myninja@6456 |
	| suraj@gmail.com  |   Myninja@6456 |