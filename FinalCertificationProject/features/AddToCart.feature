#Author: Likhithesh


Feature: To validate add to cart feature test scenarios of DemoBlaze application
    
  @AddToCart
  Scenario: zVerify if user able to add the laptop to the cart successfully
    Given user opens the browser
    When user navigate to Demoblaze Login page
		And User clicks on Login link
		And Enter username as 'Likhithesh' and password as 'Test123'
    And user clicks on Login button
    Then the home page should be displayed with welcome page
    And User clicks on Laptops link
    Then clicks on Sonyvaioi5 laptop
    And finally clicks on Add to cart button
    Then popup should be displayed with a message 'Product added.'
    And user clicks on Cart link
    Then Verify if the product added to cart successfully
