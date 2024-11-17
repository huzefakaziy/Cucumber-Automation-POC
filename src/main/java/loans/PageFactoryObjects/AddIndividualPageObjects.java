package loans.PageFactoryObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddIndividualPageObjects {

	WebDriver driver = null;
	public AddIndividualPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h4[text()='Add Individual']")
	WebElement pageHeader;
	public WebElement pageHeader() { return pageHeader; }
	
	@FindBy(xpath="//button[@name='FinServ__FinancialAccount__c.Add_Individual']")
	WebElement btnAddIndividual;
	public WebElement btnAddIndividual() { return btnAddIndividual; }
	
	@FindBy(xpath="//input[@placeholder='First Name of Person']")
	WebElement txtFirstNameOfPerson;
	public WebElement txtFirstNameOfPerson() { return txtFirstNameOfPerson; }
	
	@FindBy(xpath="//input[@placeholder='Last Name of Person']")
	WebElement txtLastNameOfPerson;
	public WebElement txtLastNameOfPerson() { return txtLastNameOfPerson; }
	
	@FindBy(xpath="//input[@name='Gender__c']")
	WebElement listBoxGender;
	public WebElement listBoxGender() { return listBoxGender; }
	
	@FindBy(xpath="//span[@title='Male']")
	WebElement listBoxGenderOptionMale;
	public WebElement listBoxGenderOptionMale() { return listBoxGenderOptionMale; }
	
	@FindBy(xpath="//span[@title='Female']")
	WebElement listBoxGenderOptionFemale;
	public WebElement listBoxGenderOptionFemale() { return listBoxGenderOptionFemale; }
	
	@FindBy(xpath="//span[@title='Corporate']")
	WebElement listBoxGenderOptionCorporate;
	public WebElement listBoxGenderOptionCorporate() { return listBoxGenderOptionCorporate; }
	
	@FindBy(xpath="//span[@title='Others']")
	WebElement listBoxGenderOptionOthers;
	public WebElement listBoxGenderOptionOthers() { return listBoxGenderOptionOthers; }
	
	@FindBy(xpath="//input[@name='DOB_DD_MM_YYYY__c']")
	WebElement txtDOB;
	public WebElement txtDOB() { return txtDOB; }
	
	@FindBy(xpath="//input[@name='PAN__c']")
	WebElement txtPAN;
	public WebElement txtPAN() { return txtPAN; }
	
	@FindBy(xpath="//input[@name='Email_ID__c']")
	WebElement txtEmail;
	public WebElement txtEmail() { return txtEmail; }
	
	@FindBy(xpath="//input[@name='Contact_Number__c']")
	WebElement txtPrimaryContact;
	public WebElement txtPrimaryContact() { return txtPrimaryContact; }
	
	@FindBy(xpath="//input[@name='Alternate_Contact__c']")
	WebElement txtAltContact;
	public WebElement txtAltContact() { return txtAltContact; }
	
	@FindBy(xpath="//input[@name='Existing_BBG_Limits__c']")
	WebElement txtExistingBBGLimit;
	public WebElement txtExistingBBGLimit() { return txtExistingBBGLimit; }
	
	@FindBy(xpath="//input[@name='Proposed_BBG_Limits__c']")
	WebElement txtProposedBBGLimit;
	public WebElement txtProposedBBGLimit() { return txtProposedBBGLimit; }
	
	@FindBy(xpath="//input[@name='Within_limit_tagged_as_a_group__c']")
	WebElement chkTaggedWithinGrp;
	public WebElement chkTaggedWithinGrp() { return chkTaggedWithinGrp; }
	
	@FindBy(xpath="(//span[@class='slds-checkbox'])[1]/input")
	WebElement chkPromoter;
	public WebElement chkPromoter() { return chkPromoter; }
	
	@FindBy(xpath="//input[@name='Role__c']")
	WebElement listBoxDesignation;
	public WebElement listBoxDesignation() { return listBoxDesignation; }
	
	@FindBy(xpath="//span[@title='Proprietor']")
	WebElement listBoxDesignationProprietor;
	public WebElement listBoxDesignationProprietor() { return listBoxDesignationProprietor; }
	
	@FindBy(xpath="//span[@title='Partner']")
	WebElement listBoxDesignationPartner;
	public WebElement listBoxDesignationPartner() { return listBoxDesignationPartner; }
	
	@FindBy(xpath="//span[@title='Director']")
	WebElement listBoxDesignationDirector;
	public WebElement listBoxDesignationDirector() { return listBoxDesignationDirector; }
	
	@FindBy(xpath="//span[@title='Shareholder']")
	WebElement listBoxDesignationShareholder;
	public WebElement listBoxDesignationShareholder() { return listBoxDesignationShareholder; }
	
	@FindBy(xpath="//span[@title='Key Management Personnel']")
	WebElement listBoxDesignationKeyManagementPersonnel;
	public WebElement listBoxDesignationKeyManagementPersonnel() { return listBoxDesignationKeyManagementPersonnel; }
	
	@FindBy(xpath="//span[@title='Property Owner']")
	WebElement listBoxDesignationPropertyOwner;
	public WebElement listBoxDesignationPropertyOwner() { return listBoxDesignationPropertyOwner; }
	
	@FindBy(xpath="//span[@title='Other']")
	WebElement listBoxDesignationOther;
	public WebElement listBoxDesignationOther() { return listBoxDesignationOther; }
	
	@FindBy(xpath="//input[@name='Profit_Sharing_Ratio__c']")
	WebElement txtShareholding;
	public WebElement txtShareholding() { return txtShareholding; }
	
	@FindBy(xpath="//input[@name='Qualification__c']")
	WebElement listBoxQualification;
	public WebElement listBoxQualification() { return listBoxQualification; }
	
	@FindBy(xpath="//span[@title='Graduate']")
	WebElement listBoxQualificationOptionGraduate;
	public WebElement listBoxQualificationOptionGraduate() { return listBoxQualificationOptionGraduate; }
	
	@FindBy(xpath="//input[@name='Experience__c']")
	WebElement txtExperience;
	public WebElement txtExperience() { return txtExperience; }
	
	@FindBy(xpath="//input[@name='Associated_Since__c']")
	WebElement txtAssociatedSince;
	public WebElement txtAssociatedSince() { return txtAssociatedSince; }
	
	@FindBy(xpath="//input[@name='Additional_Remarks__c']")
	WebElement txtAdditionalRemarks;
	public WebElement txtAdditionalRemarks() { return txtAdditionalRemarks; }
		
	@FindBy(xpath="(//span[@class='slds-checkbox'])[2]/input")
	WebElement chkGuarantor;
	public WebElement chkGuarantor() { return chkGuarantor; }
	
	@FindBy(xpath="//input[@name='Voter_ID__c']")
	WebElement txtVoterID;
	public WebElement txtVoterID() { return txtVoterID; }
	
	@FindBy(xpath="//input[@name='Driving_License__c']")
	WebElement txtDrivingLicense;
	public WebElement txtDrivingLicense() { return txtDrivingLicense; }
	
	@FindBy(xpath="//label[text()='Address Line 1']/following-sibling::div/textarea")
	WebElement txtAddLine1;
	public WebElement txtAddLine1() { return txtAddLine1; }
	
	@FindBy(xpath="//label[text()='Address Line 2']/following-sibling::div/textarea")
	WebElement txtAddLine2;
	public WebElement txtAddLine2() { return txtAddLine2; }
	
	@FindBy(xpath="//label[text()='Address Line 3']/following-sibling::div/textarea")
	WebElement txtAddLine3;
	public WebElement txtAddLine3() { return txtAddLine3; }
	
	@FindBy(xpath="//label[text()='State']/following-sibling::div/input")
	WebElement txtState;
	public WebElement txtState() { return txtState; }
	
	@FindBy(xpath="//label[text()='City']/following-sibling::div/input")
	WebElement txtCity;
	public WebElement txtCity() { return txtCity; }
	
	
	//@FindBy(xpath="//label[text()='Pin Code']/following-sibling::div/input")
	@FindBy(xpath="//input[@placeholder='Search Master Pincodes...']")
	WebElement txtPinCode;
	public WebElement txtPinCode() { return txtPinCode; }
	
	@FindBy(xpath="(//li[@role='presentation'])[2]")
	WebElement optionsPincode;
	public WebElement optionsPincode() { return optionsPincode; }
	
	@FindBy(xpath="//input[@name='Net_Worth_Lakh__c']")
	WebElement txtNetWorth;
	public WebElement txtNetWorth() { return txtNetWorth; }
	
	@FindBy(xpath="//input[@name='SignedConsentFormStatus__c']")
	WebElement chkConsentFormStatus;
	public WebElement chkConsentFormStatus() { return chkConsentFormStatus; }
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnSave;
	public WebElement btnSave() { return btnSave; }
}
