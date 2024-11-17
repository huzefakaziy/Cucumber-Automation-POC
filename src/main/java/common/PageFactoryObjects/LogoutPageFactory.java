package common.PageFactoryObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LogoutPageFactory {	
	WebDriver driver ;
	
	public LogoutPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='uiImage']")
	private WebElement linkViewProfile;
	public WebElement linkViewProfile()	
	{ 
		return linkViewProfile; 
	}
	
	@FindBy(xpath="//div[@class='slds-icon-waffle']")
	private WebElement linkViewProfile2;
	public WebElement linkViewProfile2()	
	{ 
		return linkViewProfile2; 
	}
	
	@FindBy(xpath = "//a[normalize-space()='Log Out']")
	private WebElement linkLogOut;
	public WebElement linkLogOut() 
	{ 
		return linkLogOut; 
	}
	
}
