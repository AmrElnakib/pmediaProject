package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
	
	protected WebDriver driver;
	
	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	
	public void clickBtn(WebElement element) {
		element.click();
	}
	public void clearTextBox(WebElement element) {
		element.clear();
	}
	public void setTextBoxValue(WebElement element, String value) {
		element.sendKeys(value);
	}

}
