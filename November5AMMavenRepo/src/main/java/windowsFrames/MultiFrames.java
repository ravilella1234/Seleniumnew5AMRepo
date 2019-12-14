package windowsFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiFrames {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Drivers\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://static.javadoc.io/org.seleniumhq.selenium/selenium-api/2.50.1/index.html?org/openqa/selenium/WebDriver.html");
		 
		 driver.switchTo().frame(driver.findElement(By.name("packageListFrame")));
		 driver.findElement(By.xpath("//li[2]//a[1]")).click();
		 driver.switchTo().defaultContent();

		 Thread.sleep(3000);
		 driver.switchTo().frame(driver.findElement(By.name("packageFrame")));
		 driver.findElement(By.xpath("//span[contains(text(),'Alert')]")).click();
		 driver.switchTo().defaultContent();
		 
		 Thread.sleep(3000);
		 driver.switchTo().frame(driver.findElement(By.name("classFrame")));
		 driver.findElement(By.xpath("//a[contains(text(),'accept')]")).click();
	}

}
