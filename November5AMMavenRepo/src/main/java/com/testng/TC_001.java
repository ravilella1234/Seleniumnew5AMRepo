package com.testng;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.project.BaseTest;
import com.project.TC_002;
import com.relevantcodes.extentreports.LogStatus;

public class TC_001 extends BaseTest
{
	private static final Logger log=Logger.getLogger(TC_001.class.getName());
 
  @BeforeMethod(groups = {"regression","sanity"})
  @Parameters("browser")
  public void startProcess(String btype) throws Exception 
  {
	    test=report.startTest("TC_001");
	  
	    init();
	    log.info("Initilizing properties files......");
	    
	    launch(btype);
	    log.info("Launching the Browser :- " + p.getProperty("chromebrowser"));
		test.log(LogStatus.INFO, "Opened the Browser :- " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		log.info("Navigated to url :- " + p.getProperty("amazonurl"));
		test.log(LogStatus.INFO, "Navigated to url :- " + p.getProperty("amazonurl"));	
  }
  
  
  @Test(groups = {"regression","sanity"})
  public void amazon()
  {
	    selectOption("amazondropdown_id","amazondropdowntvalue");
	    log.info("Selected the option :- " + or.getProperty("amazondropdowntvalue") +" by using the locator :- "+ or.getProperty("amazondropdown_id"));
		test.log(LogStatus.INFO, "Selected the indexed item 10 by using locator :- " + or.getProperty("amazondropdown_id"));
		
		typeText("amazonsearchtext_id","amazontextvalue");
		log.info("Entered the text :- " + or.getProperty("amazontextvalue") + " by using the locator :- " + or.getProperty("amazonsearchtext_name"));
		test.log(LogStatus.INFO, "Entered the text - harry Potter by using locator :- " + or.getProperty("amazonsearchtext_id"));
		
		clickElement("amazonsearchbutton_xpath");
		log.info("Clicked on Element by using the locator :- " + or.getProperty("amazonsearchbutton_xpath"));
		test.log(LogStatus.INFO, "Clicked on Search Button by using locator :- " + or.getProperty("amazonsearchbutton_xpath"));
  }


  @AfterMethod(groups = {"regression","sanity"})
  public void endProcess() 
  {
	  report.endTest(test);
	  report.flush();
	  
	  driver.quit();
  }

}
