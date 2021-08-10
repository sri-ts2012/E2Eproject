package Academy.testcases;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Academy.BaseTest.BaseTest;
import Academy.Pages.LandingPage;
import Academy.Pages.LoginPage;

public class validateLandingPagetest extends BaseTest {
	public WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		 initiliaze();
			driver= openBrowser("chrome");
			// openBrowser("chrome");
		 log.info("opened chrome");
		 //test.log(Status.INFO, "InsidedoLoginTest");
			// log.info("testing");
			 openURL();
			 
			 
	}
	
	@Test
	public void doBaseTestnavigation() throws InterruptedException{
		/* initiliaze();
		// driver= openBrowser("chrome");
		 openBrowser("chrome");
		 openURL();*/
		 
		 //below 2 lines  returning one class to other
		System.out.println("driver is" +driver);
		 LandingPage land_page=new LandingPage(driver);
		 if(land_page.popUpList.size()>0){
			// for(int i=0;i<land_page.popUpList.size();i++)
		//	 {if(land_page.popUpList.get(i).getAttribute("tagname").equalsIgnoreCase("button")&&())
	//if multiple pops then switch to the one we want using some crieteria or condition			 
				 land_page.popUp.click();
		 }
		Assert.assertEquals(land_page.getTitle.getText(),"FEATURED COURSES");
		log.info("test complete");
		// System.out.println("Test completed");
		 //validate navigation bar this asseet takes condition
/*Assert.assertTrue(land_page.NavBar.isDisplayed());
		System.out.println("nav bar displayed"+(land_page.NavBar.isDisplayed()));
		*/
	
			
	}	 
	@AfterTest
	public void tearDown() {
		
		driver.close();
	//	log.info("Test Execution completed !!!");
	
	}	
		 

	//like thtaking the same browser so, second test failing 
	//problem with depends onmethods
	//@Test(dependsOnMethods ={"doBaseTestnavigation"},dataProvider="getData")
	/*public void doLogin(String userName, String password) throws Exception{
		LandingPage l=new LandingPage(driver);
		LoginPage lp=l.getLogin(); //driver.findElement(By.css()
		//above is of type returning the class object
		Thread.sleep(2000);
		lp.getEmail().sendKeys(userName);
		Thread.sleep(3000);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
	}
	

*/


}
