package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.Constants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By emailId= By.id("input-email");
	private By password= By.id("input-password");
	private By signinbtn= By.xpath("//input[@type='submit']");
	private By forgotlink=By.linkText("Forgotten Password");
	private By registerlink=By.linkText("Register");
	private By logOutMsg= By.cssSelector("div#common-success h1");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		eleUtil =new ElementUtil(this.driver);
	}
	
	public String getLoginPageTitle() {
		return eleUtil.waitForTitleIs(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}
	
	public String getURL() {
		return eleUtil.waitForUrlContains(Constants.LOGIN_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
	}
	
	public boolean isForgotLinkExist() {
		return eleUtil.doIsDisplayed(forgotlink);
	}
	
	public boolean isRegisterLinkExist() {
		return eleUtil.doIsDisplayed(registerlink);
	}
	
	
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("login creds are :" + un +" : " + pwd);
		//driver.findElement(By.xpath("//a[@title='My Account']")).click();
		//driver.findElement(By.linkText("Login")).click();
		eleUtil.waitForElementVisible(emailId, Constants.DEFAULT_ELEMENT_TIME_OUT).sendKeys(un);
		eleUtil.doSendKeys(password, pwd);		
		eleUtil.doClick(signinbtn);
		return new AccountsPage(driver);
	}

	public String getLogoutSucessMessg() {
		return eleUtil.waitForElementVisible(logOutMsg, Constants.DEFAULT_ELEMENT_TIME_OUT).getText();
		
	}
	
	public ReisterPage goToRegisterPage() {
		eleUtil.doClick(registerlink);
		return new ReisterPage(driver);
	}

}
