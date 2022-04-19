package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IntranetLoginPage {
	
	WebDriver driver;
	
	//Constructor, as every page needs a Webdriver to find elements
	public IntranetLoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(id="username")
	WebElement userName;

	@FindBy(id="password")
	WebElement intranetPassword;
	
	@FindBy(id="button_submit")
	WebElement loginBtn;

	@FindBy(id="label_login")
	WebElement errorMessage;
	
	public void enterUserName(String user) {
		sendkeysToWebElement(userName,user);
	}
	
	public void enterPassword(String password) {
		sendkeysToWebElement(intranetPassword,password);
	}
	
	public void clickOnLoginButton(){
		clickWebElement(loginBtn);
	}
	
   public void logInWithCredentials(String username, String password) {   
	   enterUserName(username);
	   enterPassword(password);
	   clickOnLoginButton();   
	}
   
   public String getErrorMessage() {
	   return getWebElementText(errorMessage);
   }
   
   
   public boolean verifyLoginButtonIsDisplayed(){
		return verifyWebElementIsDisplayed(loginBtn);
	}
   
   
   
   
   
   
   public void sendkeysToWebElement(WebElement element, String text) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		getWait().until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
  }
  
   
   
   
   
   
   
   
   public void clickWebElement(WebElement element) {
       try {
          	 clickWebElementAction(element);
        } catch (Exception WebDriverException) {
       	 clickJSElement(element);
        }
   }
   
   private void clickWebElementAction(WebElement element) throws StaleElementReferenceException, NoSuchElementException, TimeoutException, WebDriverException {
       Actions action = new Actions(driver);
       action.moveToElement(element).build().perform();
       getWait().until(ExpectedConditions.elementToBeClickable(element)).click();
   }
   
   public WebDriverWait getWait(){
	   WebDriverWait wait=new WebDriverWait(driver,5);
		return wait;
	}
   
   public void clickJSElement(WebElement element){
       ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
   }
   
   
   

   
   
   
   public String getWebElementText(WebElement element) {
	   	try {
	   		return getWebElementTextAction(element);
			} catch (Exception WebDriverException) {
				return element.getText();
			}
	   }
   
   private String getWebElementTextAction(WebElement element) throws StaleElementReferenceException, NoSuchElementException, TimeoutException, WebDriverException {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		return getWait().until(ExpectedConditions.visibilityOf(element)).getText();
  }
   
   
   
   
   
   
   
   
   
   
   public boolean verifyWebElementIsDisplayed(WebElement element) {
		try {
			return verifyWebElementIsDisplayedAction(element);
		} catch (Exception WebDriverException) {
			return element.isDisplayed();
		}
		
   }
   
   private boolean verifyWebElementIsDisplayedAction(WebElement element) throws StaleElementReferenceException, NoSuchElementException, TimeoutException, WebDriverException {
   	Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		return getWait().until(ExpectedConditions.visibilityOf(element)).isDisplayed();
   }
   
   
   

}
