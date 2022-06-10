package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.Constants;
import com.qa.opencart.utils.ElementUtil;

public class ReisterPage {

	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By firstname= By.id("input-firstname");
	private By lastname= By.id("input-lastname");
	private By email=By.id("input-email");
	private By telephone= By.id("input-telephone");
	private By password= By.id("input-password");
	private By confirmPWD= By.id("input-confirm");
	private By subscribeYes= By.xpath("//label[@class='radio-inline']/input[@value='1' and @type='radio']");
	private By subsrcibeNo= By.xpath("//label[@class='radio-inline']/input[@value='0' and @type='radio']");
	
	private By registerSuccessMsg= By.cssSelector("div#content h1");
	
	private By agree= By.name("agree");
	private By continueBtn= By.xpath("//input[@type='submit' and @value='Continue']");
	
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	
	public ReisterPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	
	public boolean registerUser(String firstname, String lastname, String email, String telephone,String password, String subscribe) {
		WebElement firstname_ele= eleUtil.waitForElementVisible(this.firstname, Constants.DEFAULT_ELEMENT_TIME_OUT);
		firstname_ele.clear();
		firstname_ele.sendKeys(firstname);
		eleUtil.doSendKeys(this.lastname, lastname);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.telephone, telephone);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(this.confirmPWD, password);
		
		if(subscribe.equalsIgnoreCase("yes")) {
			eleUtil.doClick(subscribeYes);
		}else {
			eleUtil.doClick(subsrcibeNo);
		}
		
		eleUtil.doClick(agree);
		eleUtil.doClick(continueBtn);
		
		String successMesg= eleUtil.waitForElementVisible(registerSuccessMsg, Constants.DEFAULT_TIME_OUT).getText();
		System.out.println(successMesg);
		if(successMesg.contains(Constants.ACCOUNT_REGISTER_SUCCESS_MSG)) {
			
			eleUtil.doClick(logoutLink);
			eleUtil.doClick(registerLink);
			return true;
			
		}
		eleUtil.doClick(logoutLink);
		eleUtil.doClick(registerLink);
		return false;
	}
	}


