package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public static WebDriver driver;
	public static FileInputStream file = null;
	public static Properties properties ;
	public static String browser = null;
	
	public static WebDriver getDriver() {	
		
		try {
			file = new FileInputStream("Resources/global.properties");
			properties = new Properties();
			properties.load(file);
			
			//Get browser property from Maven command
			browser = System.getProperty("browser");
			
			//If project is not run from Maven or Jenkins then get browser value from properties file 
			if(browser==null) {
				browser = properties.getProperty("browser");
			}
			
			if(browser.equalsIgnoreCase("chrome")) 
				driver = getChromeDriver();
			else if(browser.equalsIgnoreCase("edge")) 
				driver = getEdgeDriver();
			else if(browser.equalsIgnoreCase("firefox")) 
				driver = getFirefoxDriver();				
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(properties.getProperty("timeout")), TimeUnit.SECONDS);
			
		}
		catch(Exception e) {
			log.fatal("Exception is getDriver() method of Base class: " + e.getMessage()); 
			System.out.println("Exception is getDriver() method of Base class: " + e.getMessage() +" : " + e.getStackTrace());				
		}
		finally {
			if(file!=null)
				try {
					file.close();
				} catch (IOException e) {							
					System.out.println(e.getStackTrace());
				}
		}
		
		return driver;
	}

	public static WebDriver getChromeDriver() 
	{		
		// Instantiate Chrome browser using WebDriverManager
		WebDriverManager.chromedriver().setup();		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		if(browser.contains("headless"))
			{
				options.addArguments("--headless");
			}		
		driver = new ChromeDriver(options);		
		return driver;
	}

	public static WebDriver getFirefoxDriver() {
		// Instantiate Firefox browser using WebDriverManager
		WebDriverManager.firefoxdriver().setup();		
		driver = new FirefoxDriver();
		return driver;
	}

	public static WebDriver getEdgeDriver() {
		// Instantiate Edge browser using WebDriverManager
		WebDriverManager.edgedriver().setup();		
		driver = new EdgeDriver();
		return driver;
	}
	
	
	public static String takeScreenshot(WebDriver driver, String testcaseName) throws IOException {
		String destinationPath = System.getProperty("user.dir") + "/screenshots/" + testcaseName + ".png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(src, new File(destinationPath));		
		return destinationPath;
	}
}