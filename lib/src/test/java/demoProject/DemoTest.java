package demoProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.IntranetLoginPage;


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
	public void validateLoginToIntranet(){
		IntranetLoginPage iop = PageFactory.initElements(driver, IntranetLoginPage.class);
//	    IntranetPage ip= PageFactory.initElements(driver, IntranetPage.class);
	    
	    iop.logInWithCredentials(user, password);
	    driver.switchTo().frame("icpnavframe");
//	    Assert.assertTrue(ip.verifySearchBarIsVisible(),"User isn't logged into the intranet successfully");
	}
	
}
