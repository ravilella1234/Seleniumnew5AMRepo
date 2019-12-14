package windowsFrames;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BootStrapAlertsHandeling 
{
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException 
	{
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\latestdrivers\\chromedriver.exe");
		 
		  driver=new ChromeDriver(options);
		  driver.manage().window().maximize();
		 //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		  driver.navigate().to("https://www.redbus.in/");
		  
		  driver.findElement(By.id("sign-in-icon-down")).click();
		  
		  driver.findElement(By.id("signInLink")).click();
		  
		  WebDriverWait wait=new WebDriverWait(driver, 30);
		  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//i[@class='icon-close']")))).click();
		  
		  Set<String> windows = driver.getWindowHandles();
		  Iterator<String> itr = windows.iterator();
		  while(itr.hasNext())
		  {
			  String wh = itr.next();
			  System.out.println(wh);
		  }
		  
		  Thread.sleep(4000);
		  //driver.switchTo().frame(1);
		  driver.switchTo().frame(2);
		  //wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(2)).switchTo().frame(2);
		  //driver.switchTo().frame(driver.findElement(By.name("modalIframe")));
		  Thread.sleep(3000);
		  driver.findElement(By.id("mobileNoInp")).sendKeys("9676273760");
		  
		  
		  //driver.switchTo().frame(1);
		  		  
		/* driver.switchTo().frame(driver.findElement(By.className("modalIframe")));
		  
		  Thread.sleep(3000);
		  
		  driver.findElement(By.xpath("//button[text()='Sign in with Facebook']")).click();*/
		  
		// driver.switchTo().frame(driver.findElement(By.className("modalIframe")));  
		  
		 // driver.switchTo().frame(1);
		  
		  
		 //Thread.sleep(5000);
		//WebDriverWait wait=new WebDriverWait(driver, 20);
		//WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Sign in with Facebook']")));
		//System.out.println(ele);
		 //System.out.println("Hi");
		// ele.click();
		 
	}

}
