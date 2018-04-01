package com.app.step_definitions;

import java.util.Map;

import com.app.pages.SuiteCRMContactInformationPage;
import com.app.pages.SuiteCRMCreateContactPage;
import com.app.pages.SuiteCRMDashboardPage;
import com.app.utilities.BrowserUtils;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;

public class CreateContactMapsStepDefinitions {
	
SuiteCRMCreateContactPage createContact=new SuiteCRMCreateContactPage();
SuiteCRMContactInformationPage contactInformation=new SuiteCRMContactInformationPage();
SuiteCRMDashboardPage dashboard = new SuiteCRMDashboardPage();
	
	
	@When("^I create a new contact:$")
	public void i_create_a_new_contact(Map<String,String>contact) {
		// open the create contact dialog
				BrowserUtils.hover(dashboard.createLink);
				dashboard.createContact.click();
				// enter information
				if (contact.get("first_name") != null) {
					createContact.firstName.sendKeys(contact.get("first_name"));
				}
				if (contact.get("last_name") != null) {
					createContact.lastName.sendKeys(contact.get("last_name"));
				}
				if (contact.get("office_phone") != null) {
					createContact.officePhoneNumber.sendKeys(contact.get("office_phone"));
				}
				if (contact.get("cell_phone") != null) {
					createContact.cellPhone.sendKeys(contact.get("cell_phone"));
				}
				// save
				createContact.save();
}
}
