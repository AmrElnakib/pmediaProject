package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utilities.Helper;

public class TestBase {
	public WebDriver driver;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.get("https://www.phptravels.net/register/en");
	}
	

	// Take screenshot when the test case fails and add it to screenshot folder
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed");
			System.out.println("Taking Screenshot...");
			Helper.captureScreenshot(driver, result.getName());
			
		}
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
}
