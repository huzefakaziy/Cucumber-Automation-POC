package scripts.Loans;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import scripts.Generic.CommonScripts;
import utilities.Base;


public class IndividualTest extends Base {
	
	private static Logger log = LogManager.getLogger(EndToEndTest.class.getName());	
		
	@BeforeSuite
	public void initialize() {
		CommonScripts.initialize();
	}	
	
	@BeforeTest
	public void loginTest() throws IOException {
		log.debug(" loginTest() called in IndividualTest");
		CommonScripts.login(properties.getProperty("ExcelFileName"), "LoginTest", "RMUser");
	}
	
	@Test(priority=1)
	public static void newLoanApplication() throws InterruptedException
	{
		int i = 1;
		TC_NewLoanApplication.newLoanApplication(i);
	}

	
	@Test(priority=2)
	public static void addIndividual() throws InterruptedException{
		int i = 1;
		TC_AddIndividual.addIndividual(i);	
	}
	
	@Test(priority=3)
	public static void docCheck()
	{
		TC_DocCheck.docCheck();
	}
	
	@Test(priority=4)
	public static void financials() throws InterruptedException {		
		TC_Financials.financials();	
	}
	
	@AfterTest
	public void teardown() {
		log.debug("teardown() called in CreateLoanApplicationTest");
		CommonScripts.logOut();

	}
	
}
