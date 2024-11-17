package stepDefinitions;

import io.cucumber.java.en.Given;
import scripts.Generic.CommonScripts;
import utilities.Base;


public class CommonStepDefinitions extends Base {
	
	 @Given("^User is on Salesforce login page$")
	    public void user_is_on_salesforce_login_page() throws Throwable {
		 CommonScripts.initialize();
	    }
	
	 @Given("^\"([^\"]*)\" has logged into Salesforce application$")
	    public void something_has_logged_into_salesforce_application(String user) throws Throwable {
		 System.out.println("User Name : " + user);
		 CommonScripts.login(properties.getProperty("ExcelFileName"), "LoginTest", user);
	    }
    
	   
}
