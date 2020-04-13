package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import data.JsonDataReader;
import pages.RegisterPage;

public class RegisterTests extends TestBase{
	
	Faker fakeData = new Faker();
	String fName = fakeData.name().firstName();
	String lName = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String password = fakeData.bothify("??????###");
	
	RegisterPage registerPageObj;
	JsonDataReader jsonDataReaderObj;
	
	
	//Register with valid data from Faker
	@Test(priority= 2)
	public void registerWithValidData() throws FileNotFoundException, IOException, ParseException, InterruptedException {
		registerPageObj = new RegisterPage(driver);
		System.out.println(fName+" " +lName+" " +email+" " +password);
		registerPageObj.registerWithValidData(fName, lName, email, password);
		Assert.assertEquals(driver.getTitle(), "My Account");
	}

	//Register with email already existed to fail to check capturing screenshot on failure and I read this test data from Json file
	@Test(priority= 1)
	public void registerWithExistedEmail() throws FileNotFoundException, IOException, ParseException, InterruptedException {
		registerPageObj = new RegisterPage(driver);
		jsonDataReaderObj = new JsonDataReader();
		jsonDataReaderObj.jsonReader();
		registerPageObj.registerWithValidData(jsonDataReaderObj.fName, jsonDataReaderObj.lName, jsonDataReaderObj.email, jsonDataReaderObj.pass);
		Assert.assertEquals(driver.getTitle(), "My Account");
	}
}
