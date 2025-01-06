package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage { //Rule 1:Create a POM class
//Rule 2:Identify the web elements using annotations
@FindBy(xpath="//button[text()='ADD TO CART']")
private WebElement AddToCartBtn;
@FindBy(xpath="//a[@href=\"./cart.html\"]")
private WebElement CartContainerBtn  ;

//Rule 3:Create a constructors for initialization

public InventoryItemPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
//Rule 4:Provide a getters for accessing web elements
public WebElement getAddToCartBtn() {
	return AddToCartBtn;
}
public WebElement getCartContainer() {
	return CartContainerBtn;
	
}
//Rule 5:Provide business libraries
public void addToCartBtn() {
	AddToCartBtn.click();
}
public void cartContainerBtn() {
	CartContainerBtn.click();
}
}
