package windowsFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameDemo {

	public static void main(String[] args) 
	{
		WebDriver driver;
		boolean flag=true;
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\latestdrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("/html/body/div[2]/ul/li[1]/a")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("/html/body/div/ul[1]/li[1]/a/span")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(2);
		driver.findElement(By.xpath("//*[@id=\"i0\"]/td[1]/code/a")).click();

	}

}
