package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;


public class AccountPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	private WebDriver driver;
	
	
	@Given("User has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
		
		List<Map<String, String>> credList = dataTable.asMaps();
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		
		DriverFactory.getDriver().get("https://tutorialsninja.com/demo/index.php?route=account/login");
		accountsPage =  loginPage.doLogin(userName, password);
	}

	@Given("User is on accounts page")
	public void user_is_on_accounts_page() {
		accountsPage.getTitle();
	}

	@Then("user gets account section")
	public void user_gets_account_section(DataTable sectionTable) {
//		JavascriptExecutor j = (JavascriptExecutor)driver;
//		j.executeScript("window.scrollBy(0,-500)", "");

	List<String> expectedSectionList = sectionTable.asList();
	List<String> actualSectionList = accountsPage.getAccountsSccetionList();
	System.out.println("Expected Section List: "+expectedSectionList);
	System.out.println("Actual Section List: "+ actualSectionList);
	
	//Assert.assertTrue(expectedSectionList.containsAll(actualSectionList));
	Assert.assertTrue(expectedSectionList.containsAll(actualSectionList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
		Assert.assertTrue(accountsPage.getAccountSectionCount() == expectedSectionCount);
	}


}
