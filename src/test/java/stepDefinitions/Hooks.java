package stepDefinitions;

import io.cucumber.java.After;
import utilities.Base;

public class Hooks extends Base {
	
	//@Before()
	public void setup() {		
		//CommonScripts.initialize();	
		//System.out.println("Main Before");
	}
	
	//@Before("@Medium")
	public void setup2() {		
		//System.out.println("Medium Before");
	}
		
	@After
	public void teardown() {		
		//driver.quit();
	}

}
