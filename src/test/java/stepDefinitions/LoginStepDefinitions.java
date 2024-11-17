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

public class LoginStepDefinitions extends Base {

	LoginPageFactory lpf;
	LogoutPageFactory lopf;
	JavascriptExecutor js;
			
    @When("^User enters username as (.+) and password as (.+)$")
    public void user_enters_username_and_password(String username, String password) throws Throwable {
    	lpf = new LoginPageFactory(driver);
 		lpf.txtUsername().sendKeys(username);
		log.trace("Username entered");
		lpf.txtPassword().sendKeys(password);
		log.trace("Password entered");
    }
	 	 		 	
 	@And("^User clicks on login button$")
    public void user_clicks_on_login_button() throws Throwable {
 		lpf = new LoginPageFactory(driver);
 		lpf.btnLogin().click();
		log.trace("Login button clicked");	
    }

    @Then("^Verify that user is successfully logged-in$")
    public void verify_that_user_is_successfully_loggedin() throws Throwable {	    	
    	lopf = new LogoutPageFactory(driver);
    	Assert.assertTrue(Common.isElementPresent(lopf.linkViewProfile2()));
    }
    
    @Then("^Login should fail$")
    public void login_should_fail() throws Throwable {
    	lpf = new LoginPageFactory(driver);
    	Assert.assertTrue(Common.isElementPresent(lpf.btnLogin()));
    }
       
    @And("^Verify that following (.+) is displayed to the user$")
    public void verify_that_following_is_displayed_to_the_user(String message) throws Throwable {
    	lpf = new LoginPageFactory(driver);
    	//System.out.println("Actual: " + lpf.msgError().getText());
    	//System.out.println("Expected: " + message);
    	Assert.assertEquals(lpf.msgError().getText(), message);
    }
   

	    
	   
	   
}
