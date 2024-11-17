package loans.PageFactoryObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPageObjects {
	WebDriver driver = null;
	public HeaderPageObjects(WebDriver driver) {		
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath="//a[@data-label='Checklist']")
	WebElement menuLinkChecklist;
	public WebElement menuLinkChecklist() { return menuLinkChecklist; }
	
	@FindBy(xpath="//a[@data-label='Doc Check']")
	WebElement menuLinkDocCheck;
	public WebElement menuLinkDocCheck() { return menuLinkDocCheck; }
	
	@FindBy(xpath="//a[@data-label='Case Evaluation']")
	WebElement menuLinkCaseEvaluation;
	public WebElement menuLinkCaseEvaluation() { return menuLinkCaseEvaluation; }
	
	
	@FindBy(xpath="//a[@data-label='Financials']")
	WebElement menuLinkFinancials;
	public WebElement menuLinkFinancials() { return menuLinkFinancials; }
	
}
