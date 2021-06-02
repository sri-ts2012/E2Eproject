package Academy.testcases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Academy.BaseTest.BaseTest;
import Academy.Pages.ForgotPasswordPage;
import Academy.Pages.LandingPage;
import Academy.Pages.LoginPage;


public class ValidateLoginPagetest extends BaseTest {
	public WebDriver driver;
	
	
	@BeforeTest
	public void setUp()
	{
		 initiliaze();
			driver= openBrowser("chrome");
			// openBrowser("chrome");
		 log.info("opened chrome");
			// log.info("testing");
			
			 
			 
	}
	
	
	//@Test(dataProviderClass = DataUtil.class, dataProvider = "dp")
	@Test(dataProvider="getData")
	//need to take the dataprovider from the datautil of utilities package
	public void doLogin(String username, String password) throws InterruptedException{
		/* initiliaze();
		// driver= openBrowser("chrome");
		 openBrowser("chrome");
		 openURL();*/
		 openURL();
		 		 LandingPage land_page=new LandingPage(driver);
			LoginPage login_page=land_page.clickLoginlink(); //driver.findElement(By.css()
			
		/*validateLandingPagetest obj=new validateLandingPagetest();
		obj.doBaseTestnavigation();*/// not recmmended as each test shd be independent
	//can make the initilize, openbrowser , open url in one as setup in the basetest		
			
			login_page.emailID.sendKeys(username);
			login_page.Password.sendKeys(password);
			login_page.LoginButton.click();
			
			//below way is wrong AS WE NEED TIO VALIDATE IF LOGIN CORRECT OR WRONG
			
		//	HomePage home_page=login_page.userValidationinvalid(username, password);
		//	login_page=login_page.userValidationinvalid(username, password);
	//		Assert.assertEquals("hi","bye");
			//Assert.assertArrayEquals(HomePage.gettitle.gettext(something from home page), "to verify after login");
			//System.out.println(" tried logged in");
			
			//to add the forgotpasseord page
			
		//	System.out.println(login_page);
			
			ForgotPasswordPage fp=login_page.clickforgotPassword();
			//System.out.println(fp);
		//	fp.loginwithSchoollink.click();
			Thread.sleep(2000);
			System.out.println("it is"+fp.emailidfppage);
			fp.emailidfppage.sendKeys("asb@df.com");
			fp.fpsendmeBtn.click();
		//	Assert.assertEquals("hi","bye");
			Assert.assertEquals(fp.titleoffp.getText(),"Reset Password");
		
			
		}

	
	//like thtaking the same browser so, second test failing 
	//problem with depends onmethods
	//@Test(dependsOnMethods ={"doBaseTestnavigation"},dataProvider="getData")
	/*public void doLogin1(String userName, String password) throws Exception{
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

	
	
	//second test with data privider failing as the object is not located since the page elements changing
		//but it shd take new page?
@DataProvider
public Object[][] getData()
{
	Object[][] data=new Object[2][2];
	//oth row
	data[0][0]="nonrestricetduser@test.com";
	data[0][1]="nonrestricetddpawd";
	//1row
	data[1][0]="restricted@test2.com";
	data[1][1]="restriceted";
	
	return data;
			
	
}

@AfterTest
public void tearDown() {
	
	driver.close();
//	log.info("Test Execution completed !!!");

}	

}



