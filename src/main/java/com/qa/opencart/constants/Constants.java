package com.qa.opencart.constants;

import java.util.Arrays;
import java.util.List;

public class Constants {

	
	public static final int DEFAULT_TIME_OUT = 5;
	
	public static final int DEFAULT_ELEMENT_TIME_OUT = 10;


	public static final String LOGIN_PAGE_TITLE = "Account Login";

	public static final String LOGIN_PAGE_URL_FRACTION = "route=account/login";

	public static final String ACCOUNT_PAGE_TITLE = "My Account";



	public static final String ACCOUNTS_PAGE_URL_FRACTION = "route=account/accoun";

	public static final String ACCOUNTS_PAGE_HEADER = "Account";
	
	public static final List<String> EXPECTED_ACCOUNTS_SECTION_LIST = 
			Arrays.asList("My Account", 
						"My Orders", 
						"My Affiliate Account", 
						"Newsletter");
	

	public static final String LOGOUT_SUCESS_MSG = "Account Logout";

	public static final String ACCOUNT_REGISTER_SUCCESS_MSG = "Your Account Has Been Created";

	
	//************sheet names************//


	public static final String REGISTER_SHEET_NAME = "Register";

	public static final String PRODUCT_SHEET_NAME = "Product";
	
	

	

	
	

	

}
