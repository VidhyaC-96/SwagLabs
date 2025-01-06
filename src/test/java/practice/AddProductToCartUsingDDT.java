package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.edge.EdgeDriver;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class AddProductToCartUsingDDT {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
//Read Common data from property file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pUtil=new Properties();
		pUtil.load(fis);
		String URL = pUtil.getProperty("url");
		String USERNAME = pUtil.getProperty("username");
		String PASSWORD=pUtil.getProperty("password");
//Read Common data from excel file
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wf=WorkbookFactory.create(fise);
		Sheet sn = wf.getSheet("Inventory");
		Row r = sn.getRow(1);
		Cell c = r.getCell(2);
		String PRODUCTNAME = c.getStringCellValue();
//Step 1:Launch the browser
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//Step 2:Load Url
		driver.get(URL);
		Thread.sleep(2000);
//Step 3::Login to Application
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		Thread.sleep(2000);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
//Step 4:Click on the product
		driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']/../../..//button[text()='ADD TO CART']")).click();
//Step 5:Click on add to cart button
//driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
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

