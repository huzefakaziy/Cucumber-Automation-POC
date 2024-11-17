package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = "src/test/java/featuresCommon",
		glue = "stepDefinitions",
//		tags="@Logout",
//		tags="@Login and @SanityTest",
//		tags="@SanityTest or @SmokeTest", 
//		tags="not @SanityTest",
		dryRun = false,		
		monochrome = true,
		plugin = { 
					"pretty", 
					"json:target/cucumber-reports/Cucumber.json",					
					"html:target/cucumber-reports/Cucumber.html",
					"junit:target/cucumber-reports/Cukes.xml"
				}
		
		)

public class TestNGRunner extends AbstractTestNGCucumberTests{

}
