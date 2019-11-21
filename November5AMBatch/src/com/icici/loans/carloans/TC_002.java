package com.icici.loans.carloans;

import org.openqa.selenium.By;

public class TC_002 extends  BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		
		launch("chromebrowser");
		
		navigateUrl("amazonurl");
		
		selectOption("amazondropdown_id","amazondropdowntvalue");
				
		typeText("amazonsearchtext_name","amazontextvalue");
		
		clickElement("amazonsearchbutton_xpath");
		
		
		/*driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");
		
		driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();*/

	}
}
