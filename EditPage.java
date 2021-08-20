 package week1.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditPage {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver page = new ChromeDriver();
		page.get("http://leafground.com/pages/Edit.html");
		page.manage().window().maximize();
		page.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		page.findElement(By.xpath("//input[@id='email']")).sendKeys("Keerthana@gmail.com");
		
		WebElement webEleAppend = page.findElement(By.xpath("//input[@value='Append ']"));
		webEleAppend.clear();
		webEleAppend.sendKeys("Text through sendkeys");
		webEleAppend.sendKeys(Keys.TAB);		
	    /* sendKeys(Keys.TAB) or use Actions class to perform an action via keyboard
		Actions act = new Actions(page); 
		act.sendKeys(Keys.TAB).build().perform();  */
	
		String defaultTxt = page.findElement(By.xpath("//input[@name='username']")).getAttribute("value");
		System.out.println("Default text in text box : "+defaultTxt);
		
		page.findElement(By.xpath("//label[text()='Clear the text']/following-sibling::input")).clear(); //E - y sib
		boolean editFieldDisabled = page.findElement(By.xpath("//label[text()='Confirm that edit field is disabled']/following-sibling::input")).isEnabled();
		if(editFieldDisabled)
			System.out.println("This edit field is enabled");
		else
			System.out.println("This edit field is not enabled");
		
		
	}
}
