package cucumberoptions;

import org.junit.runner.RunWith;

//import cucumber.api.CucumberOptions;
//import cucumber.api.testng.AbstractTestNGCucumberTests;
//import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import io.cucumber.junit.CucumberOptions;//when run as jnunit
//import cucumber.api.junit.Cucumber;


/*import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;*/
//@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features/logine2e.feature",
		glue="stepdefinition")

public class TestRunner extends AbstractTestNGCucumberTests {
	
	
}
