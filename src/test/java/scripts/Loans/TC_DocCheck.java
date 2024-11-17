package scripts.Loans;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import loans.PageFactoryObjects.DocCheckPageObjects;
import loans.PageFactoryObjects.HeaderPageObjects;
import utilities.Base;
import utilities.Common;


public class TC_DocCheck extends Base {
	private static Logger log = LogManager.getLogger(EndToEndTest.class.getName());

	public static void docCheck()
	{
		log.debug("docCheck() Method called from DocCheckModule class");
		WebDriverWait wait = new WebDriverWait(driver, 10);		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		HeaderPageObjects headerObj = new HeaderPageObjects(driver);
		
		if(Common.isElementPresent(headerObj.menuLinkDocCheck()))
			js.executeScript("arguments[0].click();", headerObj.menuLinkDocCheck());
		else
			js.executeScript("arguments[0].click();", headerObj.menuLinkChecklist());
		//wait.until(ExpectedConditions.visibilityOf(headerObj.menuLinkDocCheck()));	
		//wait.until(ExpectedConditions.elementToBeClickable(headerObj.menuLinkDocCheck()));
		//headerObj.linkDocCheck().click();
		//js.executeScript("arguments[0].click();", headerObj.menuLinkDocCheck());	
		DocCheckPageObjects docCheckObj = new DocCheckPageObjects(driver);
		WebElement docCheckTable = driver
				.findElement(By.xpath("//div[@class='slds-gutters slds-wrap slds-m-horizontal_xx-small']/table"));

		int linkCount = docCheckTable.findElements(By.tagName("a")).size();

		for (int i = 0; i < linkCount; i++) {
			docCheckTable = driver
					.findElement(By.xpath("//div[@class='slds-gutters slds-wrap slds-m-horizontal_xx-small']/table"));
			wait.until(ExpectedConditions.elementToBeClickable(docCheckTable.findElements(By.tagName("a")).get(i)));
			js.executeScript("arguments[0].click();", docCheckTable.findElements(By.tagName("a")).get(i));
			js.executeScript("arguments[0].click();", docCheckObj.listBoxDocStatus());			
			js.executeScript("arguments[0].click();", docCheckObj.listBoxDocStatusOptionReceivedHardCopy());
			js.executeScript("arguments[0].click();", docCheckObj.btnSave());
			wait.until(ExpectedConditions.stalenessOf(docCheckTable.findElements(By.tagName("a")).get(i)));
		}
		
	}

}
