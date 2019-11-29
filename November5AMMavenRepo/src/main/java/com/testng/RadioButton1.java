package com.testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.project.BaseTest;

public class RadioButton1 extends BaseTest 
{

	
	@BeforeMethod
	@Parameters("browser")
	  public void beforeMethod(String btype) throws Exception 
	  {
		init();
		launch(btype);
		navigateUrl("radiobuttonurl");
	  }
	
	
	@Test
	public void RadioButtonTest()
	{
		WebElement radio=driver.findElement(By.xpath("(//td[@class='table5'])[2]"));
		List<WebElement> rbutton=radio.findElements(By.name("group1"));
		for(int i=0;i<rbutton.size();i++)
		{
			System.out.println(rbutton.get(i).getAttribute("value")+ "----" + rbutton.get(i).getAttribute("checked"));
		}
	}
 

  @AfterMethod
  public void afterMethod() 
  {
	 driver.quit();
  }
	
}
