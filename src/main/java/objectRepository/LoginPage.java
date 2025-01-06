package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {    //Rule 1:create a separate pom class for web page
//Rule 2: identify the web elements using annotations
@FindBy(id="user-name") //-compile time
private WebElement UsernameEdt;

@FindBy(id="password")
private WebElement PasswordEdt;

@FindBy(id="login-button")
private WebElement LoginBtn;

//Rule 3:Create a constructor for initialization
public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
//Rule 4: Provide getters to access WebElements
public WebElement getUsernameEdt() {
	return UsernameEdt;
}
public WebElement getPasswordEdt() {
	return PasswordEdt;
}
public WebElement getLoginBtn() {
	return LoginBtn;
}
//Rule 5:Create Business Libraries-generic methods wrt project/scenario
public void loginToApplication(String USERNAME, String PASSWORD) {
	UsernameEdt.sendKeys(USERNAME);
	PasswordEdt.sendKeys(PASSWORD);
	LoginBtn.click();
}

}
