package genericUtilities;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of generic methods related to selenium
 * @author Vidhya C
 */
public class SeleniumUtility {
/**
 * This method will maximize the window
 * @param driver
 */

public void maximizewindow(WebDriver driver) {
	driver.manage().window().maximize();
}
/**
 * This method will minimize the windown
 * @param driver
 */
public void minimizewindow(WebDriver driver) {
	driver.manage().window().minimize();
}
/**
 * This method will add implicitly wait of 10s
 * @param driver
 */
public void implicitlywait(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
/**
 * This method will wait for 10s for a particular element to be visible
 * @param driver
 * @param ele
 */
public void waitForElementToBeVisible(WebDriver driver,WebElement ele) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(ele));
}
/**
 * This method will handle dropdown by index
 * @param ele
 * @param index
 */
public void handleDropdown(WebElement ele,int index) {
	Select s=new Select(ele);
	s.selectByIndex(index);
}
/**
 * This method will handle dropdown by value
 * @param ele
 * @param value
 */
public void handleDropdown(WebElement ele,String value) {
	Select s=new Select(ele);
	s.selectByValue(value);
}
/**
 * This method will handle dropdown by text
 * @param text
 * @param ele
 */
public void handleDropdown(String text,WebElement ele) {
	Select s=new Select(ele);
	s.selectByVisibleText(text);
}
/**
 * This method will perform mousehover action on webelement
 * @param driver
 * @param ele
 */
public void mouseHoverActions(WebDriver driver,WebElement ele) {
	Actions a=new Actions(driver);
	a.moveToElement(ele).perform();
}
/**
 * 
 * This meethod will perform right click action on webelement
 * @param driver
 * @param ele
 */
public void rightclickActions(WebDriver driver,WebElement ele) {
	Actions a=new Actions(driver);
	a.contextClick(ele).perform();
}
/**
 * This method will perform double click action on webelement
 * @param driver
 * @param ele
 */
public void doubleClickAction(WebDriver driver,WebElement ele) {
	Actions a=new Actions(driver);
	a.doubleClick(ele).perform();
}
/**
 * This method will perform drag and drop action on particular web element
 * @param driver
 * @param src
 * @param destiny
 */
public void dragAndDropAction(WebDriver driver, WebElement src,WebElement destiny) {
	Actions a=new Actions(driver);
	a.dragAndDrop(src, destiny).perform();
}
/**
 * This method will perform click and hold action on webelement
 * @param ele
 * @param driver
 */
public void clickAndHoldAction(WebElement ele,WebDriver driver) {
	Actions a=new Actions(driver);
	a.clickAndHold(ele).perform();
}
/**
 * This method will release the action on particular webelement
 * @param driver
 * @param ele
 */
public void releaseAction(WebDriver driver,WebElement ele) {
	Actions a=new Actions(driver);
	a.release(ele).perform();
}
/**
 * This method will accept the alert pop-up
 * @param driver
 */
public void acceptAlert(WebDriver driver) {
	Alert a=driver.switchTo().alert();
	a.accept();
}
/**
 * This method will dismiss the alert pop-up
 * @param driver
 */
public void dismissAlert(WebDriver driver) {
	Alert a=driver.switchTo().alert();
	a.dismiss();
}
/**
 * This method will capture alert text and return to caller
 * @param driver
 * @return
 */
public String getAlertText(WebDriver driver) {
	return driver.switchTo().alert().getText();
}
/**
 * This method will enter data into alert pop-up
 * @param driver
 * @param Text
 */
public void enterAlertText(WebDriver driver,String Text) {
	driver.switchTo().alert().sendKeys(Text);
}
/**
 * This method will handle frame by frameindex
 * @param driver
 * @param frameindex
 */
public void handleFrame(WebDriver driver,int frameindex) {
	driver.switchTo().frame(frameindex);
}
/**
 * This method will handle frame by frameid or name
 * @param driver
 * @param frameNameOrID
 */
public void handleFrame(WebDriver driver,String frameNameOrID) {
	driver.switchTo().frame(frameNameOrID);
}
/**
 * This method will handle frame by frameElement
 * @param driver
 * @param frameElement
 */
public void handleFrame(WebDriver driver,WebElement frameElement) {
	driver.switchTo().frame(frameElement);
}
/**
 * This method will switch back the frame to main page
 * @param driver
 */
public void switchFrameTodefault(WebDriver driver) {
	driver.switchTo().defaultContent();
}
/**
 * This method will switch back the frame to immediate parent frame 
 * @param driver
 */
public void switchFrametoParentFrame(WebDriver driver) {
	driver.switchTo().parentFrame();
}
/**
 * This method will switch driver focus to specified window Id
 * @param driver
 * @param winID
 */
public void windowHandle(WebDriver driver,String winID) {
	driver.switchTo().window(winID);
}

public String captureScreenshot(WebDriver driver,String ScreenshotName) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File destiny=new File(".\\Screenshots\\+ScreenshotName+.png");
	FileHandler.copy(src, destiny);
	
	return destiny.getAbsolutePath(); //for extent reports
	
}
}
