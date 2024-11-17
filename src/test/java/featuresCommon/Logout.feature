Feature: Logout feature

Background: 
	Given User is on Salesforce login page

  
  @SmokeTest @Low @PositiveTest @Logout
  Scenario: Logout of application1
  	Given "RMUser" has logged into Salesforce application
    When User clicks on logout button
    Then Users is logged-out from the application

 
    

    