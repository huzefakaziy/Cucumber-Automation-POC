package loans.PageFactoryObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocCheckPageObjects {
	
	WebDriver driver = null;

	public DocCheckPageObjects(WebDriver driver) {		
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(tagName="a")
	WebElement tagName_a;
	public WebElement tagName_a() { return tagName_a; }
	
	@FindBy(xpath="//input[@name='progress']")
	WebElement listBoxDocStatus;
	public WebElement listBoxDocStatus() { return listBoxDocStatus; }
	
	@FindBy(xpath="//span[@title='Received Hard Copy']")
	WebElement listBoxDocStatusOptionReceivedHardCopy;
	public WebElement listBoxDocStatusOptionReceivedHardCopy() { return listBoxDocStatusOptionReceivedHardCopy; }

	@FindBy(xpath="//button[@name='update']")
	WebElement btnSave;
	public WebElement btnSave() { return btnSave; }
	
	@FindBy(xpath="//*[contains(text(),'Saved Successfully')]")
	WebElement toastMsg;
	public WebElement toastMsg() { return toastMsg; }
	
}
