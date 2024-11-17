package stepDefinitions;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import common.PageFactoryObjects.LoginPageFactory;
import common.PageFactoryObjects.LogoutPageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.Base;
import utilities.Common;


public class LogoutStepDefinition extends Base {

	LoginPageFactory lpf;
	LogoutPageFactory lopf;
	JavascriptExecutor js;

    
    @When("^User clicks on logout button$")
    public void user_clicks_on_logout_button() throws Throwable {	
    	lopf = new LogoutPageFactory(driver);	    	
    	log.debug("logOut method called");	 
    	if(Common.isElementPresent(lopf.linkViewProfile()))
    	{
			lopf.linkViewProfile().click();		
			log.debug("View Profile Clicked");
			lopf.linkLogOut().click();		
			log.debug("Log Out Clicked");
    	}
    	else
    		Assert.assertTrue(false);
    }

    @Then("^Users is logged-out from the application$")
    public void users_is_loggedout_from_the_application() throws Throwable {	 
    	lpf = new LoginPageFactory(driver);
    	Assert.assertTrue(Common.isElementPresent(lpf.btnLogin()));
    }
    
    @And("^Close the browser$")
    public void close_the_browser() throws Throwable {
    	driver.quit();
    }
	   
}
