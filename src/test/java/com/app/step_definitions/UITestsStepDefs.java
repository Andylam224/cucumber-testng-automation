package com.app.step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.app.pages.SuiteCRMDashboardPage;
import com.app.pages.SuiteCRMLoginPage;
import com.app.pages.SuiteCRMSearchResultsPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.ConfigurationReader;
import com.app.utilities.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UITestsStepDefs {
	private WebDriver driver=Driver.getDriver();
	SuiteCRMLoginPage loginPage=new SuiteCRMLoginPage();
	SuiteCRMDashboardPage dashPage=new SuiteCRMDashboardPage();
	SuiteCRMSearchResultsPage searchResultsPage=new SuiteCRMSearchResultsPage();

	
	@Given("^I logged into suiteCRM$")
	public void i_logged_into_suiteCRM() {
		driver.get(ConfigurationReader.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		loginPage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
	}
	@Then("^CRM name should be SuiteCRM$")
	public void crm_name_should_be_SuiteCRM() {
	 assertTrue(driver.getTitle().endsWith("SuiteCRM"));
	}
	@Then("^Modules should be displayed$")
	public void modules_should_be_displayed() {
	assertTrue(	dashPage.sales.isDisplayed());
	assertTrue(	dashPage.marketing.isDisplayed());
	assertTrue(	dashPage.support.isDisplayed());
	assertTrue(	dashPage.activities.isDisplayed());
	assertTrue(	dashPage.collaboration.isDisplayed());
	assertTrue(	dashPage.all.isDisplayed());    
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String searchTerm) {
		//check if search box is visible
		try {
			assertTrue(dashPage.searchInput.isDisplayed());
		}catch(AssertionError e) {
			dashPage.searchButton.click();
		}
		dashPage.searchInput.click();
		dashPage.searchInput.sendKeys(searchTerm+Keys.ENTER);
}

	@Then("^link for user \"([^\"]*)\" should be displayed$")
	public void link_for_user_should_be_displayed(String searchTerm) {
    assertTrue(searchResultsPage.resultLink(searchTerm).isDisplayed());
}
	@Then("^there should be (\\d+) result for \"([^\"]*)\"$")
	public void there_should_be_result_for(int count, String searchTerm) {
		int actual=searchResultsPage.resultsLink(searchTerm).size();
		System.out.println(actual);
		assertEquals(actual,count,"number of results did not match");
	}

}
