package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.Constants;
import com.qa.opencart.utils.ExcelUtil;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;


public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void accSetup() {
		accpage = loginpage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
		// accpage = loginpage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
		//accPage = new AccountsPage(driver);
	}

	@Test
	public void accPageTitleTest() {
		String actTitle = accpage.getAccountsPageTitle();
		System.out.println("Acc page title: " + actTitle);
		Assert.assertEquals(actTitle, Constants.ACCOUNT_PAGE_TITLE);
	}

	@Test
	public void accPageURLTest() {
		String actURL = accpage.getAccountsPageURL();
		System.out.println("Acc page URL: " + actURL);
		Assert.assertTrue(actURL.contains(Constants.ACCOUNTS_PAGE_URL_FRACTION));
	}

	@Test
	public void accPageHeaderTest() {
		Assert.assertEquals(accpage.getAccPageHeader(), Constants.ACCOUNTS_PAGE_HEADER);
	}

	@Test
	public void accPageSectionsTest() {
		List<String> actAccSecList = accpage.getAccountsPageSectionsList();
		System.out.println("Act Accounts Section list: " + actAccSecList);
		Assert.assertEquals(actAccSecList, Constants.EXPECTED_ACCOUNTS_SECTION_LIST);
	}

	@Test
	public void logoutLinkTest() {
		Assert.assertTrue(accpage.isLogoutLinkExist());
	}

	@Test
	public void SearchExistTest() {
		Assert.assertTrue(accpage.isSearchExist());
	}

	@Test
	public void logoutTest() {
		Assert.assertEquals(accpage.clickOnLogout().getLogoutSucessMessg(),Constants.LOGOUT_SUCESS_MSG);
	}
	
	@DataProvider
	public Object[][] getSearchKey() {
		return new Object[][] {
			{"Macbook"},
			{"Samsung"},
			{"iMac"},
			{"Apple"}
		};
	}
	
	@Test(dataProvider = "getSearchKey")
	public void searchTest(String searchKey) {
		searchResPage = accpage.doSearch(searchKey);
		Assert.assertTrue(searchResPage.searchResultsCount()>0);
	}
	
//	@DataProvider
//	public Object[][] getProductName() {
//		return new Object[][] {
//			{"Macbook","MacBook Air"},
//			{"Samsung", "Samsung SyncMaster 941BW"},
//			{"iMac", "iMac"},
//			{"Apple", "Apple Cinema 30\""}
//		};
//	}
	
	@DataProvider
	public Object[][] getProductName(){
		return ExcelUtil.getTestData(Constants.PRODUCT_SHEET_NAME);
	}

	@Test(dataProvider = "getProductName")
	public void selectProductTest(String searchKey, String productName) {
		searchResPage = accpage.doSearch(searchKey);
		productInfoPage = searchResPage.selectProduct(productName);
		String productHeader = productInfoPage.getProductHeaderName();
		System.out.println("product header: " + productHeader);
		Assert.assertEquals(productHeader, productName);
	}
	
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
			{"Macbook","MacBook Air", 4},
			{"Samsung", "Samsung SyncMaster 941BW", 1}
			
		};
	}
		
	@Test(dataProvider = "getProductData")
	public void productImageTest(String searchKey, String productName, int productImgCount) {
		searchResPage = accpage.doSearch(searchKey);
		productInfoPage = searchResPage.selectProduct(productName);
		Assert.assertEquals(productInfoPage.getProductImgCount(), productImgCount);
		
	}
	
//	@Test
//	public void productQtyTest() {
//		productInfoPage.addProductQTY();
//	}
	
	}