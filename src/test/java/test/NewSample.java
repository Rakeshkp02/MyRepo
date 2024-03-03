package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test2.login;

public class NewSample {
	
	WebDriver driver ;

	
	
	@AfterMethod
		public void close() {
		driver.close();
		}
		
	@Test(priority=1)
		public void loginWithValidCredential() {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get("http://orangehrm.qedgetech.com");
			driver.findElement(By.xpath("//input[@id ='txtUsername']")).sendKeys("Admin");
			driver.findElement(By.xpath("//input[@id ='txtPassword']")).sendKeys("Qedge123!@#");
			driver.findElement(By.xpath("//input[@id ='btnLogin']")).click();
			Assert.assertTrue(driver.findElement(By.linkText("Admin")).isDisplayed());
			
		}
	
	@Test(priority=2)
		public void loginwithInvalidCredentials() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://orangehrm.qedgetech.com");
		driver.findElement(By.xpath("//input[@id ='txtUsername']")).sendKeys("acgh");
		driver.findElement(By.xpath("//input[@id ='txtPassword']")).sendKeys("Qedge1234!@#");
		driver.findElement(By.xpath("//input[@id ='btnLogin']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='spanMessage']")).isDisplayed());
		
	}
}
