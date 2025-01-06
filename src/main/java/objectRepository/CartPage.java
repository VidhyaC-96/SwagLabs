package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule 1:Create a POM class
public class CartPage {
//Rule 2:Identify all the possible web elements by using annotations
	@FindBy(className = "inventory_item_name")
	private WebElement ProductInfo;

	//Rule 3:Create a constructor for initialization

	public CartPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
	//Rule 4:provide getters to access web elements
	public WebElement getProductInfo() {
		return ProductInfo;
	}	
//Rule 5:Provide business libraries
	public String getProductName() {
		String ProductInCart=ProductInfo.getText();
		return ProductInCart;
	}
	
}
