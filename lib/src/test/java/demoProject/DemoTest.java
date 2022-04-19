package demoProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.IntranetLoginPage;
import pages.IntranetPage;


public class DemoTest {
	
	WebDriver driver;
	private String user="testautomation@ncr.com";
	private String password="1234567";
	
	
	@BeforeTest(alwaysRun=true)
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
		driver =new ChromeDriver();
		driver.get("https://intranet-reg.ncrconsole.com");
		
	}
	
	
	
	@Test(groups= {"intranetTest"})
	public void searchedStoreShouldBeDisplayedInRecentSection() throws InterruptedException{
		IntranetLoginPage iop = PageFactory.initElements(driver, IntranetLoginPage.class);
	    IntranetPage ip= PageFactory.initElements(driver, IntranetPage.class);
	    
	    iop.logInWithCredentials(user, password);
	    driver.switchTo().frame("icpnavframe");
	    ip.enterStore("autosite");
	    Thread.sleep(2000);
	    Assert.assertTrue(ip.verifyStoreIsDisplayedBelowTheSearchBar("autosite"),"The searched store isn't displayed below the search bar");	
	}
	
	
}
