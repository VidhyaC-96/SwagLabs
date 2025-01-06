package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.edge.EdgeDriver;

import genericUtilities.ExcelUtility;
import genericUtilities.PropertyUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class AddProductToCartUsingDDTAndGU {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
//Read Common data from property file
		PropertyUtility putil=new PropertyUtility();
		
		String URL = putil.readFromPropertyFile("url");
		String USERNAME=putil.readFromPropertyFile("username");
		String PASSWORD=putil.readFromPropertyFile("password");
//Read Common data from excel file
		ExcelUtility eutil=new ExcelUtility();
		
		String PRODUCTNAME = eutil.readFromExcelFile("Inventory", 1, 2);
//Step 1:Launch the browser
		SeleniumUtility sutil=new SeleniumUtility();
		WebDriver driver=new EdgeDriver();
		sutil.maximizewindow(driver);
		sutil.implicitlywait(driver);
//Step 2:Load Url
		driver.get(URL);
		Thread.sleep(2000);
//Step 3::Login to Application
		LoginPage lp=new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD); //optimised approach - encapsulated
//Step 4:Click on the product
		driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']/../../..//button[text()='ADD TO CART']")).click();
		//Step 5:Click on add to cart button
        driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		
//Step 6:Navigate to cart and validate
		driver.findElement(By.xpath("//*[name()='svg' and @role='img']")).click();
				boolean ele = driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).isDisplayed();
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

