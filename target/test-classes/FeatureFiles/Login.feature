Feature:To test login Functionality
@Valid
Scenario: Valid Credentials
Given  User clicks the My Account Tab
And     Selects Login option
When   User enters valid username in username field and valid password in password field
And    clicks Login Button
Then   User should see My Account image
@Invalid
Scenario: Invalid Credentials
Given    User clicks the My Account Tab
And      Selects Login option
When     User enters Invalid username in username field and Invalid password in password field
And      clicks Login Button
Then     User should see this warning msg