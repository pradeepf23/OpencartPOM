package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	WebDriver driver;
	Properties prop;
	OptionsManager optionsManager;
	
	public static ThreadLocal<WebDriver> tlDriver= new ThreadLocal<WebDriver>();
	
	public WebDriver init_driver(Properties prop) {
		String browserName= prop.getProperty("browser").trim();
		optionsManager= new OptionsManager(prop);
		
		System.out.println("Browser name is : "+ browserName);
		
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver= new ChromeDriver(optionsManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}
		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver= new FirefoxDriver(optionsManager.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		}
		else if(browserName.equals("safari")) {
			//driver= new SafariDriver();
			tlDriver.set(new SafariDriver());
		}
		else {
			System.out.println("please pass the right browser :" + browserName);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getDriver().findElement(By.xpath("//a[@title='My Account']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getDriver().findElement(By.linkText("Login")).click();
		*/
		return getDriver();
	}
	
	public WebDriver getDriver() {
	
		return tlDriver.get();
	}
	
	/*
	 * this method is used to initialize the properties
	 */
	
	public Properties init_prop() {
		try {
			FileInputStream ip= new FileInputStream("./src/test/resources/config/config.properties");
			prop= new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	
	/*
	 * tak screenshot
	 */
	
	public String getScreenshot() {
		File srcFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = "./"+"screenshot/"+System.currentTimeMillis()+".png";
		File destinatin = new File(path);
		try {
			FileUtils.copyFile(srcFile, destinatin);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	
	
	
	}

