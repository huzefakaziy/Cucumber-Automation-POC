package scripts.Loans;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import loans.PageFactoryObjects.NewLoanAppPageObjects;
import utilities.Base;
import utilities.Common;
import utilities.ExcelReader;

public class TC_NewLoanApplication extends Base {
	
	private static Logger log = LogManager.getLogger(EndToEndTest.class.getName());	
	
	public static void newLoanApplication(int i) throws InterruptedException
	{
		log.debug("newLoanApplication() Method called from CreateNewLoanApplicationModule");
		
		WebDriverWait wait = new WebDriverWait(driver,15);		
		Map<String, String> data = null;
		try {
			data = ExcelReader.getTestData(properties.getProperty("ExcelFileName"), "RM-CreateLoanApp", "CreateLoanApp_" + i);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.fatal("IOException in newLoanApplication method " + e.getMessage());
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		NewLoanAppPageObjects newLoanObj = new NewLoanAppPageObjects(driver);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		
		try {
		newLoanObj.btnArrow().click();
		newLoanObj.LoanApps().click();
		}catch (StaleElementReferenceException e) {
			Thread.sleep(1500);
			newLoanObj = new NewLoanAppPageObjects(driver);
			newLoanObj.btnArrow().click();
			newLoanObj.LoanApps().click();
		}
		
		/*
		try {
		wait.until(ExpectedConditions.visibilityOf(newLoanObj.LoanApps()));
		wait.until(ExpectedConditions.elementToBeClickable(newLoanObj.LoanApps()));
		newLoanObj.LoanApps().click();
		}catch (StaleElementReferenceException e) {
			Thread.sleep(1500);
			newLoanObj = new NewLoanAppPageObjects(driver);
			//wait.until(ExpectedConditions.elementToBeClickable(newLoanObj.LoanApps()));
			newLoanObj.LoanApps().click();
		}catch (NoSuchElementException e) {
			newLoanObj.btnArrow().click();
			newLoanObj.LoanApps().click();
		}*/
		
		/*
		wait.until(ExpectedConditions.visibilityOf(newLoanObj.ListViewPickerLoanApps()));
		newLoanObj.ListViewPickerLoanApps().click();		
		//wait.until(ExpectedConditions.visibilityOf(newLoanObj.ListViewOption_AssignedToMe()));
		newLoanObj.ListViewOption_AllCases().click();
		*/
		//wait.until(ExpectedConditions.visibilityOf(newLoanObj.btnAddCase()));
		//wait.until(ExpectedConditions.elementToBeClickable(newLoanObj.btnAddCase()));
		if(Common.isElementPresent(newLoanObj.btnAddCase()))
			js.executeScript("arguments[0].click();", newLoanObj.btnAddCase());
		//newLoanObj.btnAddCase().click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='accessibility title']")));
		if(Common.isElementPresent(newLoanObj.btnBBGFlow()))
			newLoanObj.btnBBGFlow().click();
		
		//1st Page
		//wait.until(ExpectedConditions.visibilityOf(newLoanObj.txtApplicationName()));
		newLoanObj.txtApplicationName().sendKeys(data.get("LoanAppName"));
		
		Select s = new Select(newLoanObj.SelectSource());
		s.selectByVisibleText(data.get("Source").trim());
		
		s = new Select(newLoanObj.SelectProposalType());
		s.selectByVisibleText(data.get("ProposalType").trim());
					
		s = new Select(newLoanObj.txtProgram());
		s.selectByVisibleText(data.get("Program").trim());
		
		newLoanObj.txtEmail().sendKeys(data.get("Email"));	
		
		wait.until(ExpectedConditions.visibilityOf(newLoanObj.txtBranch()));		
		newLoanObj.txtBranch().sendKeys(data.get("Branch").trim());
		Thread.sleep(1000);
		newLoanObj.txtBranch().sendKeys(Keys.BACK_SPACE);
		newLoanObj.optionsBranch().click();
		
		newLoanObj.txtDOI().sendKeys(data.get("DOI"));
		newLoanObj.txtContactNo().sendKeys(data.get("ContactNumber"));
		newLoanObj.txtPan().sendKeys(data.get("PAN"));
		
		if(data.get("PropertyOwner").equalsIgnoreCase("yes") ) {
			if(!newLoanObj.chkPropertyOwner().isSelected())	newLoanObj.chkPropertyOwner().click();
		}
			
		if(data.get("SignedConsentForm").equalsIgnoreCase("yes") ) {
			if(!newLoanObj.chkSignedConsentForm().isSelected())	newLoanObj.chkSignedConsentForm().click();
		}		
		
		newLoanObj.btnNext().click();
		
		//2nd Page
		newLoanObj.txtLoanAmt().click();		
		newLoanObj.txtLoanAmt().sendKeys(Keys.SHIFT, Keys.HOME);		
		newLoanObj.txtLoanAmt().sendKeys(Keys.DELETE);		
		newLoanObj.txtLoanAmt().sendKeys(data.get("LoanAmt"));
		
		newLoanObj.txtNetWorth().click();		
		newLoanObj.txtNetWorth().sendKeys(Keys.SHIFT, Keys.HOME);		
		newLoanObj.txtNetWorth().sendKeys(Keys.DELETE);
		newLoanObj.txtNetWorth().sendKeys(data.get("NetWorth"));
		
		newLoanObj.txtTurnover().sendKeys(data.get("Turnover"));		
		newLoanObj.txtNetProfit().sendKeys(data.get("NetProfit"));
		newLoanObj.btnNext().click();
		
		try {
		newLoanObj.selectIndustryType().sendKeys(data.get("IndustryType"));		
		newLoanObj.optionsIndustryType().click();
		}catch (NoSuchElementException e) {
			newLoanObj.selectIndustryType().sendKeys(Keys.BACK_SPACE);	
			newLoanObj.optionsIndustryType().click();
		}
		
		s = new Select(newLoanObj.selectNatureOfBusiness());
		s.selectByVisibleText(data.get("NatureOfBusiness"));
		
		s = new Select(newLoanObj.selectBankingArrangement());
		s.selectByVisibleText(data.get("BankingArrangement"));
		
		s = new Select(newLoanObj.selectConstitution());
		s.selectByVisibleText(data.get("Constitution"));
		
		newLoanObj.txtPresentBanking().sendKeys(data.get("PresentBanking"));
		newLoanObj.optionsPresentBanking().click();
		
		s = new Select(newLoanObj.selectPSLClassification());
		s.selectByVisibleText(data.get("PSLClassification"));
		
		s = new Select(newLoanObj.selectPSLSubClassification());
		s.selectByVisibleText(data.get("PSLSubClassification"));
		
		s = new Select(newLoanObj.selectPurposeProposal());
		s.selectByVisibleText(data.get("PurposeProposal"));
			
		newLoanObj.btnNext().click();
		
		newLoanObj.txtBusinessDescription().sendKeys(data.get("BusinessDescription"));
		newLoanObj.txtPromoterBackground().sendKeys(data.get("PromotorBackground"));
		newLoanObj.txtCustomerSupplier().sendKeys(data.get("CustomerSupplier"));
		newLoanObj.txtRisk().sendKeys(data.get("Risk"));
		newLoanObj.btnNext().click();
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(newLoanObj.btnNext()));
		newLoanObj.btnNext().click();
		
		wait.until(ExpectedConditions.visibilityOf(newLoanObj.selectAddressType()));		
		s = new Select(newLoanObj.selectAddressType());
		s.selectByVisibleText(data.get("Address Type"));
		
		newLoanObj.txtAddressLine_1().sendKeys(data.get("AddressLine1"));
		newLoanObj.txtAddressLine_2().sendKeys(data.get("AddressLine2"));
		newLoanObj.txtAddressLine_3().sendKeys(data.get("AddressLine3"));
		//newLoanObj.txtCity().sendKeys(data.get("City"));
		//newLoanObj.txtState().sendKeys(data.get("State"));
		
		newLoanObj.txtPincode().sendKeys(data.get("Pincode"));
		newLoanObj.optionsPincode().click();
		
		
		newLoanObj.btnNext().click();
		
		//Collateral Page
		wait.until(ExpectedConditions.visibilityOf(newLoanObj.txtCollateralType()));
		try {
			newLoanObj.txtCollateralType().sendKeys(data.get("Collateral Type").trim());
			newLoanObj.optionsCollateralType().click();
		}catch (NoSuchElementException e) {
			newLoanObj.txtCollateralType().sendKeys(Keys.BACK_SPACE);			
			newLoanObj.optionsCollateralType().click();
		}
		
		
		newLoanObj.txtCollateralAmt().sendKeys(data.get("CollateralAmt"));
		newLoanObj.txtCollateralAddress1().sendKeys(data.get("CollateralAddressLine1"));
		newLoanObj.txtCollateralAddress2().sendKeys(data.get("CollateralAddressLine2"));
		newLoanObj.txtCollateralPincode().sendKeys(data.get("CollateralPincode"));
		if(Common.isElementPresent(newLoanObj.optionsCollateralPincode1()))
			newLoanObj.optionsCollateralPincode1().click();
		else
			newLoanObj.optionsCollateralPincode2().click();
		
		/*s = new Select(newLoanObj.selectChargeType());
		s.selectByVisibleText(data.get("Charge Type"));*/
		
			
		newLoanObj.btnNext().click();
		
		wait.until(ExpectedConditions.visibilityOf(newLoanObj.lblLimit_Other_Banks()));
		newLoanObj.btnNext().click();
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(data.get("LoanAppName")))));
		driver.findElement(By.linkText(data.get("LoanAppName"))).click();
		
				
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String WindowID = null;
		while(it.hasNext())
		{
			WindowID = it.next();			
		}
		if(WindowID!=null)		
			driver.switchTo().window(WindowID);
	}

}
