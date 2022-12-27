package week4.day2.homework;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SnapDeal {

	public static void main(String[] args) throws IOException, InterruptedException {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--disable-notifications");
		ChromeDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		d.get("https://www.snapdeal.com/");
		WebElement element = d.findElement(By.xpath("(//span[@class='labelIcon'])[1]//following-sibling::span"));
		Actions builder = new Actions(d);
		builder.moveToElement(element).perform();
		d.findElement(By.xpath("(//span[@class='linkTest' and text()='Sports Shoes'])[1]")).click();
		String ShoesCount = d.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println("The count of the shoes is " + ShoesCount);
		d.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		d.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
		d.findElement(By.xpath("//li[@data-sorttype='plth']")).click();

		// check if the items are displayed and sorted out correctly-check with mam how
		// to use for each

		List<WebElement> shoesPrices = d.findElements(By.xpath("(//span[@class='lfloat product-price'])"));
		Thread.sleep(3000);
		List<String> sp = new ArrayList<String>();
		for (int i = 1; i <= shoesPrices.size(); i++) {
			String price = d.findElement(By.xpath("(//span[@class='lfloat product-price'])[" + i + "]")).getText();
//			String s=shoesPrices.get(i).;
			System.out.println(price);
			sp.add(price);
		}

		
		  // System.out.println("List size is "+shoesPrices.size()); // //select the
		 // price range 900-1200 als0 1200 is not available in the range // 
		WebElement priceFrom = d.findElement(By.xpath("//input[@name='fromVal']")); 
		  priceFrom.clear(); 
		  priceFrom.sendKeys("489"); 
		  WebElement priceTo =d.findElement(By.xpath("//input[@name='toVal']"));
		  priceTo.clear();
		  priceTo.sendKeys("975"); 
		  d.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		  Thread.sleep(5000);
		  
		  d.findElement(By.xpath("//input[@id='Color_s-Navy']/parent::div")).click();
		  Thread.sleep(5000);
		  //mouseover 
		  WebElement ele=d.findElement(By.xpath("(//img[@class='product-image wooble'])[1]")); 
		  
		  Actions builder1=new Actions(d);
		  Thread.sleep(2000);
		  builder1.moveToElement(ele).perform();
		  Thread.sleep(5000);
		  WebElement quickView =d.findElement(By.xpath("(//div[@class='clearfix row-disc']/div)[1]"));
		  quickView.click();
		  System.out.println("Quick View link has been clicked");
		  WebElement cost=d.findElement(By.xpath("//span[@class='payBlkBig']"));
		  Thread.sleep(4000);
		  System.out.println("The cost of the shoes is :"+cost.getText());
		  
		  
		  WebElement percentageOff=d.findElement(By.xpath("//span[@class='percent-desc ']"));
		  System.out.println("The cost of the shoes is :"+percentageOff.getText());
		  Thread.sleep(5000);
		  
		  //snapshot of the shoes
		  
		  File src=d.getScreenshotAs(OutputType.FILE); File dest=new
		  File("./snaps/SnapDeal.png"); FileUtils.copyFile(src, dest);
		  
		  //to clse the current window
		  d.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
		  d.close();
		 

	}

}
