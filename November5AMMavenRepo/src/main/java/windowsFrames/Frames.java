package windowsFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) 
	{
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Drivers\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 
		 driver.get("http://www.angelfire.com/super/badwebs/");
		 
		 //driver.switchTo().frame(1);
		 
		 driver.switchTo().frame(driver.findElement(By.name("contents")));
		 
		 driver.findElement(By.xpath("//p[7]//font[1]")).click();

	}

}
