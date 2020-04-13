package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageBase{

	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	//Register Page Locators
	
	@FindBy(name = "firstname")
	private WebElement fNameTxtBox;
	
	@FindBy(name = "lastname")
	private WebElement lNameTxtBox;
	
	@FindBy(name = "phone")
	private WebElement phoneTxtBox;
	
	@FindBy(name = "email")
	private WebElement emailTxtBox;
	
	@FindBy(name = "password")
	private WebElement passwordTxtBox;
	
	@FindBy(name = "confirmpassword")
	private WebElement confiramPasswordTxtBox;
	
	@FindBy(xpath = ".//button[text()=' Sign Up' and @type='submit']")
	private WebElement signUpBtn;
	
	public void registerWithValidData(String firstName, String lastName, String email, String password) throws InterruptedException {
		
		clearTextBox(fNameTxtBox);
		setTextBoxValue(fNameTxtBox, firstName);
		clearTextBox(lNameTxtBox);
		setTextBoxValue(lNameTxtBox, lastName);
		clearTextBox(emailTxtBox);
		setTextBoxValue(emailTxtBox, email);
		clearTextBox(passwordTxtBox);
		setTextBoxValue(passwordTxtBox, password);
		clearTextBox(confiramPasswordTxtBox);
		setTextBoxValue(confiramPasswordTxtBox, password);
		clickBtn(signUpBtn);
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
	}


}
