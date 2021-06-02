package Academy.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Academy.BasePage.BasePage;

public class ForgotPasswordPage extends BasePage{
	//public WebDriver driver;
	public ForgotPasswordPage(WebDriver driver) {
		super(driver);//this.driver=driver if ther eis no basepage like in e2e
	}
	
	@FindBy(xpath="//input[@id='user_email']")
	public WebElement emailidfppage;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement fpsendmeBtn;
	
	@FindBy(xpath="//h1[contains(text(),'Reset Password')]")
	public WebElement titleoffp;
	
	@FindBy(linkText="Log In with a school Account")
	public WebElement loginwithSchoollink;
	
	/*@FindBy(css="input[type^='sub']]")
	public WebElement createAccountLink;*/// did not verify this link
	
	public ForgotPasswordPage clickloginwithSchoollink(){
		
		loginwithSchoollink.click();
		
		//enter email?
		//click button?
		return this;
	}
		
		public void printemailidfp(){
			System.out.println(emailidfppage);
			
		}
		
		
		
		
	}
		
		
			
		
	

	
	
	
	
	//method to click create account its not returning new page so write, return this;
	


