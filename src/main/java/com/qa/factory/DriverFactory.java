package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>(); 
	
	//This method is used to initialize the threadlocal driver on the basis of  browser
	public WebDriver init_driver(String browser) {
		
		System.out.println("Browser value is: "+ browser);
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else {
			System.out.println("Please pass the correct browser value: "+browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	// this method is used to get  the driver with thread local
	//Synchronized - when we are running multiple threads in parallel execution then it should in sync-
	//so we have user synchronized 
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
