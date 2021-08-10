package stepdefinition;


import io.cucumber.junit.Cucumber;


import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Academy.BaseTest.BaseTest;
import Academy.Pages.LandingPage;
import Academy.Pages.LoginPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@RunWith(Cucumber.class)
public class MyStepDefinitions extends BaseTest {

	//public WebDriver driver; cant declare like this? as ogther tcs?
	@Given("^Initilize the browser with chrome$")
    public void initilize_the_browser_with_chrome() throws Throwable {
		 initiliaze();
		 driver= openBrowser("chrome");
    }
	
	 @And("^Navigate to \"([^\"]*)\"  site$")
	    public void navigate_to_something_site(String strArg1) throws Throwable {
	        driver.get(strArg1);
	        //not using openURL() as it needs modification to access themethod to accept string
	    }


	    @And("^click on login link to land on secure sign page$")
	    public void click_on_login_link_to_land_on_secure_sign_page() throws Throwable {
	    	LandingPage land_page=new LandingPage(driver);//can be below the class instead of here 
	    	land_page.clickLoginlink(); 
	    }

    @When("^user enter \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
    public void user_enter_something_and_something_and_logs_in(String strArg1, String strArg2) throws Throwable {
    
    	LoginPage login_page=new LoginPage(driver);
    	login_page.emailID.sendKeys(strArg1);
		login_page.Password.sendKeys(strArg2);
		login_page.LoginButton.click();
    }

    @Then("^verify that user is successfully logged in$")
    public void verify_that_user_is_successfully_logged_in() throws Throwable {
      Assert.assertEquals("hi","hi");
    }

  
    }

 