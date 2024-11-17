package scripts.Loans;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import scripts.Generic.CommonScripts;
import utilities.Base;


public class EndToEndTest extends Base {
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(EndToEndTest.class.getName());	
	WebDriverWait wait;
	JavascriptExecutor js;
	String script;
	String tmp;
	loans.PageFactoryObjects.NewLoanAppPageObjects newLoanObj;
	loans.PageFactoryObjects.HeaderPageObjects headerObj;
	Select s;
	Actions actions;

	@BeforeSuite
	public void initialize() {
		CommonScripts.initialize();
	}
	
	
	@BeforeTest
	public void loginTest() throws IOException {
		log.debug(" loginTest() called in EndToEndTest");		
		CommonScripts.login(properties.getProperty("ExcelFileName"), "LoginTest", "RMUser");
	}
	

	@Test()
	public void endToEnd() throws InterruptedException  {
		for(int i=1; i<=Integer.parseInt(properties.getProperty("dataCount")); i++)
		{
			TC_NewLoanApplication.newLoanApplication(i);
			TC_AddIndividual.addIndividual(i);
			TC_DocCheck.docCheck();
			TC_Financials.financials();
		}
	}
		
	

	@AfterTest
	public void teardown() {
		log.debug("teardown() called in CreateLoanApplicationTest");
		//CommonScripts.logOut();

	}

}
