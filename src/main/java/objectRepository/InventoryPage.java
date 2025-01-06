package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//Rule 1:Create a POM class
public class InventoryPage {
//Rule 2:Store Web elements using selenium support annotations	
	@FindBy(className ="bm-burger-button")
	private WebElement MenuBtn;
	@FindBy(id="logout_sidebar_link")
	private WebElement LogoutLink;
//Rule 3:Create a constructor for initialization
	public InventoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
//Rule 4:Provide getters for the web elements
	public WebElement getMenu() {
		return MenuBtn;
	}
	public WebElement getLogoutLink() {
		return LogoutLink;
	}
//Rule 5:Provide business libraries	
	/**
	 * This method will perform logout of application
	 */
	public void logoutOfApplication() {
		MenuBtn.click();
		LogoutLink.click();
	}
	public String clickOnProduct(WebDriver driver, String ProductName) {
		String ProductInfo = driver.findElement(By.xpath("//div[text()='"+ProductName+"']")).getText();
		driver.findElement(By.xpath("//div[text()='"+ProductName+"']")).click();
		return ProductInfo;
	}
}
