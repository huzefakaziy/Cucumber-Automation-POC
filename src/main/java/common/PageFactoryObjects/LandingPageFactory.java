package common.PageFactoryObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageFactory {
	WebDriver driver = null;
	public LandingPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div[title=New]")
	private WebElement btnNew;
	public WebElement btnNew() { return btnNew; }	
		
	@FindBy(xpath="//span[@class='slds-truncate']")
	private WebElement lblAppName; 
	public WebElement lblAppName() { return lblAppName; }	
	
	@FindBy(css="#error")
	WebElement lblError;
	/*
	@FindBy(xpath="//div[@class='slds-context-bar']/div/div/span/span")
	WebElement lblAppName;
	*/
	
	@FindBy(css="span[data-aura-class='uiImage']")
	private WebElement iconProfile;
	public WebElement iconProfile() { return iconProfile; }	
	
	@FindBy(css = "table[data-aura-class='uiVirtualDataTable'] th:nth-child(3)")
	private WebElement loanApplicationTable;
	public WebElement loanApplicationTable() { return loanApplicationTable; }
	
	@FindBy(xpath="//div[contains(@class,'appLauncher slds-context-bar__icon-action')]/following-sibling::div/span") 
	private WebElement lblCRMApp;
	public WebElement lblCRMApp() { return lblCRMApp; }
	
	@FindBy(xpath="//div[@class='slds-icon-waffle']") 
	private WebElement btnLauncher;
	public WebElement btnLauncher() { return btnLauncher; }
	
	@FindBy(xpath="//p[text()='CRM App']") 
	private WebElement lnkCRMApp;
	public WebElement lnkCRMApp() { return lnkCRMApp; }
	
	
	
	
	
	
	
	
}
