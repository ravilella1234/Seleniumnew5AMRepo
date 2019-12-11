package com.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	//loginPage Properties
	@FindBy(linkText="Sign in")public WebElement signIn;
	@FindBy(id="email")public WebElement customerEmail;
	@FindBy(id="passwd")public WebElement customerPassword;
	@FindBy(id="SubmitLogin")public WebElement submitLogin;
	@FindBy(xpath="//li[contains(text(),'Authentication failed.')]")public WebElement getloginErrorMessage;
	

	
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public void login()
	{
		signIn.click();
		customerEmail.sendKeys("qatest587787@gmail.com");
		customerPassword.sendKeys("password");
		submitLogin.click();
	}
	
	public String getLoginError()
	{
		return getloginErrorMessage.getText();
	}
	
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * WebDriver driver; System.setProperty("webdriver.chrome.driver",
	 * System.getProperty("user.dir")+"//drivers//chromedriver.exe"); driver=new
	 * ChromeDriver(); driver.get("http://automationpractice.com/index.php");
	 * driver.manage().window().maximize();
	 * 
	 * driver.findElement(By.linkText("Sign in")).click();
	 * driver.findElement(By.id("email")).sendKeys("qatest87548@gmail.com");
	 * driver.findElement(By.id("passwd")).sendKeys("password");
	 * driver.findElement(By.id("SubmitLogin")).click(); String actualError =
	 * driver.findElement(By.xpath("//li[contains(text(),'Authentication failed.')]"
	 * )).getText(); String expectedError="Authentication failed.";
	 * Assert.assertEquals(actualError, expectedError); }
	 */

}
