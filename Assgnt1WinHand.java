package week4.day2.homework;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assgnt1WinHand {

	public static void main(String[] args) {
		
		ChromeDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		d.get("http://leaftaps.com/opentaps/control/login");
		WebElement we=d.findElement(By.id("username"));
		we.sendKeys("Demosalesmanager");
		WebElement we1=d.findElement(By.id("password"));
		we1.sendKeys("crmsfa");
		d.findElement(By.className("decorativeSubmit")).click();
		d.findElement(By.partialLinkText("CRM/SFA")).click();
		d.findElement(By.xpath("//a[text()='Contacts']")).click();
		d.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		d.findElement(By.xpath("(//table[@class='twoColumnForm']//img)[1]")).click();
		Set<String> windowHandles = d.getWindowHandles();
		List<String> lst=new ArrayList<String>(windowHandles);
		/*
		 * for(String s:lst) { System.out.println(s);
		 * 
		 * }
		 */
		d.switchTo().window(lst.get(1));
		
		System.out.println(" second screen win handle "+d.getTitle());
		d.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		d.switchTo().window(lst.get(0));
		d.findElement(By.xpath("(//input[@id='partyIdTo']/following::a/img)[1]")).click();

		Set<String> windowHandles2 = d.getWindowHandles();
		List<String> lst2=new ArrayList<String>(windowHandles2);
		d.switchTo().window(lst2.get(1));
		d.findElement(By.xpath("(//table[@class='x-grid3-row-table']/following::a[@class='linktext'])[1]")).click();
		d.switchTo().window(lst2.get(0));
		
		
		
		//--------Merge Button-----------
		d.findElement(By.xpath("//a[text()='Merge']")).click();
		Alert al=d.switchTo().alert();
		al.accept();
		
		String title = d.getTitle();
		System.out.println("The title of the page is :"+title);
		d.close();
		
		

	}

}
