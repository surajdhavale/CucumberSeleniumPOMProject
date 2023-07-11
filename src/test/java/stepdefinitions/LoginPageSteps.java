package stepdefinitions;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.*;

public class LoginPageSteps {
	
	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("https://tutorialsninja.com/demo/index.php?route=account/login");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println("Login page title is: "+title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotPasswordLinkExists());
	}

	@When("user enters valid username {string}")
	public void user_enters_valid_username(String username) {
		loginPage.enterUserName(username);
	}

	@When("user enters valid passeword {string}")
	public void user_enters_valid_passeword(String passwword) {
		loginPage.enterPassword(passwword);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLoginButton();
	}



}
