package Academy.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import Academy.BasePage.BasePage;




public class LandingPage extends BasePage {

	public LandingPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//button[contains(text(),'NO THANKS')]")
	public List<WebElement> popUpList;
	
	@FindBy(xpath="//button[contains(text(),'NO THANKS')]")
	public WebElement popUp;
	
	@FindBy(xpath="//h2[contains(text(),'Featured Courses')]")
	public WebElement getTitle;

		
	//	@FindBy(css="a[href*='sign in']")
		@FindBy(xpath="//span[contains(text(),'Login')]")
		public WebElement Signin;
		
	//	@FindBy(css="ul[class='nav.navbar-nav.navbar-right']")
	@FindBy(linkText="contact")
		public WebElement NavBar;
	
	
	
//	public List<WebElement> getPopUpList(){
//		return popUpList;
//		
//	}
	
	/*public int getPopUpListSize(){
		return popUpList.size();
		
	}*/
	
	
		//withoutpagefactories like this
		//By NavBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
		/*public WebElement getNavigationBar()
		{
			return driver.findElement(NavBar);
		}*/
		//and in the test case validate navigationbar call as below
	/*	@Test
		
		public void validateAppNavBar() throws IOException
		{

			//one is inheritance
			// creating object to that class and invoke methods of it
			LandingPage l=new LandingPage(driver);
		
			//compare the text from the browser with actual text.- Error..
		    Assert.assertTrue(l.getNavigationBar().isDisplayed());
		    log.info("Navigation Bar is displayed");
			 System.out.println("Test completed");
		 //   Assert.assertFalse(false);
			
		
			
			}*/
		//below is page factories


		

		public LoginPage clickLoginlink(){
			
			Signin.click();
			return new LoginPage(driver);
			
		}
//below is not page factories only pom

		By title=By.cssSelector(".text-center>h2");

		public WebElement getTitle()
		{
			return driver.findElement(title);
		}

		
}
	
	
	
	
	//rs code below--
	
/*public WebDriver driver;
	
	By signin=By.cssSelector("a[href*='sign_in']");
	By title=By.xpath("//h2[contains(text(),'Featured Courses')]");
	By NavBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	
	
	
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}




	public LoginPage getLogin()
	{
		 driver.findElement(signin).click();
		 LoginPage lp=new LoginPage(driver);
		 return lp;
		 
		 
		 
		 
	}
	
	public WebElement getLogin()
	{
		//return driver.findElement(signin).click();
		return driver.findElement(signin);
	}
	public WebElement getNavigationBar()
	{
		return driver.findElement(NavBar);
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	
	
	
	
	
	
	

	
	


}

*/
//above
//below

/*public WebDriver driver;
	
	public LandingPage(WebDriver driver){
		super(driver);
	}*/
		
	//	@FindBy(css="a[href*='sign in']")
	/*	@FindBy(xpath="//span[contains(text(),'Login')]")
		public WebElement Signin;

		public LoginPage clickLogin(){
			
			Signin.click();
			return new LoginPage();
			
		}
	*/
//below is of way2auto
	/*public HomePage(WebDriver driver){
		super(driver);//in base page we initilise the driver
		
		
	}

	
	@FindBy(xpath="//div[contains(text(),'NEW CARS')]")
	public WebElement newCars;
	
	@FindBy(xpath="//div[contains(text(),'Find New Cars')]")
	public WebElement findNewCars;
	
	public void findNewCar(){
		//mousever the newCars actions class
		new Actions(driver).moveToElement(newCars).perform();
		
		//click the find newcars
		findNewCars.click();
	}
	public NewCarsPage findNewCar() throws Exception{
	//mousever the newCars actions class
	new Actions(driver).moveToElement(newCars).perform();
	
	//click the find newcars
	findNewCars.click();
	Thread.sleep(3000);
	System.out.println(new NewCarsPage(driver));
	return  new NewCarsPage(driver);
}
	
	
}
	

}
*/