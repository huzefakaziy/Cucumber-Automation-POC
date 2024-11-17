package scripts.Loans;

import java.io.IOException;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import loans.PageFactoryObjects.AddIndividualPageObjects;
import utilities.Base;
import utilities.ExcelReader;


public class TC_AddIndividual extends Base{

	private static Logger log = LogManager.getLogger(EndToEndTest.class.getName());	
		
	public static void addIndividual(int i) throws InterruptedException{
		AddIndividualPageObjects addIndividualObj;
		WebDriverWait wait = new WebDriverWait(driver,12);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		Map<String, String> data = null;
		try {
			data = ExcelReader.getTestData(properties.getProperty("ExcelFileName"), "AddIndividual", "AddIndividual_" + i);
		} catch (IOException e) {
			log.fatal("IOException in newLoanApplication method " + e.getMessage());
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
		
		
		addIndividualObj = new AddIndividualPageObjects(driver);
		try {
		wait.until(ExpectedConditions.visibilityOf(addIndividualObj.btnAddIndividual()));
		addIndividualObj.btnAddIndividual().click();
		}catch (StaleElementReferenceException e) {
			Thread.sleep(1500);
			addIndividualObj = new AddIndividualPageObjects(driver);
			wait.until(ExpectedConditions.visibilityOf(addIndividualObj.btnAddIndividual()));
			addIndividualObj.btnAddIndividual().click();
		}

		
		wait.until(ExpectedConditions.visibilityOf(addIndividualObj.txtFirstNameOfPerson()));		
		addIndividualObj.txtFirstNameOfPerson().sendKeys(data.get("IndividualFirstName"));
		
		wait.until(ExpectedConditions.visibilityOf(addIndividualObj.txtLastNameOfPerson()));		
		addIndividualObj.txtLastNameOfPerson().sendKeys(data.get("IndividualLastName"));
		
		//Select Gender 
		//addIndividualObj.listBoxGender().click();
		try
		{
			js.executeScript("arguments[0].click();", addIndividualObj.listBoxGender());	
			if(data.get("Gender").equalsIgnoreCase("male")){
				wait.until(ExpectedConditions.visibilityOf(addIndividualObj.listBoxGenderOptionMale()));
				js.executeScript("arguments[0].click();", addIndividualObj.listBoxGenderOptionMale());			
			}else if(data.get("Gender").equalsIgnoreCase("female")){
				wait.until(ExpectedConditions.visibilityOf(addIndividualObj.listBoxGenderOptionFemale()));
				js.executeScript("arguments[0].click();", addIndividualObj.listBoxGenderOptionFemale());			
			}else if(data.get("Gender").equalsIgnoreCase("corporate")){
				wait.until(ExpectedConditions.visibilityOf(addIndividualObj.listBoxGenderOptionCorporate()));
				js.executeScript("arguments[0].click();", addIndividualObj.listBoxGenderOptionCorporate());			
			}else {
				wait.until(ExpectedConditions.visibilityOf(addIndividualObj.listBoxGenderOptionOthers()));
				js.executeScript("arguments[0].click();", addIndividualObj.listBoxGenderOptionOthers());			
			}
		}catch (TimeoutException e) {
			js.executeScript("arguments[0].click();", addIndividualObj.listBoxGender());	
			if(data.get("Gender").equalsIgnoreCase("male")){
				wait.until(ExpectedConditions.visibilityOf(addIndividualObj.listBoxGenderOptionMale()));
				js.executeScript("arguments[0].click();", addIndividualObj.listBoxGenderOptionMale());			
			}else if(data.get("Gender").equalsIgnoreCase("female")){
				wait.until(ExpectedConditions.visibilityOf(addIndividualObj.listBoxGenderOptionFemale()));
				js.executeScript("arguments[0].click();", addIndividualObj.listBoxGenderOptionFemale());			
			}else if(data.get("Gender").equalsIgnoreCase("corporate")){
				wait.until(ExpectedConditions.visibilityOf(addIndividualObj.listBoxGenderOptionCorporate()));
				js.executeScript("arguments[0].click();", addIndividualObj.listBoxGenderOptionCorporate());			
			}else {
				wait.until(ExpectedConditions.visibilityOf(addIndividualObj.listBoxGenderOptionOthers()));
				js.executeScript("arguments[0].click();", addIndividualObj.listBoxGenderOptionOthers());			
			}
		}
		
		addIndividualObj.txtDOB().sendKeys(data.get("DOB"));
		addIndividualObj.txtPAN().clear();
		addIndividualObj.txtPAN().sendKeys(data.get("PAN"));
		addIndividualObj.txtEmail().clear();
		addIndividualObj.txtEmail().sendKeys(data.get("Email ID"));
		addIndividualObj.txtPrimaryContact().sendKeys(data.get("PrimaryContact"));
		addIndividualObj.txtAltContact().sendKeys(data.get("AltContact"));
		addIndividualObj.txtExistingBBGLimit().sendKeys(data.get("ExistingBBGLimit"));
		addIndividualObj.txtProposedBBGLimit().sendKeys(data.get("ProposedBBGLimit"));
		
		if(data.get("TaggedWithinGrp").equalsIgnoreCase("yes") ) {
			js.executeScript("arguments[0].click();", addIndividualObj.chkTaggedWithinGrp());			
		}
		
		if(data.get("IsPromoter").equalsIgnoreCase("yes") ) {
			js.executeScript("arguments[0].click();", addIndividualObj.chkPromoter());			
		}
		
		//Select Promoter Designation		
		js.executeScript("arguments[0].click();", addIndividualObj.listBoxDesignation());
		if(data.get("Promoter_Designation").equals("Proprietor")){
			wait.until(ExpectedConditions.visibilityOf(addIndividualObj.listBoxDesignationProprietor()));
			js.executeScript("arguments[0].click();", addIndividualObj.listBoxDesignationProprietor());			
		}else if(data.get("Promoter_Designation").equals("Partner")){
			wait.until(ExpectedConditions.visibilityOf(addIndividualObj.listBoxDesignationPartner()));
			js.executeScript("arguments[0].click();", addIndividualObj.listBoxDesignationPartner());			
		}else if(data.get("Promoter_Designation").equals("Director")){
			wait.until(ExpectedConditions.visibilityOf(addIndividualObj.listBoxDesignationDirector()));
			js.executeScript("arguments[0].click();", addIndividualObj.listBoxDesignationDirector());			
		}else if(data.get("Promoter_Designation").equals("Shareholder")){
			wait.until(ExpectedConditions.visibilityOf(addIndividualObj.listBoxDesignationShareholder()));
			js.executeScript("arguments[0].click();", addIndividualObj.listBoxDesignationShareholder());			
		}else if(data.get("Promoter_Designation").equals("Key Management Personnel")){
			wait.until(ExpectedConditions.visibilityOf(addIndividualObj.listBoxDesignationKeyManagementPersonnel()));
			js.executeScript("arguments[0].click();", addIndividualObj.listBoxDesignationKeyManagementPersonnel());			
		}else if(data.get("Promoter_Designation").equals("Property Owner")){
			wait.until(ExpectedConditions.visibilityOf(addIndividualObj.listBoxDesignationPropertyOwner()));
			js.executeScript("arguments[0].click();", addIndividualObj.listBoxDesignationPropertyOwner());			
		}else if(data.get("Promoter_Designation").equals("Other")){
			wait.until(ExpectedConditions.visibilityOf(addIndividualObj.listBoxDesignationOther()));
			js.executeScript("arguments[0].click();", addIndividualObj.listBoxDesignationOther());			
		}
		
		addIndividualObj.txtShareholding().sendKeys(data.get("Shareholding"));
		
		
		js.executeScript("arguments[0].click();", addIndividualObj.listBoxQualification());
		
		if(data.get("Qualification").equalsIgnoreCase("Graduate")){
			wait.until(ExpectedConditions.visibilityOf(addIndividualObj.listBoxQualificationOptionGraduate()));
			js.executeScript("arguments[0].click();", addIndividualObj.listBoxQualificationOptionGraduate());			
		}
		
		addIndividualObj.txtExperience().sendKeys(data.get("Experience"));
		addIndividualObj.txtAssociatedSince().sendKeys(data.get("AssociatedSince"));
		addIndividualObj.txtAdditionalRemarks().sendKeys(data.get("AdditionalRemarks"));
		
		if(data.get("IsGuarantor").equalsIgnoreCase("yes") ) {
			js.executeScript("arguments[0].click();", addIndividualObj.chkGuarantor());			
		}
		
		addIndividualObj.txtVoterID().sendKeys(data.get("VoterID"));
		addIndividualObj.txtDrivingLicense().sendKeys(data.get("DrivingLicense"));
		addIndividualObj.txtAddLine1().sendKeys(data.get("AddressLine1"));
		addIndividualObj.txtAddLine2().sendKeys(data.get("AddressLine2"));
		addIndividualObj.txtAddLine3().sendKeys(data.get("AddressLine3"));
		//addIndividualObj.txtState().sendKeys(data.get("State"));
		//addIndividualObj.txtCity().sendKeys(data.get("City"));
		
		addIndividualObj.txtPinCode().click();
		addIndividualObj.txtPinCode().sendKeys(data.get("PinCode"));
		Thread.sleep(1000);
		addIndividualObj.txtNetWorth().click();
		//WebElement pincodeOptionElement = driver.findElement(By.xpath("//li[@role='presentation' and @data-name='" + data.get("PinCode") + "']"));
		WebElement pincodeOptionElement = driver.findElement(By.xpath("//ul[@role='presentation' and @class='slds-listbox slds-listbox_vertical']/li[2]"));
		wait.until(ExpectedConditions.visibilityOf(pincodeOptionElement));
		//pincodeOptionElement.click();
		js.executeScript("arguments[0].click();", pincodeOptionElement);
		
		//Actions action = new Actions(driver);
		//action.moveToElement(pincodeOptionElement).click().build().perform();
		
		addIndividualObj.txtNetWorth().sendKeys(data.get("NetWorth"));
		if(data.get("IsConsentTaken").equalsIgnoreCase("yes") ) {
			js.executeScript("arguments[0].click();", addIndividualObj.chkConsentFormStatus());			
		}
		
		//Actions actions = new Actions(driver);
		//actions.moveToElement( addIndividualObj.btnSave()).click().build().perform();
		
		js.executeScript("arguments[0].click();", addIndividualObj.btnSave());	
		//addIndividualObj.btnSave().click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal-body scrollable slds-modal__content slds-p-around--medium']")));
		
						
	}
	
	

}
