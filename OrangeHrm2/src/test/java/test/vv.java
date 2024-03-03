package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class vv {
 public static void main(String[] args) throws InterruptedException {
	

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.get("http://flights.qedgetech.com");
	driver.findElement(By.name("email")).sendKeys("sureshbabu.qedge@gmail.com");
	driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("demo");
	driver.findElement(By.xpath("//button[@type = 'submit' ]")).click();
	driver.findElement(By.id("search-date")).sendKeys("02/25/2024");
	Select sc = new Select(driver.findElement(By.xpath("//div/div[2]/div[1]/div/div/div[2]/select")));
	//List<WebElement> opt = sc.getOptions();
	sc.selectByVisibleText("Kolkatha");
	
	Select scc = new Select(driver.findElement(By.xpath("//div[1]/div/div/div[3]/select")));
	//List<WebElement> scc = sc.getOptions();
	scc.selectByVisibleText("Hyderabad");
	driver.findElement(By.xpath("//button[normalize-space()='Search Flights']")).click();
	driver.findElement(By.xpath("//button[normalize-space()='×']")).click();
	
	
 }
}
