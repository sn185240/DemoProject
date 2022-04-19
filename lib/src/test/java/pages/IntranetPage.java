package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class IntranetPage {
WebDriver driver;
	
	//Constructor, as every page needs a Webdriver to find elements
	public IntranetPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath="//input[@id='searchstring']")
	WebElement searchBar;

	@FindBy(id="top-level-nav-logout")
	WebElement logout;
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="save")
	WebElement saveButtton;
	
	@FindBy(id="admintools")
	WebElement clientTools;
	
	@FindBy(id="storelist")
	WebElement storeList;
	
	@FindBy(id="firstname")
	WebElement firstNameField;
	
	@FindBy(id="lastname")
	WebElement lastNameField;
	
	@FindBy(id="emailaddress")
	WebElement emailField;
	
	@FindBy(id="intranetAccess")
	WebElement intranetAccessCheckBox;
	
	@FindBy(id="button_create")
	WebElement createButton;
	
	@FindBy(id="btn_cancel")
	WebElement cancelButton;
	
	@FindBy(id="btn_save")
	WebElement suspendedAcctSaveBtn;
	
	@FindBy(id="varValueSelect")
	WebElement statusDropDown;
	
	@FindBy(id="varValue")
	WebElement clientNameField;
	
	@FindBy(id="storePropertyName")
	WebElement addDataNameField;
	
	@FindBy(id="storePropertyValue")
	WebElement addDataValueField;
	
	@FindBy(id="btn_newstoreproperty")
	WebElement addDataButton;
	
	@FindBy(xpath="//input[@value='Cancel']")
	WebElement cancelAddDataButton;
	
	@FindBy(id="text_start")
	WebElement salesDataStartDate;
	
	@FindBy(id="text_end")
	WebElement salesDataEndDate;
	
	@FindBy(id="btn_submit")
	WebElement salesDataUpdate;
	
	@FindBy(id="searchBy")
	WebElement searchByDropDown;
	
	
	public boolean verifyStoreIsDisplayedBelowTheSearchBar(String store) {
		WebElement we=driver.findElement(By.xpath("//a[contains(text(),'"+store+"')]"));
		return verifyWebElementIsDisplayed(we);
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
	
	
	
	
	
	
	public WebDriverWait getWait(){
		   WebDriverWait wait=new WebDriverWait(driver,5);
			return wait;
		}
	
	public void enterStore(String storeName) {
		sendkeysToWebElement(searchBar, storeName);
		sendkeysToWebElement(searchBar,String.valueOf(Keys.ENTER));
	}
	
	public void sendkeysToWebElement(WebElement element, String text) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		getWait().until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
  }
	
}
