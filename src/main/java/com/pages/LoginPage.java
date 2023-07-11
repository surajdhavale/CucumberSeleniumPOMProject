package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	//By locators
	
	private By emaild = By.id("input-email");
	private By password = By.id("input-password");
	private By logInButon = By.xpath("//input[@type='submit']");
	private By forgotPasswordLink  =By.xpath("(//a[contains(.,'Forgotten Password')])[1]");
	
	//Constructor of the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//page Actions: features(behaviours) of the page  from the methods:
	
	public String getLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public boolean isForgotPasswordLinkExists() {
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}
	
	public void enterUserName(String username) {
		driver.findElement(emaild).sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnLoginButton() {
		driver.findElement(logInButon).click();
	}
	
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("Login with "+un+ " and password "+pwd);
		driver.findElement(emaild).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(logInButon).click();
		return new AccountsPage(driver);
	}
}
