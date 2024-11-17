Feature: Login feature

Background: 
	Given User is on Salesforce login page

  @PositiveTest @SanityTest @High
  Scenario Outline: Positive Login Validation  	
    When User enters username as <username> and password as <password>
    And User clicks on login button
    Then Verify that user is successfully logged-in
     
 Examples:
 |username							|password	|
 |rm.user@qasit.com			|Test@123	|	
 |maker@salod.stage			|May@2021	|
 
 	 @Login @SanityTest @NegativeTest
  Scenario Outline: Negative Login Validation  	
    When User enters username as <username> and password as <password>
    And User clicks on login button
    Then Login should fail
    And Verify that following <message> is displayed to the user
    
    
Examples:
 |username							|password					|	message	|
 |Invalid@Username.com	|Test@123					|	Your access to salesforce.com has been disabled by your system administrator. Please contact your Administrator for more information.	|
 |rm.user@qasit.com			|InValid_Password	|	Please check your username and password. If you still can't log in, contact your Salesforce administrator.														|
 |Invalid@Username.com	|InValid_Password	|	Your access to salesforce.com has been disabled by your system administrator. Please contact your Administrator for more information.	|
 