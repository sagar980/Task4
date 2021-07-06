package Test4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Testcase4 {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\eclipse\\Chromedriver.exe");
		String ExceptedResponse = "Almost there - your 3 items are nearly in your hands.";

		WebDriver driver = new ChromeDriver();
		driver.get("https://jupiter.cloud.planittesting.com/#/");

		driver.manage().window().maximize();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"nav-shop\"]/a")).click();

		Thread.sleep(4000);

		// Find element where we would like to double click.
		WebElement we = driver.findElement(By.xpath("//*[@id=\'product-6\']/div/p/a"));

		Action myAction = new Actions(driver).doubleClick(we).build();

		myAction.perform();

		driver.findElement(By.xpath("//*[@id=\'product-4\']/div/p/a")).click();

		Thread.sleep(2000);

		// click on cart
		driver.findElement(By.xpath("//*[@id=\'nav-cart\']/a")).click();

		Thread.sleep(4000);

		// click on checkout button
		driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tfoot/tr[2]/td/a")).click();

			Thread.sleep(3000);
			
		// Verify cart items	
		  String response = driver.findElement(By.xpath("//*[@id=\'header-message\']/div")).getText();
		  
		  
		  System.out.println(response);
		  
		  if(ExceptedResponse.contentEquals(response)) {
		  System.out.println("There are 3 items in your cart");
		  
		  }
		 
		
		  Thread.sleep(3000);
		  
		  // Enter shopping Details 
		  driver.findElement(By.xpath("//*[@id=\'forename\']")).sendKeys("John");
		driver.findElement(By.xpath("//*[@id=\'surname\']")).sendKeys("Example");
		driver.findElement(By.xpath("//*[@id=\'email\']")).sendKeys("john.example@planit.net.au");
		driver.findElement(By.xpath("//*[@id=\'telephone\']")).sendKeys("02 1234 5678");
		driver.findElement(By.xpath("//*[@id=\'address\']")).sendKeys("101 Example Road");
		
		Thread.sleep(2000);
		
		// select drop down box
		WebElement element=driver.findElement(By.id("cardType"));
		
		Select sel=new Select(element);
		sel.selectByValue("Visa");
		
		
		Thread.sleep(2000);
		
		// Enter Card No
		driver.findElement(By.id("card")).sendKeys("1234 9876 1234 9876");
		
		// Click on submit button
		driver.findElement(By.id("checkout-submit-btn")).click();

		Thread.sleep(15000);

		driver.quit();
	}
}
