package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AddProductToCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Step 1:Launch the browser
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Step 2:Load Url
		driver.get("https://www.saucedemo.com/v1/");
		Thread.sleep(2000);
		//Step 3::Login to Application
		driver.findElement(By.id("user-name")).sendKeys("problem_user");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(2000);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		//Step 4:Click on the product
		driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/../../..//button[text()='ADD TO CART']")).click();
		//Step 5:Click on add to cart button
		//driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		//Step 6:Navigate to cart and validate
		driver.findElement(By.xpath("//*[name()='svg' and @role='img']")).click();
		 boolean ele = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).isDisplayed();
		if(ele==true) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		//Step 7:Logout of Application
		driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("logout_sidebar_link")).click();
		Thread.sleep(2000);
		driver.close();
		
	}

}
