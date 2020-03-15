
package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	// LoginPage - OOPS Concept in Java , 1)I use Encapsulation with the help of get
	// and set methods & 2)Inheritance with the help of WebElement method 3)Method
	// Overloading with the help of Login method passing different parameter.

	// *****Java Inheritance (Subclass and Superclass) - In Java, it is possible to
	// inherit attributes and methods from one class to another. We group the
	// "inheritance concept" into two categories:
	// subclass (child) - the class that inherits from another class
	// superclass (parent) - the class being inherited from.
	// To inherit from a class, use the extends keyword.

	// ***** Method Overloading- If a class has multiple methods having same name
	// but
	// different in parameters, it is known as Method Overloading.

	// ******getters: we need to use concept of Encapsulation. that how to access
	// private
	// variables of the class with the help of public variables.
	// The meaning of Encapsulation, is to make sure that "sensitive" data is hidden
	// from users. To achieve this, you must:

	// ***** Encapsulation : declare class variables/attributes as private.
	// provide public get and set methods to access and update the value of a
	// private variable

	// Page Locators:
	private By LogIn = By.xpath("//ul[@id='s-menu-d']//a[contains(text(),'Log In')] ");
	private By emailaddress = By.id("EmailAddress");
	private By password = By.id("Password");
	private By SignIn = By.id("btn-login");
	private By header = By.xpath("//h1[contains(text(),'Sign In With Monster Account')] ");

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	// How to create getters metehod here ?
	// Ans - Right Click - go to Source - click on Generate Getters & Setters - next
	// window show - Select getters & setters to create- click on or select all
	// locators such as emailaddress, password etc . click on Access Modifier -
	// public - click on Generate method comments - click on OK or finish. so it
	// will automatically generate Getters & Setters method below.
	// we dont need set method so we need to delete set methods.only keep get
	// methods It will disply or show - public By getEmailaddress() {
	// now getEmailaddress() - should return WebElement so we can perform direclly
	// sendkeys() or directlly click ()on that particular method . because dot
	// (.)sendkeys() & dot(.)
	// click ()happened only WebElement , not on By locator.

	// ****OOPS CONCEPT in Java -Inheritance - how to get WebElement here ?
	// Ans -the WebElement method we already mentioned or written in BasePage class
	// so we need to inheritance / inherited that method here. so we can use this
	// WebElement method here directlly without creating the object. so we need to
	// change public By getEmailaddress() to public WebElement getPassword() &
	// return emailaddress; to return getElement(emailaddress);

	// public By getEmailaddress() {
	// return emailaddress;

	// public getters:

	/**
	 * @return the emailaddress
	 */
	public WebElement getLogIn() {
		return getElement(LogIn);
	}
	/**
	 * @return the emailaddress
	 */
	public WebElement getEmailaddress() {
		return getElement(emailaddress);
	}

	/**
	 * @return the password
	 */
	public WebElement getPassword() {
		return getElement(password);
	}

	/**
	 * @return the signIn
	 */
	public WebElement getSignIn() {
		return getElement(SignIn);
	}

	/**
	 * @return the header
	 */
	public WebElement getHeader() {
		return getElement(header);
	}

	public String getLoginPageTitle() {
		return getPageTitle();
	}

	public String getLoginPageHeader() {
		return getPageHeader(header);

	}

	// Valid username & password Login method.
	public HomePage doLogin(String username, String pwd) {
		getLogIn().click();
		getEmailaddress().sendKeys(username);
		getPassword().sendKeys(pwd);
		getSignIn().click();

		return getInstance(HomePage.class);

		// getInstance method I already written in pageClass so I caleed that method
		// drirecly here & once I click on SignIn button (Login Page) it will land on
		// Home Page so I mentioned above - return getInstance(HomePage.class);
		// I need to change public void doLogin(String username, String pwd) to public
		// HomePage doLogin(String username, String pwd) {
	}

	// InValid username & password Login method for Negative testing scnerios below.
	// **** OOPS CONCEPT in Java - Method Overloading below .
	// If a class has multiple methods having same name but different in parameters,
	// it is known as Method Overloading.
	// here public void doLogin() dont pass zero or blank parameter( no username &
	// password) - Method Overloading example as a Negative testing.

	public void doLogin() {
			getEmailaddress().sendKeys("");
			getPassword().sendKeys("");
			getSignIn().click();

			
	}

	// **** OOPS CONCEPT in Java - Method Overloading below .
	// InValid username Login method for Negative testing scnerios below.
	// here public void doLogin() pass only one parameter( username)
	// username = rupapatilpro@gmail.com

	public void doLogin(String userCred) {
		if(userCred.contains("username")) {
			getEmailaddress().sendKeys(userCred.split(":")[1].trim());
		}else if(userCred.contains("password")) {
			getEmailaddress().sendKeys(userCred.split(":")[1].trim());
		}
		getSignIn().click();
	}
}

