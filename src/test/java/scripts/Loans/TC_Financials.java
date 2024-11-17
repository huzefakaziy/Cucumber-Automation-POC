package scripts.Loans;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import loans.PageFactoryObjects.FinancialsPageObjects;
import loans.PageFactoryObjects.HeaderPageObjects;
import utilities.Base;
import utilities.Common;


public class TC_Financials extends Base{	

	private static Logger log = LogManager.getLogger(EndToEndTest.class.getName());
	

	/*
	public void testScript()
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		String searchString = "0005569";
		driver.findElement(By.xpath("//input[@title='Search Loan Applications and more' or @title='Search...']")).sendKeys(searchString);
		driver.findElement(By.xpath("//input[@title='Search Loan Applications and more' or @title='Search...']")).sendKeys(Keys.ENTER);
		String dynamicpath = "(//span[@title='" + searchString + "'])[2]/parent::span/parent::td/parent::tr/th/span/a";
		driver.findElement(By.xpath(dynamicpath)).click();
	}*/
		
	
	public static void financials() throws InterruptedException 
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		Actions actions = new Actions(driver);
		
		log.debug("financials() Method called from FinancialsModule class");
		WebDriverWait wait = new WebDriverWait(driver, 15);	
		HeaderPageObjects headerObj = new HeaderPageObjects(driver);
		//wait.until(ExpectedConditions.elementToBeClickable(headerObj.menuLinkCaseEvaluation()));
		if(Common.isElementPresent(headerObj.menuLinkFinancials()))
			headerObj.menuLinkFinancials().click();
		else
			headerObj.menuLinkCaseEvaluation().click();
		FinancialsPageObjects financialObj = new FinancialsPageObjects(driver);
				
		wait.until(ExpectedConditions.visibilityOf(financialObj.btnUploadCSVFile()));
		wait.until(ExpectedConditions.elementToBeClickable(financialObj.btnUploadCSVFile()));
		financialObj.btnUploadCSVFile().click();
		//js.executeScript("arguments[0].scrollIntoView(true);", financialObj.btnSave());			
		//wait.until(ExpectedConditions.elementToBeClickable(financialObj.btnUploadCSVFile()));
		//actions.moveToElement(financialObj.btnUploadCSVFile()).click().build().perform();
		//js.executeScript("arguments[0].click();", financialObj.btnUploadCSVFile());
		
		
		try {
			Thread.sleep(2000);			
			Runtime.getRuntime().exec( properties.getProperty("FinancialsCSVFile") );
		} catch (IOException e) {				
			e.printStackTrace();
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'NewKonceptPolypro.csv')]")));
		//js.executeScript("arguments[0].click();", financialObj.btnSave());
		financialObj.btnSave().click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//lightning-spinner[@class='slds-spinner_container']")));
		
		wait.until(ExpectedConditions.visibilityOf(financialObj.btnUploadExcelFile()));
		wait.until(ExpectedConditions.elementToBeClickable(financialObj.btnUploadExcelFile()));
		//js.executeScript("arguments[0].click();", financialObj.btnUploadExcelFile());
		//actions.moveToElement(financialObj.btnUploadExcelFile()).click().build().perform();
		financialObj.btnUploadExcelFile().click();
		
		
		try {
			Thread.sleep(2000);
			Runtime.getRuntime().exec( properties.getProperty("FinancialsExcelFile") );
		} catch (IOException e) {				
			e.printStackTrace();
		}
		
			
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'NewKonceptPolypro.xlsx')]")));
		//js.executeScript("arguments[0].click();", financialObj.btnSave());
		financialObj.btnSave().click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//lightning-spinner[@class='slds-spinner_container']")));
						
		wait.until(ExpectedConditions.elementToBeClickable(financialObj.btnRunFinancialAnalysis()));	
		js.executeScript("arguments[0].click();", financialObj.btnRunFinancialAnalysis());
		//financialObj.btnRunFinancialAnalysis().click();
		
		wait.until(ExpectedConditions.visibilityOf(financialObj.btnOk()));
		wait.until(ExpectedConditions.elementToBeClickable(financialObj.btnOk()));
		financialObj.btnOk().click();
		
		Thread.sleep(2000);
		//js.executeScript("arguments[0].click();", financialObj.btnRefresh());
		
		actions.moveToElement(financialObj.btnRefresh()).click().build().perform();
		
		while(!financialObj.lblFinancialStatus().getText().trim().equals("Success")) 
		{
			Thread.sleep(2000);
			financialObj.btnRefresh().click();	
			if(financialObj.lblFinancialStatus().getText().equals("Error"))
				Assert.assertEquals("Error", "Success");
			if(financialObj.lblFinancialStatus().getText().equals("Retry"))
				Assert.assertEquals("Retry", "Success");			
			Thread.sleep(2000);
					
		}		
		
	}

}
