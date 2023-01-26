@Forgot
Feature:To test Forgot Password functionality
Background:
Given user is on homepage
And  User clicks the My Account Tab

Scenario: To validate the email successfully sent
Given    Selects Login option
When     User clicks Forgot password link
And      User Enters the email Id 
|akash4509744@gmail.com|
And      Clicks Continue Button
Then     User should the email succesfully sent message
| An email with a confirmation link has been sent your email address.|




