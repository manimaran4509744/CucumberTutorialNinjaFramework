@Cart
Feature:To test AddToCart functionality
Background:
Given user is on homepage
And  User clicks the My Account Tab
And     Selects Login option
And     User enters valid username in username field and valid password in password field
And clicks Login Button
And  User enters product name
|Hp Lp|
And clicks search button
Scenario: To validate the successmsg 
Given User clicks product image
When  User clicks Add to cart button
Then  User should see successmsg
|Success: You have added HP LP3065 to your shopping cart!|




