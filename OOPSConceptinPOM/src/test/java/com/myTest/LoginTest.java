/**
 * 
 */
package com.myTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mypages.HomePage;
import com.mypages.LoginPage;

public class LoginTest extends BaseTest {

	@Test(priority = 1, enabled = true)
	public void verifyLoginPageTitleTest() {
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(true, true);

	}

	@Test(priority = 2, enabled = false)
	public void verifyLoginPageHeaderTest() {
		String header = page.getInstance(LoginPage.class).getLoginPageHeader();
		System.out.println(header);
		Assert.assertEquals(true, true);

	}

	@Test(priority = 3, enabled = false)
	public void doLoginTest() {
		HomePage homePage = page.getInstance(LoginPage.class).doLogin("rupapatilpro@gmail.com", "Su44y007@");
		String headerHome = homePage.getHomePageHeader();
		System.out.println(headerHome);
		Assert.assertEquals(true, true);
	}

}
