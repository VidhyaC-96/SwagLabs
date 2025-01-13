package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import objectRepository.InventoryPage;
import objectRepository.LoginPage;

/**
 * This method consists of basic configuration of TestNG annotations
 * @author Vidhya C
 */
public class BaseClass {
	ExcelUtility eUtil=new ExcelUtility();
	PropertyUtility pUtil=new PropertyUtility();
	SeleniumUtility sUtil=new SeleniumUtility();
	
public WebDriver driver;
public static WebDriver sdriver;
@BeforeSuite(alwaysRun=true)
public void bsConfig() {
	System.out.println("========== DB Connection Successful ==========");
}

//@Parameters("browser")
//@BeforeTest(alwaysRun=true)  //to check parallel execution
@BeforeClass(alwaysRun=true)
public void bcConfig(/*String parameterValue*/) throws IOException {
	String URL = pUtil.readFromPropertyFile("url");
	
//	if(parameterValue.equalsIgnoreCase("edge")) {
//		driver=new EdgeDriver();
//	}else if(parameterValue.equalsIgnoreCase("chrome")) {
//		driver=new ChromeDriver();
//	}else if(parameterValue.equalsIgnoreCase("firefox")) {
//		driver=new FirefoxDriver();
//	}
	driver= new FirefoxDriver();  //to check with single browser until the product is stable
	sUtil.maximizewindow(driver);
	sUtil.implicitlywait(driver);
	driver.get(URL);
		sdriver=driver;
	System.out.println("======== Browser Launch Successful ==========");
}
@BeforeMethod(alwaysRun=true)
public void bmConfig() throws IOException {
	String USERNAME = pUtil.readFromPropertyFile("username");
	String PASSWORD = pUtil.readFromPropertyFile("password");
	LoginPage lp=new LoginPage(driver);
	lp.loginToApplication(USERNAME, PASSWORD);
	
	System.out.println("========== Login Successful ==========");
}
@AfterMethod(alwaysRun=true)
public void amConfig() {
	InventoryPage ip=new InventoryPage(driver);
	ip.logoutOfApplication();
	
	System.out.println("========== Logout Successful ==========");
}
//@AfterTest(alwaysRun=true)  //to check parallel execution
@AfterClass(alwaysRun=true)
public void acConfig() {
	driver.close();
	
	
	System.out.println("======== Browser Closure Successful ==========");
}
@AfterSuite(alwaysRun=true)
public void asConfig() {
	System.out.println("========== DB Closure Successful ==========");
}
}
