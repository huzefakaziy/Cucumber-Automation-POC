package common.PageFactoryObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPageFactory {	
	WebDriver driver ;
	
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[id='username']")
	private WebElement txtUsername;	
	public WebElement txtUsername()	{
		return txtUsername;
	}
	
	@FindBy(css="input[id='password']")
	private WebElement txtPassword;	
	public WebElement txtPassword()	{
		return txtPassword;
	}
	
	@FindBy(css="input[id='Login']")
	private WebElement btnLogin;	
	public WebElement btnLogin() {
		return btnLogin;
	}
	
	@FindBy(css="div[id='error']")
	private WebElement msgError;	
	public WebElement msgError() {
		return msgError;
	}
	
}
