package com.ebay.SeleniumFramework.Login;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
//importing test base and sign on classes from other packages
import org.testng.annotations.Test;
import com.ebay.DataDrivenFrameworkPages.SignOnPage;
import com.ebay.SeleniumFramework.TestBase.TestBase;

import junit.framework.Assert;



public class TC001_VerifyLogin extends TestBase{

	//folder location is pointed at here
		static String projectLocation = System.getProperty("user.dir");
		
		//gives the entire path
		static String configPath = projectLocation+"/log4j.properties";
	@BeforeClass
	public static void getLogger() {
		System.out.println(configPath);
		//Reading the property file at this stage
		PropertyConfigurator.configure(configPath);
	}
	//initialize the logger class
			public static final Logger log = Logger.getLogger(Logger.class.getName());
	@Test
	public void validLogin() {
		SignOnPage sp = PageFactory.initElements(driver, SignOnPage.class);
		sp.userName.sendKeys("soumyadeep96");
		sp.passwordTextBox.sendKeys("qwerty");
		sp.loginButton.click();
		Assert.assertTrue(driver.getTitle().contains("Find a Flight"));
	}

	
		@Test
		public void testLogger() {
			log.info("testcase passed");
			log.warn("please check the warning");
			log.info("testcase passed");
			log.error("Critical Error");
	}
	
	
	
}
