package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	private By logo = By.xpath("//*[@id='m-logo-wordmark'] ");

	public HomePage(WebDriver driver) {
		super(driver);

	}

	public WebElement getLogo() {
		return getElement(logo);
	}

	// Page Actions below :
	public String getHomePageTitle() {
		return getPageTitle();

	}

	public String getHomePageHeader() {
		return getPageHeader(logo);

	}

}
