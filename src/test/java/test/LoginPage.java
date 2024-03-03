package test;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPage {
	// http://orangehrm.qedgetech.com
	//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver ;
	@Parameters("url")
	@Test(priority=1)
	public void loginWithValidCredentials(@Optional("http://orangehrm.qedgetech.com") String URL) throws InterruptedException
	{
	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		driver.findElement(By.xpath("//input[@id ='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id ='txtPassword']")).sendKeys("Qedge123!@#");
		driver.findElement(By.xpath("//input[@id ='btnLogin']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Admin")).isDisplayed());
		Thread.sleep(2000);
		driver.close();
			
	}
	
	
	@Test(priority=2)
	public void AdminDashboard(@Optional("http://orangehrm.qedgetech.com") String URL) throws InterruptedException {
		
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(URL);
			driver.findElement(By.xpath("//input[@id ='txtUsername']")).sendKeys("Admin");
			driver.findElement(By.xpath("//input[@id ='txtPassword']")).sendKeys("Qedge123!@#");
			driver.findElement(By.xpath("//input[@id ='btnLogin']")).click();
			driver.findElement(By.linkText("Admin")).click();
			Thread.sleep(2000);
			driver.close();
	}
	
	public String generateEmailTimeStamp()
	{
		Date date = new Date();
		return date.toString().replace(" "," ").replace(":","_")+"Admin";
	}
	
	@Test(priority=3, enabled= true)
	public void loginwithInvalidCredentials() throws InterruptedException
	{
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://orangehrm.qedgetech.com");
		driver.findElement(By.xpath("//input[@id ='txtUsername']")).sendKeys(generateEmailTimeStamp());
		driver.findElement(By.xpath("//input[@id ='txtPassword']")).sendKeys("Qedge1234!@#");
		driver.findElement(By.xpath("//input[@id ='btnLogin']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='spanMessage']")).isDisplayed());
		Thread.sleep(2000);
		driver.close();
	}
}
