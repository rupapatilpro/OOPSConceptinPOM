package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

	// Page class - OOPS Concept in Java, I use abstract method.

	// What is abstract methods ?
	// Ans - abstract methods means without method body .
	// 1. how to create abstract class Page
	// OOPSConceptinPOM- right click on package com.mypages - New -Class - Name give
	// Page - Modifier select abstract - click on finish.

	WebDriver driver;
	WebDriverWait wait;

	// 2. We need to create abstract Constructor for Page Class.
	// we cannot create the object of Abstract Class so we need to create
	// Constructor of Page class.
	// below is abstract class constructor - ( public Page(WebDriver driver)
	// 3. here implicitWait = new WebDriverWait(this.driver, 30);

	// page class constructor:
	public Page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 30);

	}
	// 4. What is abstract methods ?
	// Ans - abstract methods means without method body .

	// 5. What is difference between abstract methods & non abstract methods ?
	// Ans - abstract methods should be written by abstract
	// keyword only & non abstract methods not written by abstract keyword. but in
	// abstract class we can write abstract methods & non abstract methods is
	// allowed.

	// abstract methods - we need to define abstract methods here - every page
	// should have this kind of methods.
	// 6. VIP In abstract class abstract methods should be written by abstract
	// keyword only. if we dont give abstract keyword it will show error & not
	// perform. (public abstract void getPageTitle();

	public abstract String getPageTitle();

	public abstract String getPageHeader(By locator);

	public abstract WebElement getElement(By locator);

	public abstract void waitForElementPresent(By locator);

	public abstract void waitForPageTitle(String title);



	// create a method with Java Generics and return a new page.
	// below is non abstract method (public <TPage extends BasePage> TPage
	// getInstance(Class<TPage> pageClass) {

	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class, WebDriverWait.class).newInstance(this.driver,
					this.wait);
		} catch (Exception e) {
			e.printStackTrace();
			return null;

			// here is simple explanation for Java Generics - At a run or execution time
			// whatever the page class we need to passing for eg: Login Page or Home Page we
			// need to checking with getDeclaredConstructor with passing the WebDrive
			// Instance & createing
			// the object of that particular class .so instead of writting LoginPage page =
			// new LoginPage .
			// instead of new keyword we are using newInstance.
			// newInstance is use to create the object of that particular class. its
			// actually repersent the constructor.
		
	}

	}

	public String getPageTitle(By logIn) {
		// TODO Auto-generated method stub
		return null;
	}

}
