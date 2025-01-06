package inventoryTests;

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
	public class AddProductToCart {

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
			InventoryPage ip=new InventoryPage(driver);
			String ProductToBeAdded = ip.clickOnProduct(driver, PRODUCTNAME);
	//Step 5:Click on add to cart button
			InventoryItemPage iip=new InventoryItemPage(driver);
			iip.addToCartBtn();
			iip.cartContainerBtn();
	//Step 6:Navigate to cart and validate
			CartPage cp=new CartPage(driver);
			String ProductInCart = cp.getProductName();
					if(ProductInCart.equals(ProductToBeAdded)) {
						System.out.println("PASS");
						System.out.println(ProductInCart);
					}else {
						System.out.println("FAIL");
					}
	//Step 7:Logout of Application
					ip.logoutOfApplication();
					
		}

	}
