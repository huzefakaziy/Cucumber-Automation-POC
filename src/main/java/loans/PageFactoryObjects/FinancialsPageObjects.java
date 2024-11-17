package loans.PageFactoryObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinancialsPageObjects {
	WebDriver driver = null;
	public FinancialsPageObjects(WebDriver driver) {		
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath="(//span[@class='slds-file-selector__button slds-button slds-button_neutral'])[1]")
	WebElement btnUploadCSVFile;
	public WebElement btnUploadCSVFile() { return btnUploadCSVFile; }
	
	/*
	@FindBy(xpath="(//span[@class='slds-file-selector__button slds-button slds-button_neutral'])[2]")
	WebElement btnUploadExcelFile;
	public WebElement btnUploadExcelFile() { return btnUploadExcelFile; }
	*/
	@FindBy(xpath="(//*[text()='Upload Files'])[2]")
	WebElement btnUploadExcelFile;
	public WebElement btnUploadExcelFile() { return btnUploadExcelFile; }
	
	
	@FindBy(xpath="//button[@type='button' and @class='slds-button slds-button_neutral' and contains(text(), 'Save')]")
	WebElement btnSave;
	public WebElement btnSave() { return btnSave; }
	
	@FindBy(xpath="//*[contains(text(), 'NewKonceptPolypro.csv')]")
	WebElement fileNameCSV;
	public WebElement fileNameCSV() { return fileNameCSV; }
	
	@FindBy(xpath="//*[contains(text(), 'NewKonceptPolypro.xlsx')]")
	WebElement fileNameExcel;
	public WebElement fileNameExcel() { return fileNameExcel; }
	
	@FindBy(xpath="//div[@role='status' and @class='slds-spinner slds-spinner_medium']")
	WebElement spinner;
	public WebElement spinner() { return spinner; }
	
	@FindBy(xpath="//button[@title='Run Financial Analysis']")
	WebElement btnRunFinancialAnalysis;
	public WebElement btnRunFinancialAnalysis() { return btnRunFinancialAnalysis; }
			
	@FindBy(xpath="//button[text()='Ok']")
	WebElement btnOk;
	public WebElement btnOk() { return btnOk; }
	
	@FindBy(xpath="//button[@title='Refresh']")
	WebElement btnRefresh;
	public WebElement btnRefresh() { return btnRefresh; }
	
	@FindBy(xpath="//div[@class='slds-m-bottom_large slds-text-heading_medium']/table/tbody/tr[2]/td[1]")
	WebElement lblFinancialStatus;
	public WebElement lblFinancialStatus() { return lblFinancialStatus; }
}
