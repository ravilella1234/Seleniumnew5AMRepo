package com.project;

import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import com.excelDataReader.ExcelAPI;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest 
{
	public static WebDriver driver;
	public static String projectPath=System.getProperty("user.dir");
	static FileInputStream fis;
	public static Properties p;
	public static Properties or;
	public static Properties e;
	public static Properties propenv;
	public static ExtentReports report= ExtentManager.getInstance();
	public static ExtentTest test;
	public static String screenshotFileName=null;
	public static ExcelAPI xls;
	

	@BeforeTest
	public void startProcess() throws Exception
	{
		System.out.println("BeforeTest Executed.......");
		init();
		xls=new ExcelAPI(p.getProperty("suiteA"));
	}
	
	static
	{
		Date dt=new Date();
		screenshotFileName=dt.toString().replace(':', '_').replace(' ', '_')+".png";
	}
	
	public static void init() throws Exception
	{
		
		fis=new FileInputStream(projectPath+"//data.properties");
		p=new Properties();
		p.load(fis);
		
		fis=new FileInputStream(projectPath+"//or.properties");
		or=new Properties();
		or.load(fis);
		
		PropertyConfigurator.configure(projectPath+"//log4j.properties");
		
		
		fis=new FileInputStream(projectPath+"//environment.properties");
		e=new Properties();
		e.load(fis);
		String val = e.getProperty("env");
		System.out.println(val);
		
		fis=new FileInputStream(projectPath+"//"+val+".properties");
		propenv=new Properties();
		propenv.load(fis);
		System.out.println(propenv.getProperty("amazonurl"));
		
		
	}
	
	public static void launch(String browser)
	{
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", projectPath+"//drivers//chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", projectPath+"//drivers//geckodriver.exe");
			driver=new FirefoxDriver();
		}
	}
	
	
	public static void navigateUrl(String url)
	{
		//driver.get(p.getProperty(url));
		driver.navigate().to(p.getProperty(url));
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static void clickElement(String locatorKey) 
	{
		getElement(locatorKey).click();
		//driver.findElement(By.xpath(or.getProperty(locatorKey))).click();
	}

	public static void typeText(String locatorKey, String value) 
	{
		getElement(locatorKey).sendKeys(or.getProperty(value));
		//driver.findElement(By.name(or.getProperty(locatorKey))).sendKeys(or.getProperty(value));
	}

	public static void selectOption(String locatorKey, String option) 
	{
		getElement(locatorKey).sendKeys(or.getProperty(option));
		//driver.findElement(By.id(or.getProperty(locatorKey))).sendKeys(or.getProperty(option));
	}

	public static WebElement getElement(String locatorKey) 
	{
		WebElement element=null;
		
		if(locatorKey.endsWith("_id")) {
			element=driver.findElement(By.id(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_name")) {
			element=driver.findElement(By.name(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_classname")) {
			element=driver.findElement(By.className(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_xpath")) {
			element=driver.findElement(By.xpath(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_css")) {
			element=driver.findElement(By.cssSelector(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_linktext")) {
			element=driver.findElement(By.linkText(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			element=driver.findElement(By.partialLinkText(or.getProperty(locatorKey)));
		}
		
		return element;
				
	}
	
	
	public static void waitForElement(WebElement locator,int seconds) 
	{
		WebDriverWait wait=new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public int randomNumber() 
	{
		Random r=new Random();
		return r.nextInt(55555);
	}
	
	public void selectItem(WebElement element, int itemIndex)
	{
		Select s=new Select(element);
		s.selectByIndex(itemIndex);
	}
	
}
