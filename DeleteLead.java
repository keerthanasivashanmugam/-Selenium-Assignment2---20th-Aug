package week1.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	public static void main(String[] args) throws InterruptedException   {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.xpath("//input[@name='USERNAME']")).sendKeys("demosalesmanager");
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("(//span[@class='x-tab-strip-inner'])[2]")).click();
		WebElement phoneNo = driver.findElement(By.xpath("//input[@name='phoneCountryCode']"));
		phoneNo.clear();
		phoneNo.sendKeys("3");
		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("606");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9597736085");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		String leadNo = driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[1]//a[1]")).getText();
		
		System.out.println("Lead no is :"+leadNo);
	    WebElement firstRowLink = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]"));
	    firstRowLink.getAttribute("value");
	    firstRowLink.click();
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		System.out.println("FindLead for ID -"+leadNo +" is deleted.");
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadNo);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//String recDetails = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		  String recDetails = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		  System.out.println(recDetails);
		  
		  if(recDetails.contains("No records to display"))
			System.out.println("No records to display for the lead id");
		
		else
			System.out.println("Still records are there for the lead id");
		
	//	driver.close();  if its used getting WARNING: Connection reset	  java.net.SocketException: Connection reset
		
		 
	}
}
