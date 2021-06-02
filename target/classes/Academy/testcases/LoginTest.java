package Academy.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Academy.BaseTest.BaseTest;
import Academy.Pages.LandingPage;
import Academy.Pages.LoginPage;

public class LoginTest extends BaseTest {
//this is not working from other class, so need to check the issue
	//actually each test shd be independent so shd workout where depends on methods is used
//@Test(dependsOnMethods ={"doBaseTestnavigation"},dataProvider="getData")
/*	public void doLogin(String userName, String password) throws Exception{
		LandingPage l=new LandingPage(driver);
		LoginPage lp=l.getLogin(); //driver.findElement(By.css()
		//above is of type returning the class object
		Thread.sleep(2000);
		lp.getEmail().sendKeys(userName);
		Thread.sleep(3000);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
	}*/
	


@DataProvider
public Object[][] getData()
{
	Object[][] data=new Object[1][2];
	//oth row
	data[0][0]="nonrestricetduser@test.com";
	data[0][1]="nonrestricetddpawd";
	//1row
	data[1][0]="restricted@test2.com";
	data[1][1]="restriceted";
	
	return data;
			
	
}
}
