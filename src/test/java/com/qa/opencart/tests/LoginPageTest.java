package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.Constants;

public class LoginPageTest extends BaseTest{
	
	@Test
	public void LoginPageTitleTest() {
		String acTittle=loginpage.getLoginPageTitle();
		System.out.println("Loginpage title: "+ acTittle);
		Assert.assertEquals(acTittle, Constants.LOGIN_PAGE_TITLE);
	}

	@Test
	public void LoginPageURLTest() {
		String actURL=loginpage.getURL();
		System.out.println("Loginpage URL: "+ actURL);
		Assert.assertTrue(actURL.contains(Constants.LOGIN_PAGE_URL_FRACTION));
	}
	@Test
	public void forgotPWDLinkExitsTest() {
		Assert.assertTrue(loginpage.isForgotLinkExist());
	}
	@Test
	public void registerLinkExitsTest() {
		Assert.assertTrue(loginpage.isRegisterLinkExist());
	}
	
	@Test(priority = 1)
	public void loginTest() {
		//df.preloginstep();
		Assert.assertTrue(loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password")).isLogoutLinkExist());
	}
	
	

	
	
	
}
