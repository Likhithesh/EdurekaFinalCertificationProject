#This file has all the login related use cases.
#Author:Likhithesh


Feature: Signup feature test scenarios of DemoBlaze application
  This feature contains Signup use cases of DemoBlaze application

	Background:
		Given user opens the browser
    When user navigate to Demoblaze Login page
    And User clicks on Signup link
    

  @Signup
  Scenario: Verify the successfull Signup to DemoBlaze application with valid username and password
  	When Enter 'Likhi176259' and '1234' to Signup
    And user clicks on Signup button
    Then popup should be displayed with a message 'Sign up successful.'
    #Then closes the browser

  @Signup
  Scenario: yVerify the unsuccessfull Signup attempt to DemoBlaze application with duplicate username which already exists
    When Enter 'Likhi176251' and '1234' to Signup
    And user clicks on Signup button
    Then popup should be displayed with a message 'This user already exist.'
    #And closes the browser
