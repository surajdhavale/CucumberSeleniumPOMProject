Feature: Account page feature

Background: 
Given User has already logged in to application
| username | password | 
| suraj@gmail.com | Myninja@6456 |

Scenario: Account page title
Given User is on accounts page
When user gets the title of the page
Then page title should be "My Account"


Scenario: Accounts section count

Given User is on accounts page
Then user gets account section
|My Account|
|Edit Account|
|Password|
|Address Book|
|Wish List|
|Order History|
|Downloads|
|Recurring payments|
|Reward Points|
|Returns|
|Transactions|
|Newsletter|
|Logout|
And accounts section count should be 13