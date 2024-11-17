package utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Common {	
	
	//Checks if web element is present on the page or not. Returns true if element is present on the page else returns false.
	public static boolean isElementPresent(WebElement element)
	{
		boolean elementPresent = false;
		try
		{
			if(element.isDisplayed())
			{
				elementPresent = true;
			} 
		}catch (NoSuchElementException e)
			{
				//System.out.println("Element not present");
			}
		catch (Exception e) {
			System.out.println("Exception in isElementPresent " + e.getMessage());
			e.printStackTrace();
		}
		return elementPresent;
		}
	
	
	//Checks if web element is stale. Returns true if element is stale on the page else returns false.
	public static boolean isStale(WebElement e){
	    try{
	        e.isDisplayed();
	        return false;
	    }catch(StaleElementReferenceException ex){
	        return true;
	    }
	}
	
	
	//Waits till the web element becomes available on the web page
	public void waitForElementPresent(final By by, int timeout){ 
		  WebDriverWait wait = (WebDriverWait)new WebDriverWait(Base.driver,timeout).ignoring(StaleElementReferenceException.class); 
		  wait.until(new ExpectedCondition<Boolean>(){ 
		    public Boolean apply(WebDriver webDriver) { 
		      WebElement element = webDriver.findElement(by); 
		      return element != null && element.isDisplayed(); 
		    } 
		  }); 
		}
	
	}
	


