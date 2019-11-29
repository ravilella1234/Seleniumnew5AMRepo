package com.project;

import org.apache.log4j.Logger;

import com.relevantcodes.extentreports.LogStatus;

public class TC_002 extends  BaseTest
{
	private static final Logger log=Logger.getLogger(TC_002.class.getName());
	
	public static void main(String[] args) throws Exception 
	{
		test=report.startTest("TC_002");
		
		init();
		log.info("Initilizing properties files......");
		test.log(LogStatus.PASS, "Initilizing properties files......" );
		
		launch("chromebrowser");
		log.info("Launching the Browser :- " + p.getProperty("chromebrowser"));
		test.log(LogStatus.PASS, "Launching the Browser :- " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		log.info("Navigated to url :- " + p.getProperty("amazonurl"));
		test.log(LogStatus.PASS, "Navigated to url :- " + p.getProperty("amazonurl"));
		
		selectOption("amazondropdown_id","amazondropdowntvalue");
		log.info("Selected the option :- " + or.getProperty("amazondropdowntvalue") +" by using the locator :- "+ or.getProperty("amazondropdown_id"));
		test.log(LogStatus.PASS, "Selected the option :- " + or.getProperty("amazondropdowntvalue") +" by using the locator :- "+ or.getProperty("amazondropdown_id"));		
		
		typeText("amazonsearchtext_name","amazontextvalue");
		log.info("Entered the text :- " + or.getProperty("amazontextvalue") + " by using the locator :- " + or.getProperty("amazonsearchtext_name"));
		test.log(LogStatus.PASS, "Entered the text :- " + or.getProperty("amazontextvalue") + " by using the locator :- " + or.getProperty("amazonsearchtext_name"));
		
		clickElement("amazonsearchbutton_xpath");
		log.info("Clicked on Element by using the locator :- " + or.getProperty("amazonsearchbutton_xpath"));
		test.log(LogStatus.PASS, "Clicked on Element by using the locator :- " + or.getProperty("amazonsearchbutton_xpath"));
		
		report.endTest(test);
		report.flush();
		
		/*driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");
		
		driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();*/

	}
}
