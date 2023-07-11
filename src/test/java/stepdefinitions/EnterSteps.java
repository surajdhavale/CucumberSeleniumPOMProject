package stepdefinitions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import junit.framework.Assert;

public class EnterSteps {
	
	WebDriver driver = new ChromeDriver();
	
	@Given("User is on registration page")
	public void user_is_on_registration_page() {
	driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
	}

	@When("User enters valid userName {string}")
	public void user_enters_valid_user_name(String email) {
		driver.findElement(By.id("input-email")).sendKeys(email);
	}

	@When("User enters valid {string}")
	public void user_enters_valid(String password) {
		driver.findElement(By.id("input-password")).sendKeys(password);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
	}

	@Then("User gets the title of the page {string}")
	public void user_gets_the_title_of_the_page(String title) {
		String actuatitle = driver.getTitle();
		Assert.assertTrue(actuatitle.contains(title));
	}
	
	@Then("Close the browser")public void close_the_browser() {
		driver.quit();
	}

}
