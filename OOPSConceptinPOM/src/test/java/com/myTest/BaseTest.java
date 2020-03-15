package com.myTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.mypages.BasePage;
import com.mypages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	public Page page;

	@BeforeMethod
	@Parameters(value = { "browser" })
	public void setUpTest(String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("no browser defined in xml file ");
		}

		driver.get("https://www.monster.com/");
		try {
		Thread.sleep(6000);
		} catch( InterruptedException e) {
			e.printStackTrace();
		}

		page = new BasePage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	}


