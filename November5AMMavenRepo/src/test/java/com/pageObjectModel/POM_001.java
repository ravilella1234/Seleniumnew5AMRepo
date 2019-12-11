package com.pageObjectModel;

import org.testng.annotations.Test;

import com.project.BaseTest;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class POM_001 extends BaseTest
{
   
  @BeforeTest
  public void startprocess() throws Exception 
  {
	  init();
	  launch("chromebrowser");
	  navigateUrl("automationurl");
  }
  
  @Test(priority = 1)
  public void loginTest() 
  {
	  LoginPage page=new LoginPage(driver);
	  page.login();
	  Assert.assertEquals(page.getLoginError(), "Authentication failed.");  
  }
  
  
  @Test(priority = 2)
  public void registration() throws InterruptedException
  {
	  RegistrationPage reg=new RegistrationPage(driver);
	  reg.customerRegistration();
  }

  @AfterTest
  public void endProcess()
  {
	  //driver.quit();
  }

}
