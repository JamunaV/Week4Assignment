package week4.day2.homework;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assgnt2WinHand {

	public static void main(String[] args) {
		ChromeDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		d.get("https://leafground.com/window.xhtml;jsessionid=node0ohpw87cjok1dz9p1fgudvj6l12019.node0");
		d.findElement(By.xpath("//span[text()='Open']")).click();
		Set<String> win1 = d.getWindowHandles();
		List<String> l1=new ArrayList<String>(win1);
		d.switchTo().window(l1.get(1));
		d.findElement(By.xpath("//span[text()='Daily Quiz']/preceding-sibling::div")).click();
		d.close();
		d.switchTo().window(l1.get(0));
		//d.switchTo().defaultContent();
		System.out.println("$$$$$$$$$$$"+d.getTitle());
		d.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Set<String> win2 = d.getWindowHandles();
		List<String> l2=new ArrayList<String>(win2);
		d.switchTo().window(l2.get(1));
		System.out.println("The title of the first window is " +d.getTitle());
		d.close();
		d.switchTo().window(l2.get(2));
		System.out.println("The title of the first window is " +d.getTitle());
		d.close();
		d.switchTo().window(l2.get(0));
		System.out.println("The title of the starting window is " +d.getTitle());
		d.findElement(By.xpath("//span[text()='Close Windows']")).click();
		Set<String> win3 = d.getWindowHandles();
		List<String> l3=new ArrayList<String>(win3);
		d.switchTo().window(l3.get(0));
		System.out.println("1st window title is "+d.getTitle());
		d.switchTo().window(l3.get(1));
		System.out.println("2st window title is "+d.getTitle());
		d.close();
		d.switchTo().window(l3.get(2));
		System.out.println("3rd window title is "+d.getTitle());
		d.findElement(By.xpath("//h5[text()=' Alert (Confirm Dialog)']//following-sibling::button/span[text()='Show']")).click();
		Alert al=d.switchTo().alert();
		al.dismiss();
		d.close();
		d.switchTo().window(l3.get(3));
		System.out.println("4th window title is "+d.getTitle());
		d.close();
		d.switchTo().window(l3.get(0));
		
		d.findElement(By.xpath("//span[text()='Open with delay']")).click();
		Set<String> win4 = d.getWindowHandles();
		List<String> l4=new ArrayList<String>(win4);
		d.switchTo().window(l4.get(1));
		System.out.println("The opened new window title is "+d.getTitle());
		d.close();
		d.switchTo().window(l4.get(2));
		System.out.println("The opened new window title is "+d.getTitle());
		d.close();
		d.switchTo().window(l4.get(0));
		d.close();
		
		
		
		

	}

}
