package week1.day2;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperlinkPage {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[text()='Go to Home Page']")).click();
		driver.findElement(By.xpath("//h5[text()='HyperLink']/following-sibling::img")).click();
		
		String hrefLink = driver.findElement(By.xpath("//a[contains(text(),'Find where am supposed to go without clicking me?')]")).getAttribute("href");
		System.out.println("It should navigate to the page :"+hrefLink);
		
		driver.findElement(By.xpath("//a[text()='Verify am I broken?']")).click();
				
		//boolean displayedBroken = driver.findElement(By.xpath("//h1[text()='HTTP Status 404 � Not Found']")).isDisplayed();
		
		String errorTitle = driver.getTitle();
		System.out.println(errorTitle);
		String errorTitle1 = "HTTP Status 404 � Not Found";
		if(errorTitle1 == errorTitle)
			System.out.println("Page is not broken ");
		else
			System.out.println("Page is broken");
		
		driver.navigate().back();
		
		driver.findElement(By.xpath("//label[text()='(Interact with same link name)']/preceding-sibling::a")).click();
		driver.navigate().back();
	      //List<WebElement> links = driver.findElements(By.tagName("a"));
	      //System.out.println("The number of links is " + links.size());   or
		  //difference is to get more than one element use findElements
		
		int linksInThePage = driver.findElements(By.tagName("a")).size();
		System.out.println("Number of links the  page : "+linksInThePage);

	      		
	}
}
