package com.walmart.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walmart.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	//Page Factory pattern or Object Repository
	
	@FindBy(name ="email")
	WebElement username;
	
	@FindBy(name ="password")
	WebElement password;
	
	@FindBy(xpath ="//span[@class='e_a y_c y_f e_g e_b e_p v_a v_h v_j'][contains(text(),'Account')]")
	WebElement AccountBtn;
	
    @FindBy(xpath ="//div[contains(text(),'Sign In')]")
    WebElement SignInLink;
    
    @FindBy(xpath ="//button[@class='button m-margin-top'][contains(text(),'Sign In')]")
    WebElement SignInBtn;
    
    @FindBy(xpath=" //span[@class='elc-icon elc-icon-spark']")
    WebElement WalmartLogo;
    
    
    //constructor 
    public LoginPage(){
    	PageFactory.initElements(driver,this);   //pointing the current class object
    }
    
    //Actions get the pagetitle 
    public String validateLoginPageTitle(){
    	return driver.getTitle();
    }
    
    //get the logo
    public boolean validateWalmartLogo(){
    	return WalmartLogo.isDisplayed();
    }
    
    public HomePage login(String un,String pwd){
    	AccountBtn.click();
    	SignInLink.click();
    	username.sendKeys(un);
    	password.sendKeys(pwd);
    	SignInBtn.click();
    	
    	return new HomePage();
    }
    
    
    
    
    
    
    
}
