package week4.day2.homework;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Nykaa {

	public static void main(String[] args) {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		ChromeDriver d=new ChromeDriver(opt);
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		d.get("https://www.nykaa.com/");
		// To mouseover on an element
		WebElement ele = d.findElement(By.xpath("//a[text()='brands']"));
		Actions builder=new Actions(d);
		builder.moveToElement(ele).perform();
		d.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
		d.findElement(By.xpath("(//div[@id='list_L']//following::a[contains(text(),'Oreal Paris')])[1]")).click();
		String title=d.getTitle();
		System.out.println(title);
		WebElement we = d.findElement(By.xpath("(//*[name()='svg' and @class='arrow-icon'])[1]"));
		we.click();
		d.findElement(By.xpath("(//span[text()='customer top rated']//following::div[@class='control-indicator radio '])[1]")).click();
		d.findElement(By.xpath("(//*[name()='svg' and @class='arrow-icon'])[2]")).click();
		d.findElement(By.xpath("(//span[@class='side-count']//*[name()='svg' and @class='arrow-icon'])[2]")).click();
		d.findElement(By.xpath("(//span[@class='side-count']//*[name()='svg' and @class='arrow-icon'])[1]")).click();
		d.findElement(By.xpath("(//span[text()='Shampoo']//following::div[@class='control-indicator checkbox '])[1]")).click();
		d.findElement(By.xpath("(//*[name()='svg' and @class='arrow-icon' ])[11]")).click();
		d.findElement(By.xpath("(//span[text()='Color Protection']/following::div[@class='control-indicator checkbox '])[1]")).click();
		String filterValue = d.findElement(By.xpath("//span[text()='Color Protection' and @class='filter-value']")).getText();
		d.findElement(By.xpath("(//div[@class='css-1rd7vky']/div[@class='css-xrzmfa'])[1]")).click();
		Set<String> windowHandles = d.getWindowHandles();
		List<String> list1=new ArrayList<String>(windowHandles);
		d.switchTo().window(list1.get(1));
		Select sc=new Select(d.findElement(By.xpath("//select[@title='SIZE']")));
		sc.selectByIndex(1);
		String price=d.findElement(By.xpath("//div[text()='inclusive of all taxes']/preceding-sibling::div//span[text()='MRP:']/following-sibling::span")).getText();
		System.out.println("The price of the shampoo is : "+price);
		d.findElement(By.xpath("//span[text()='Delivery Options']//preceding::span[text()='Add to Bag']")).click();
		d.findElement(By.xpath("//span[@class='cart-count']/..//*[name()='svg']")).click();
		
		WebElement frame = d.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
		d.switchTo().frame(frame);
		String grandTotal=d.findElement(By.xpath("//span[text()='Grand Total']/preceding::span[1]")).getText();
		System.out.println("Grand Total is : "+grandTotal);
		d.findElement(By.xpath("//span[text()='Proceed']")).click();
		d.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		d.findElement(By.xpath("(//p[text()='New Address']/preceding::div/span/img)[7]")).click();
		String total=d.findElement(By.xpath("(//p[text()='Price Details']/following::p)[2]")).getText();
		if(grandTotal.equals(total))
			System.out.println("Prices are equal!!!!!!!1");
		else
			System.out.println("Prices are not equal!!!!");
		d.quit();
		
		//(//button[@type='button']//*[name()='svg'])[1]
				
		
		
		
		
	}

}
