package Academy.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Academy.BasePage.BasePage;


public class LoginPage extends BasePage{
	
	//in this approach of superbase page we need not initialise the pages with webdriver
	//agin as screnshot may not be required for each page???dont know..will have to see
	
	//or remove base page and intilise each page with initielements
	
	//input[@id='user_email']
//public WebDriver driver;

public LoginPage(WebDriver driver){
	//
	//this.driver=driver;
	super(driver);
}

@FindBy(xpath="//input[@id='user_email']")
public WebElement emailID;

@FindBy(xpath="//input[@id='user_password']")
public WebElement Password;
@FindBy(xpath="//input[@type='submit']")
public WebElement LoginButton; 

@FindBy(css="[href*='password/new']")
public WebElement forgotPassword;



public ForgotPasswordPage clickforgotPassword(){
	forgotPassword.click();
	//forgotPassword fp=new forgotpassword(driver);
	//return fp;
	//to make less code
return new ForgotPasswordPage(driver);
	
}

//we cannot write data driven here, we have to call from the testcase otherwise can call


/*public HomePage userValidationvalid(String username, String password){

emailID.sendKeys(username);
Password.sendKeys(password);
LoginButton.click();
return new HomePage(driver);
	
}

public LoginPage userValidationinvalid(String username, String password){

emailID.sendKeys(username);
Password.sendKeys(password);
LoginButton.click();
return this;
//return new LoginPage(driver);
*/
	
}

/*//reusable methods of loginpage
 //may be can pass from excel instead of data provider using map...?
	public boolean doLogin()
	{
		emailID.sendKeys(Constants.USERNAME);
		nextButton.click();
		password.sendKeys(Constants.PASSWORD);
		Homepage hp=new Homepage(driver);
		PageFactory.initElements(driver, hp);
		//hp.clickCalendar();
boolean login_status=hp.verifyDisplayHomePage();
return login_status;
		
	}*/

/*//without pagefactories-rahulshetty
	By email=By.cssSelector("[id='user_email']");
	By password=By.cssSelector("[type='password']");
	By login=By.cssSelector("[value='Log In']");
	By forgotPassword = By.cssSelector("[href*='password/new']");
	
	
	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;//instead of super(driver)
		//then we have to initilise pagefactry in each page this is without it
		
	}


//retrning one class to another
public ForgotPassword forgotPassword()
{
	driver.findElement(forgotPassword).click();
	return new ForgotPassword(driver);
	
}
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	

	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	
	
}*/