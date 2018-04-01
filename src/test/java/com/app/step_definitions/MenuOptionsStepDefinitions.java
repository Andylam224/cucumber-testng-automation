package com.app.step_definitions;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.app.pages.SuiteCRMDashboardPage;
import com.app.utilities.BrowserUtils;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MenuOptionsStepDefinitions {
	SuiteCRMDashboardPage dashboard=new SuiteCRMDashboardPage();
	

@When("^I hover over the (Collaboration|Sales|Marketing|Activities|Support|All) menu$")
public void i_hover_over_the_Collaboration_menu(String menu) {
switch(menu)	{
	case "Sales":
		BrowserUtils.hover(dashboard.sales);
		break;
	case "Marketing":
		BrowserUtils.hover(dashboard.marketing);
		break;
	case "Support":
		BrowserUtils.hover(dashboard.support);
		break;
	case "Collaboration":
		BrowserUtils.hover(dashboard.collaboration);
		break;
	case "Activities":
		BrowserUtils.hover(dashboard.activities);
		break;
	case "All":
		BrowserUtils.hover(dashboard.all);
		break;
}
	
}

@Then("^following menu options should be visisble for (Collaboration|Sales|Marketing|Activities|Support|All):$")
public void following_menu_options_should_be_visisble_for_Collaboration(String menu,List<String> options) {
   //capture list of webelements
	List<WebElement> topMenuOptions=dashboard.topMenuOptions(menu);
	//get their text in list
	List<String> topMenuOptionsString=BrowserUtils.getElementText(topMenuOptions);
	//compare the list with options
	assertEquals(topMenuOptionsString.size(),options.size(),"Number of expected menu options did not match");
	//compare the options are same text in the same index
	for(int i=0;i<options.size();i++) {
		assertEquals(topMenuOptionsString.get(i),options.get(i));
	}
    }
    	
	
}

