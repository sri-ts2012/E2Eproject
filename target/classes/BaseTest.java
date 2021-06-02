

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;

//import io.github.bonigarcia.wdm.WebDriverManager;

//we need dbmanager to use thesqlconnection
//import utilities.DbManager;


public class BaseTest {
	Properties prop;
	public WebDriver driver;
	 public static Logger log =LogManager.getLogger(BaseTest.class.getName());
	//public Properties prop = new Properties();
	
	public WebDriverWait wait;

	
	//	@BeforeTest
	public  void initiliaze() //we can  call this methd, setup etc separate from each test case or else 
	//we can write all in one and initiliase driver in each test case?
	{
		if(prop==null){ 
	 prop=new Properties();
		File propFile=new File("src//test//resources//properties//config.properties");
		
		
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		} catch (Exception e) {//more safe is throwable
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}

	
	//	public void openBrowser(String browserType)
	//if we are retunring the driver then change the method to
		public WebDriver openBrowser(String browserType)
		{
		
			//browserType=System.getProperty("browser");
			//System.out.println(browserType);
			//if passsing from the propertyfile
			 browserType = prop.getProperty("browser");
			//if passing  ie excel(fromhashmap) then in the testcase we have to call this 
			//method using  openBrowser(map.get("Browser")) where hashmap is used to store 
			//data from the excel(ZOHO DDAR PROJECT),a dataprovider is used to load the data(crosscheck 
			//datautil of way2auto(kept dps as common where we can access commonly(datautil file) instead of keeping the dataprovider in the testcase) and datautil of zohoddar
			
			//or
			//from the constants file(ZOHOPOM project)
			
			if(browserType.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver",prop.getProperty("firefoxDriverPath"));
				driver=new FirefoxDriver();
			}else  if(browserType.equalsIgnoreCase("chrome"))
			{
			//	this is to disbale notifications,smilarly in ff etc
			/*	Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");*/

				System.setProperty("webdriver.chrome.driver",prop.getProperty("chromeDriverPath"));
				driver=new ChromeDriver();
			
			}else  if(browserType.equalsIgnoreCase("ie"))
					{
			System.setProperty("webdriver.chrome.driver",prop.getProperty("ieDriverPath"));
			//	WebDriverManager.iedriver().setup();
				driver=new InternetExplorerDriver();
					}
			return driver;
		}
			
			public void openURL()
			{
			driver.get(prop.getProperty("testsiteurl"));
			log.info("Navigating to the URL : "+prop.getProperty("testsiteurl"));
		//	DbManager.setMysqlDbConnection();
			//log.info("Database connection established");
			driver.manage().window().maximize();
			log.info("window maximized");
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicit.wait")), TimeUnit.SECONDS);
			wait = new WebDriverWait(driver,Integer.parseInt(prop.getProperty("explicit.wait")));
		//here we can return the driver and change method return type to webdriver
			//or else pass driver as constructor
			
			//or use constructor to pass the driver
		}
			
			
			
			
			public String getScreenshotpath(String testClassName,String testmethodName,WebDriver driver)
			{
				
	Date d = new Date();
	    		
	    	String	addDateandext = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
				
				
				
				TakesScreenshot ts=(TakesScreenshot)driver;
				File sourceFile=ts.getScreenshotAs(OutputType.FILE);//this is in a virtual place in selenium
			//	File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				//we have to take it to the local system
				String destFile=System.getProperty("user.dir")+"\\reports\\screenshots\\"+testClassName+"_"+testmethodName+"_"+addDateandext;
				//FileUtils.copyFile(sourceFile, destFile);//apche commons IO
				try {
					FileUtils.copyFile(sourceFile, new File(destFile));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return destFile;
				//selenium version 4 needs 
			}
			
		
			
    		
    		/*@AfterTest
		public void tearDown() {
			
			driver.close();
			log.info("Test Execution completed !!!");
		*/
		}	
		
	


