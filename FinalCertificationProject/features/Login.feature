#This file has all the login related use cases.
#Author:Likhithesh


Feature: Login feature test scenarios of DemoBlaze application
  This feature contains login use cases of DemoBlaze application

	Background:
		Given user opens the browser
    When user navigate to Demoblaze Login page
		And User clicks on Login link
		
  @Login
  Scenario: Verify the successfull Login to DemoBlaze application with valid credentials
    And Enter username as 'Likhithesh' and password as 'Test123'
    And user clicks on Login button
    Then the home page should be displayed with welcome page
    And user clicks on Logout button
    #Then closes the browser

  @Login
  Scenario: Verify the unsuccessfull Login attempt to DemoBlaze application where user doesnot exits
    And Enter username as 'Likhi' and password as '123'
    And user clicks on Login button
    Then popup should be displayed with a message 'User does not exist.'
    #And closes the browser
