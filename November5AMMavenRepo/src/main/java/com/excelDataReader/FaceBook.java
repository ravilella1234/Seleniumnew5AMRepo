package com.excelDataReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBook 
{

	public static void main(String[] args) throws Exception 
	{
		WebDriver driver;
		ExcelAPI e1=new ExcelAPI("C:\\Users\\DELL\\Desktop\\testdata.xlsx");
		System.out.println(e1.getCellData("login", "UserName", 2));
		System.out.println(e1.getCellData("login", "Password", 2));
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		
		for(int i=1;i<e1.getRowCount("login");i++)
		{
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(e1.getCellData("login", "UserName", i));
			
			driver.findElement(By.id("pass")).clear();
			driver.findElement(By.id("pass")).sendKeys(e1.getCellData("login", "Password", i));
			
			Thread.sleep(2000);
		}
		
		
	}

}
