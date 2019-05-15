package com.walmart.qa.tesdata;

import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.walmart.qa.base.TestBase;
import com.walmart.qa.pages.HomePage;
import com.walmart.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;  //variable we can use in all class 
      HomePage homePage;
	
	public LoginPageTest(){
		super();                //it will call superclass constructor
	}
	
	@BeforeMethod
	public void setUP(){
		initialization();                     //initialize or open the browser 
	   loginPage = new LoginPage();
	}
	
	@Test
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();                    //we dont need to create object again and again
		Assert.assertEquals(title, "Walmart.com | Save Money. Live Better.");
	}
	
	@Test
	public void walmartLogoTest(){
		boolean flag = loginPage.validateWalmartLogo();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
