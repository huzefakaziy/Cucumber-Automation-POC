package loans.PageFactoryObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLoanAppPageObjects {

	WebDriver driver = null;
	public NewLoanAppPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Object Common to all pages:
	@FindBy(xpath="//button[@title='Next']")
	WebElement btnNext;
	public WebElement btnNext() { return btnNext; }
	
	
	
	@FindBy(xpath="//button[@title='Show Navigation Menu']//lightning-primitive-icon//*[local-name()='svg']")
	WebElement btnArrow;
	public WebElement btnArrow() { return btnArrow; }
	
	@FindBy(xpath="//span[@class='menuLabel slds-listbox__option-text slds-listbox__option-text_entity'][normalize-space()='Loan Applications']")
	WebElement LoanApps;
	public WebElement LoanApps() { return LoanApps; }
	
	@FindBy(xpath="//button[@title='Select List View']")
	WebElement ListViewPickerLoanApps;
	public WebElement ListViewPickerLoanApps() { return ListViewPickerLoanApps; }
	
	@FindBy(xpath="//span[text()='All Cases (RM)']")
	WebElement ListViewOption_AllCases;
	public WebElement ListViewOption_AllCases() { return ListViewOption_AllCases; }

	@FindBy(xpath="//div[@title='New']")
	WebElement btnNew;
	public WebElement btnNew() { return btnNew; }
	
	@FindBy(xpath="//div[@title='Add Case']")
	WebElement btnAddCase;
	public WebElement btnAddCase() { return btnAddCase; }
	
	@FindBy(xpath="//button[text()='BBG Flow']")
	WebElement btnBBGFlow;
	public WebElement btnBBGFlow() { return btnBBGFlow; }
			
	@FindBy(xpath="//input[@name='Application_Name']")
	WebElement txtApplicationName;
	public WebElement txtApplicationName() { return txtApplicationName; }
		
	@FindBy(xpath="//select[@name='Source_Entity']")
	WebElement SelectSource;
	public WebElement SelectSource() { return SelectSource; }
	
	@FindBy(xpath="//select[@name='Type_Of_Proposal_Entity']")
	WebElement SelectProposalType;
	public WebElement SelectProposalType() { return SelectProposalType; }
		
	@FindBy(xpath="//label[text()='Branch']/following-sibling::div/div/lightning-base-combobox/div/div/input")
	WebElement txtBranch;
	public WebElement txtBranch() { return txtBranch; }
		
	@FindBy(xpath="//li[@role='presentation']")
	WebElement optionsBranch;
	public WebElement optionsBranch() { return optionsBranch; }
	
	
	@FindBy(xpath="//select[@name='Program_Master']")
	WebElement txtProgram;
	public WebElement txtProgram() { return txtProgram; }
	
	@FindBy(xpath="//input[@type='tel']")
	WebElement txtContactNo;
	public WebElement txtContactNo() { return txtContactNo; }
	
	@FindBy(xpath="//input[@name='EmailId']")
	WebElement txtEmail;
	public WebElement txtEmail() { return txtEmail; }
	
	@FindBy(xpath="//input[@name='Pan']")
	WebElement txtPan;
	public WebElement txtPan() { return txtPan; }
	
	@FindBy(xpath="//input[@name='DOB']")
	WebElement txtDOI;
	public WebElement txtDOI() { return txtDOI; }
	
	@FindBy(xpath="//input[@name='Signed_Consent_Form']/following-sibling::label")
	WebElement chkSignedConsentForm;
	public WebElement chkSignedConsentForm() { return chkSignedConsentForm; }
	
	@FindBy(xpath="//input[@name='Property_Owner']/following-sibling::label")
	WebElement chkPropertyOwner;
	public WebElement chkPropertyOwner() { return chkPropertyOwner; }
	
	
	
	@FindBy(xpath="//input[@name='Loan_Amount']")
	WebElement txtLoanAmt;
	public WebElement txtLoanAmt() { return txtLoanAmt; }
	
	@FindBy(xpath="//input[@name='Net_worth']")
	WebElement txtNetWorth;
	public WebElement txtNetWorth() { return txtNetWorth; }
	
	@FindBy(xpath="//input[@name='Turnover_for_Last_12_months_Lakh']")
	WebElement txtTurnover;
	public WebElement txtTurnover() { return txtTurnover; }
	
	@FindBy(xpath="//input[@name='Net_Profit_For_Last_Financial_Year_Lakh']")
	WebElement txtNetProfit;
	public WebElement txtNetProfit() { return txtNetProfit; }
	
	@FindBy(xpath="//label[text()='Industry Type']/following-sibling::div/div/lightning-base-combobox/div/div/input")
	WebElement selectIndustryType;
	public WebElement selectIndustryType() { return selectIndustryType; }
	
	@FindBy(xpath="//li[@role='presentation']")
	WebElement optionsIndustryType;
	public WebElement optionsIndustryType() { return optionsIndustryType; }
	
	@FindBy(xpath="//select[@name='Nature_Of_Business']")
	WebElement selectNatureOfBusiness;
	public WebElement selectNatureOfBusiness() { return selectNatureOfBusiness; }
	
	@FindBy(xpath="//select[@name='Banking_Arrangement']")
	WebElement selectBankingArrangement;
	public WebElement selectBankingArrangement() { return selectBankingArrangement; }
	
	@FindBy(xpath="//select[@name='Constitution_Business']")
	WebElement selectConstitution;
	public WebElement selectConstitution() { return selectConstitution; }
	
	@FindBy(xpath="//label[text()='Present Banking With']/following-sibling::div/div/lightning-base-combobox/div/div/input")
	WebElement txtPresentBanking;
	public WebElement txtPresentBanking() { return txtPresentBanking; }
	
	@FindBy(xpath="(//li[@role='presentation'])[2]")
	WebElement optionsPresentBanking;
	public WebElement optionsPresentBanking() { return optionsPresentBanking; }
	
	@FindBy(xpath="//span[text()='PSL Classification']/parent::label/following-sibling::div/div/select")
	WebElement selectPSLClassification;
	public WebElement selectPSLClassification() { return selectPSLClassification; }
	
	@FindBy(xpath="//span[text()='PSL Sub Classification']/parent::label/following-sibling::div/div/select")
	WebElement selectPSLSubClassification;
	public WebElement selectPSLSubClassification() { return selectPSLSubClassification; }
	
	@FindBy(xpath="//select[@name='Purpose_of_Proposal_Business_Det']")
	WebElement selectPurposeProposal;
	public WebElement selectPurposeProposal() { return selectPurposeProposal; }
	
	@FindBy(xpath="//div[text()='Business Description']/parent::div/parent::div/parent::div/following-sibling::div/div/textarea")
	WebElement txtBusinessDescription;
	public WebElement txtBusinessDescription() { return txtBusinessDescription; }
	
	@FindBy(xpath="//div[text()='Promoter Background']/parent::div/parent::div/parent::div/following-sibling::div/div/textarea")
	WebElement txtPromoterBackground;
	public WebElement txtPromoterBackground() { return txtPromoterBackground; }
	
	@FindBy(xpath="//div[text()='Customer and Supplier Linkages']/parent::div/parent::div/parent::div/following-sibling::div/div/textarea")
	WebElement txtCustomerSupplier;
	public WebElement txtCustomerSupplier() { return txtCustomerSupplier; }
	
	@FindBy(xpath="//div[text()='Key Risks And Mitigants']/parent::div/parent::div/parent::div/following-sibling::div/div/textarea")
	WebElement txtRisk;
	public WebElement txtRisk() { return txtRisk; }
	
	@FindBy(xpath="//select[@name='Type']")
	WebElement selectAddressType;
	public WebElement selectAddressType() { return selectAddressType; }
	
	@FindBy(xpath="//input[@name='AddressLine_1']")
	WebElement txtAddressLine_1;
	public WebElement txtAddressLine_1() { return txtAddressLine_1; }
	
	@FindBy(xpath="//input[@name='AddressLine_2']")
	WebElement txtAddressLine_2;
	public WebElement txtAddressLine_2() { return txtAddressLine_2; }
	
	@FindBy(xpath="//input[@name='AddressLine_3']")
	WebElement txtAddressLine_3;
	public WebElement txtAddressLine_3() { return txtAddressLine_3; }
	
	@FindBy(xpath="//input[@name='City']")
	WebElement txtCity;
	public WebElement txtCity() { return txtCity; }
	
	@FindBy(xpath="//input[@name='State']")
	WebElement txtState;
	public WebElement txtState() { return txtState; }
	
	@FindBy(xpath="//input[@placeholder='Search Master Pincodes...']")
	WebElement txtPincode;
	public WebElement txtPincode() { return txtPincode; }
	
	@FindBy(xpath="//li[@role='presentation']")
	WebElement optionsPincode;
	public WebElement optionsPincode() { return optionsPincode; }
	
	@FindBy(xpath="//label[text()='Collateral Type']/following-sibling::div/div/lightning-base-combobox/div/div/input")
	WebElement txtCollateralType;
	public WebElement txtCollateralType() { return txtCollateralType; }
	
	@FindBy(xpath="//li[@role='presentation']")
	WebElement optionsCollateralType;
	public WebElement optionsCollateralType() { return optionsCollateralType; }
	
	@FindBy(xpath="//input[@name='Amount']")
	WebElement txtCollateralAmt;
	public WebElement txtCollateralAmt() { return txtCollateralAmt; }
	
	@FindBy(xpath="//input[@name='Address_Line_1']")
	WebElement txtCollateralAddress1;
	public WebElement txtCollateralAddress1() { return txtCollateralAddress1; }
	
	@FindBy(xpath="//input[@name='Address_Line_2']")
	WebElement txtCollateralAddress2;
	public WebElement txtCollateralAddress2() { return txtCollateralAddress2; }
	
	@FindBy(xpath="//input[@placeholder='Search Master Pincodes...']")
	WebElement txtCollateralPincode;
	public WebElement txtCollateralPincode() { return txtCollateralPincode; }
	
	@FindBy(xpath="(//li[@role='presentation'])[3]")
	WebElement optionsCollateralPincode1;
	public WebElement optionsCollateralPincode1() { return optionsCollateralPincode1; }
	
	@FindBy(xpath="(//li[@role='presentation'])[2]")
	WebElement optionsCollateralPincode2;
	public WebElement optionsCollateralPincode2() { return optionsCollateralPincode2; }
	
	
	
	@FindBy(xpath="//div[@name='Charge_Type']")
	WebElement selectChargeType;
	public WebElement selectChargeType() { return selectChargeType; }
	
	@FindBy(xpath="//span[text()='Limit with other Banks']")
	WebElement lblLimit_Other_Banks;
	public WebElement lblLimit_Other_Banks() { return lblLimit_Other_Banks; }
	

	
}
