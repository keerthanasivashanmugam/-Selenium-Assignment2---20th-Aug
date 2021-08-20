package week1.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {
public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://leaftaps.com/opentaps/control/login");
	driver.findElement(By.xpath("//input[@name='USERNAME']")).sendKeys("demosalesmanager");
	driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
	driver.findElement(By.xpath("//input[@value='Login']")).click();
	driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
	 
	driver.findElement(By.xpath("//a[text()='Create Contact']")).click();
	driver.findElement(By.xpath("//input[@id='firstNameField']")).sendKeys("Keerthana");
	driver.findElement(By.xpath("//input[@id='lastNameField']")).sendKeys("Shiva");
	driver.findElement(By.xpath("//input[@id='createContactForm_firstNameLocal']")).sendKeys("Keerthi");
	driver.findElement(By.xpath("//input[@id='createContactForm_lastNameLocal']")).sendKeys("Shiva");
	driver.findElement(By.xpath("//input[@id='createContactForm_departmentName']")).sendKeys("Tester");
	driver.findElement(By.xpath("//textarea[@id='createContactForm_description']")).sendKeys("Description box");
	driver.findElement(By.xpath("//input[@id='createContactForm_primaryEmail']")).sendKeys("Keerthi@gmail.com");
	driver.findElement(By.xpath("//select[@id='createContactForm_generalStateProvinceGeoId']")).sendKeys("New York");
	driver.findElement(By.xpath("//input[@name='submitButton']")).click();
	
	driver.findElement(By.xpath("//a[text()='Edit']")).click();
	driver.findElement(By.xpath("//textarea[@name='description']")).clear();
	driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("Important note");
	driver.findElement(By.xpath("//input[@value='Update']")).click();
	System.out.println("Title of the page is "+driver.getTitle());
	
	
}
}
