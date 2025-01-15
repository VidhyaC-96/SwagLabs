package inventoryTests;

import java.io.FileInputStream;

	import java.io.IOException;
	import java.time.Duration;
	import java.util.Properties;

	import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
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

@Listeners(genericUtilities.ListenerImplementation.class)	
	public class AddProductToCartTest extends BaseClass {
@Test(groups={"SmokeSuite","RegressionSuite"}) //suite works only if group is mentioned in xml

	public void tc_001_AddToCartTest() throws IOException, InterruptedException{
	
	//Read Common data from excel file
			ExcelUtility eutil=new ExcelUtility();
			String PRODUCTNAME = eutil.readFromExcelFile("Inventory", 1, 2);
	//Step 1:Launch the browser
			SeleniumUtility sutil=new SeleniumUtility();
			//commet
			System.out.println("YES");
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
				Assert.assertTrue(ProductInCart.equals(ProductToBeAdded));
		//or		
			//	Assert.assertEquals(ProductInCart, ProductToBeAdded);
		}

	}
