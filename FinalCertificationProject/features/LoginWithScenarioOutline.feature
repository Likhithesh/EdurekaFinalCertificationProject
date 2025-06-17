#This file has all the login related use cases.
#Author:Likhithesh


Feature: Login feature Wrong password scenarios of DemoBlaze application
  This feature contains login use cases of DemoBlaze application

	Background:
		Given user opens the browser
    When user navigate to Demoblaze Login page

  @Login
  Scenario Outline: Verify the unsuccessfull Login attempts to DemoBlaze application with wrong password
  	And User clicks on Login link
    And Enter username as '<username>' and password as '<passsword>'
    And user clicks on Login button
    Then popup should be displayed with a message 'Wrong password.'
    #And closes the browser
    
    Examples:
    | username | passsword |
    | Likhithesh | 1234 |
    | Likhithesh | 123	|
