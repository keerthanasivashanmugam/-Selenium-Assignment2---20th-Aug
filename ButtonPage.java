package week1.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonPage {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver(); 
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//label[text()='Click button to travel home page']/following-sibling::button")).click();   // E - Y  --- sib
		driver.findElement(By.xpath("//h5[text()='Button']/following-sibling::img")).click();   // E - Y --- sib
		
		Point xAndYLocation = driver.findElement(By.xpath("//label[text()='Find position of button (x,y)']/following-sibling::button")).getLocation();
		System.out.println("Position is "+xAndYLocation);
		
		//Dimension xAndYLocationSize = driver.findElement(By.xpath("//label[text()='Find position of button (x,y)']/following-sibling::button")).getSize();
		//System.out.println("Position is "+xAndYLocationSize);
		
		String buttonColorAsRGB = driver.findElement(By.xpath("//label[text()='Find button color']/following-sibling::button")).getCssValue("background-color");
		System.out.println("Button color in RGB value "+buttonColorAsRGB);
		
		String buttonColorAsString = driver.findElement(By.xpath("//button[@id='color']")).getAttribute("style");
		System.out.println("Button color in style value "+buttonColorAsString);
			
		Dimension buttonHW = driver.findElement(By.xpath("//label[text()='Find the height and width']/following-sibling::button")).getSize();
		System.out.println("Height and width of the button : "+buttonHW); 		
				
	}
}
