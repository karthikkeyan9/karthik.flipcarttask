package task;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipcartTaskTest {
@Test
public void task()
{
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//button[text()='✕']")).click();
	driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("winter heater");
	driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
	
	driver.findElement(By.xpath("(//div[@class='_4ddWXP'])[1]")).click();
	
	Set<String> winhandle = driver.getWindowHandles();
	
	Iterator<String>id=winhandle.iterator();
	
	while(id.hasNext())
	{
		
		String windid = id.next();
		
		String currenttitle = driver.switchTo().window(windid).getTitle();
		
		if(currenttitle.contains("darshanam"))
		{
			break;
		}
	
	}
	String wantedproduct = driver.findElement(By.xpath("//span[@class='B_NuCI']")).getText();
	driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
	String cartproduct = driver.findElement(By.xpath("//a[@class='_2Kn22P gBNbID']")).getText();
	Assert.assertEquals(wantedproduct, cartproduct);
	driver.quit();
	
}
}
