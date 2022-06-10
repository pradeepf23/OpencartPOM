package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.Constants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {

	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By productDetail =By.cssSelector("#content h1");
	private By productImage = By.cssSelector("ul.thumbnails img");
	private By qty= By.cssSelector("#input-quantity");
	private By addToCart = By.xpath("//div[@id='product']//button");
	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	public String getProductHeaderName() {
		return eleUtil.waitForElementVisible(productDetail, Constants.DEFAULT_ELEMENT_TIME_OUT).getText();
	}
	
	public int getProductImgCount() {
		return eleUtil.waitForElementsVisible(productImage, Constants.DEFAULT_ELEMENT_TIME_OUT).size();
	}
	
//	public void addProductQTY() {
//		eleUtil.waitForElementVisible(qty, Constants.DEFAULT_ELEMENT_TIME_OUT).sendKeys("4");
//		eleUtil.doClick(addToCart);
//	}
}
