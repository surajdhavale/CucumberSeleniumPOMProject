package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
	
	private WebDriver driver;
	
	private By accountsSection = By.xpath("//aside[@id=\"column-right\"]//div[@class=\"list-group\"]");
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public int getAccountSectionCount() {
		return driver.findElements(accountsSection).size();
	}
	
	public List<String> getAccountsSccetionList() {
		
	    List<String> accountsList = new ArrayList<>();
		List<WebElement> accountHeaderList = driver.findElements(accountsSection);

		
		for(WebElement e : accountHeaderList) {
			String text = e.getText();
			System.out.println("text: "+text);
			accountsList.add(text);
		}
	
		
		return accountsList;
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	

}
