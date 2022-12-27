package week4.day2.homework;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {

		ChromeOptions ch=new ChromeOptions();
        ch.addArguments("--disable-notifications");
		ChromeDriver cdriver=new ChromeDriver(ch);
		cdriver.manage().window().maximize();
		cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		cdriver.get("https://www.amazon.in/");
		cdriver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro",Keys.ENTER);
		String priceOfFirstProduct=cdriver.findElement(By.xpath("(//span[@class='a-price']/span)[1]//following-sibling::span/span[2]")).getText();
		System.out.println("Price of the first product is : "+priceOfFirstProduct);
		String customerRatings=cdriver.findElement(By.xpath("(//div[@class='a-row a-size-small']/span)[2]")).getText();
		System.out.println("Customer Ratings is : "+customerRatings);
		String firstTextLink=cdriver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).getText();
		cdriver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		System.out.println("First text link of the first image is : "+firstTextLink);
		Set<String> windowHandles = cdriver.getWindowHandles();
		List<String> list1=new ArrayList<String>(windowHandles);
		cdriver.switchTo().window(list1.get(1));
		File src=cdriver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snaps/AmazonPhone.jpg");
		FileUtils.copyFile(src, dest);
		Thread.sleep(3000);
		cdriver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		Thread.sleep(5000);
		String cartSubTotal=cdriver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		Thread.sleep(5000);
		System.out.println("Cart sub Total is : "+cartSubTotal);

	}

}
