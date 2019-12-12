package com.ebay.SeleniumFramework.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBase {

	public WebDriver driver;
	@BeforeTest
	public void initializeThis() throws IOException {
		Properties prop = new Properties();
		String projectLocation = System.getProperty("user.dir");
		String configPath = projectLocation+"/Resources/data.properties";
	
		System.out.println(configPath);
	
		//here we have location of the property file
		FileInputStream fis = new FileInputStream(configPath);
		
		//load properties file
		prop.load(fis);
		//read the property file
		String browserName = prop.getProperty("browser");
		String urlName = prop.getProperty("url");
		int waitTime = Integer.parseInt(prop.getProperty("implicitWait"));
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\irock\\Desktop\\Automation\\Drivers\\Chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(urlName);
			driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\irock\\Desktop\\Automation\\Drivers\\Firefoxdriver\\firefoxdriver.exe");
			driver = new FirefoxDriver();
			driver.get(urlName);
			driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\irock\\Desktop\\Automation\\Drivers\\Edgedriver\\edgedriver.exe");
			driver = new EdgeDriver();
			driver.get(urlName);
			driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
		}
	}
	
	@AfterTest
	public void endThis() {
	//	driver.quit();
	}
}
