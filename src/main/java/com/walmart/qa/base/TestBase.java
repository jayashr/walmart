package com.walmart.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.walmart.qa.util.TestUtil;

public class TestBase {
	
public	static WebDriver driver;
public	static Properties prop;

	public TestBase(){
		
			prop = new Properties();       //creating object 
			FileInputStream ip;
			try {
			
				ip = new FileInputStream("C:\\Users\\Swara\\workspace\\WalmartMaven\\src\\main\\java\\com\\walmart\\qa\\config\\config.properties");
			                            
				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
			}
	
	public static void initialization(){
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Installation\\chromedriver_win32\\chromedriver.exe");
	   	     driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("FF")){
			System.setProperty("webdriver.gecko.driver","C:\\Installation\\geckodriver-v0.23.0-win64\\geckodriver.exe");
	   	     driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
   	    driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
   	    
   	  
		driver.get(prop.getProperty("url"));
		
	  }
	}
