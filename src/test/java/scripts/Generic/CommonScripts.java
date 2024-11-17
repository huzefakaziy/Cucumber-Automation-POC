package scripts.Generic;

import java.io.IOException;
import java.util.Map;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import common.PageFactoryObjects.LandingPageFactory;
import common.PageFactoryObjects.LoginPageFactory;
import common.PageFactoryObjects.LogoutPageFactory;
import utilities.Base;
import utilities.ExcelReader;

public class CommonScripts extends Base {
		
	public static JavascriptExecutor js;
	public static LoginPageFactory lpf;
	public static LogoutPageFactory lopf;
	public static LandingPageFactory lapf;
	
	public static void initialize() {
		log.debug("Initializing WebDriver");
		driver = getDriver();
		log.debug("Driver is Initialized");
		driver.get(properties.getProperty("url"));
		log.debug("URL launched");
	}	
	
	public static void login(String excelFileName, String excelWorkSheetName, String testCaseName)
	{	
		log.trace("Login class initialized");
		lpf = new LoginPageFactory(driver);
		
		try 
		{
			Map<String, String> testData = ExcelReader.getTestData(excelFileName, excelWorkSheetName, testCaseName);
			lpf.txtUsername().sendKeys(testData.get("UserName"));
			log.trace("Username entered");
			lpf.txtPassword().sendKeys(testData.get("Password"));
			log.trace("Password entered");
			lpf.btnLogin().click();
			log.trace("Login button clicked");		
			
			lapf = new LandingPageFactory(driver);
			if(testCaseName.equalsIgnoreCase("CMLogin")) 
			{
				//Assert.assertEquals(lpf.lblAppName().getText(), "OD App");
			}
			else if(testCaseName.equalsIgnoreCase("RMLogin")) 
			{
				if(!lapf.lblCRMApp().getText().equalsIgnoreCase("RM App"))
				{
					lapf.btnLauncher().click();
					lapf.lnkCRMApp().click();
				}	
				//Assert.assertEquals(lpf.lblAppName().getText(), "RM App");				
			}			
			
			log.info("Login Success");
			
		} 
		catch (IOException e) {	
			log.fatal("IOException in login method " + e.getMessage());
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		catch (NoSuchElementException e) {
			log.fatal("NoSuchElementException in login method " + e.getMessage());
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		catch (Exception e) {
			log.fatal("Exception in login method " + e.getMessage());
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
	}
	
	public static void logOut() {
		
		js = ((JavascriptExecutor) driver);
		try 
		{
		log.debug("logOut method called");
		lopf = new LogoutPageFactory(driver);		
		js.executeScript("arguments[0].click();", lopf.linkViewProfile());		
		log.debug("View Profile Clicked");
		lopf.linkLogOut().click();		
		log.debug("Log Out Clicked");
		}
		catch (NoSuchElementException e) {
			log.fatal("NoSuchElementException in logOut method " + e.getMessage());
			System.out.println("NoSuchElementException in logOut method ");
			System.out.println(e.getMessage());
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		catch (Exception e) {
			log.fatal("Exception in logOut method " + e.getMessage());
			System.out.println(e.getMessage());
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	

}
