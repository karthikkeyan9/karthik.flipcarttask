package task;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SecondFilpcartTest {
@Test
public void flipcart()
{
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//button[text()='✕']")).click();
	driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("redmi");
	driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
	List<WebElement> elements = driver.findElements(By.xpath("//li[contains(text(),'4 GB RAM ')]/../../../div[1]"));
	for(int i=0;i<elements.size();i++)
	{
		WebElement e=elements.get(i);
		String phonetext = e.getText();
		System.out.println(phonetext);
	}

	driver.close();
}

}
