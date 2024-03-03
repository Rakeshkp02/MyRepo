package test2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ipl {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://iplt20.com");
		driver.findElement(By.linkText("POINTS TABLE")).click();
		
		driver.findElement(By.xpath("//div[@class='cSBDisplay ng-binding'][normalize-space()='SEASON 2024']")).click();
		Thread.sleep(3000);
	/*	WebElement table = driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/div/div[1]/div/div[2]/div/div[2]"));
		List<WebElement> seasons = table.findElements(By.xpath("(/html/body/div[5]/div/div[1]/div/div/div[1]/div/div[2]/div/div[2])/div"));
		String t ="SEASON 2023";	*/
		
		//WebElement table = driver.findElement(By.xpath("//div[@class='cSBList active']"));
		List<WebElement> seasons = driver.findElements(By.xpath("//div[@class='cSBList active']/div"));
		String t ="SEASON 2022";
		System.out.println(seasons.size());
		for(WebElement e:seasons) {
			
			String w = e.getText();
			if(w.equals(t))
			{
				e.click();
				break;
			}
		}
	//	driver.close();
		
	}
}
