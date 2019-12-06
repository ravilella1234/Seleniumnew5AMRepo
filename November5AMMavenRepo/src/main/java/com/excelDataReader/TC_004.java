package com.excelDataReader;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.BaseTest;

public class TC_004 extends BaseTest
{
	WebDriver driver;
	
  @Test(dataProvider = "dp")
  public void f(Hashtable<String, String> data) 
  {
	  System.out.println("TestMethod Executed.......");
	  if(data.get("RunMode").equals("n"))
		  throw new SkipException("Run mode set to no...");
		  
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe"); 
	  		driver=new ChromeDriver();
			driver.manage().window().maximize(); 
			
			driver.get("https://www.facebook.com");	
			driver.findElement(By.id("email")).sendKeys(data.get("col2"));
			driver.findElement(By.id("pass")).sendKeys(data.get("col3"));
  }

  @DataProvider
  public Object[][] dp() 
  {
	  System.out.println("DataProvider Executed.......");
	  return  DataUtils.getTestData("data", "LoginTest");  
  }
}
