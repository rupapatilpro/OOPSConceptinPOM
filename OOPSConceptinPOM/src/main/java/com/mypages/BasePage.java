package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

	// BasePage - OOPS Concept in Java, I use @Override method.

	// How to get @Override method automatically here ?
	// Ans - after creating public class BasePage extends Page . It will show error
	// on BasePage we need to choose or click on Add unimplemeneted methods so it
	// will automatically create all methods with method body with @Override symbol.

	// What is method Override in java ?
	// Ans - In Parent calss we have one method & in Child class also we have same
	// method with same name & same number of parameter that is called method
	// Overriding. @Override is a symbol to show that this method is Override .
	// here Page class is a (Parent class) have method String getPageTitle(); &
	// BasePage is a (Child class) have same String getPageTitle();

	public BasePage(WebDriver driver) {
		super(driver);

	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();

	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
		
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			waitForElementPresent(locator);
			element = driver.findElement(locator);
			return element;
		} catch (Exception e) {
			System.out.println("some error occured while creating element " + locator.toString());
			e.printStackTrace();
		}
		return element;
	}

	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		catch (Exception e) {
			System.out.println("some exception/error occured while waitting for the element" + locator.toString());
		}

	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		} catch (Exception e) {
			System.out.println("some exception/error occured while waitting for the element" + title);
		}

	}

}
