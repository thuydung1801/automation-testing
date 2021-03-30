Feature: Login

Scenario: Verify Login success with valid username and password
Given Go to the "glamiraUrl" url
When I login with valid username and password
Then I should be on user profile page
And After I click in Sign out button