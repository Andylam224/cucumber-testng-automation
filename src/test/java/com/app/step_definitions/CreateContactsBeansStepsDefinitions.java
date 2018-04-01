package com.app.step_definitions;

import java.util.List;

import com.app.beans.ContactBean;
import com.app.pages.SuiteCRMContactInformationPage;
import com.app.pages.SuiteCRMCreateContactPage;
import com.app.pages.SuiteCRMDashboardPage;
import com.app.utilities.BrowserUtils;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;

public class CreateContactsBeansStepsDefinitions {

	SuiteCRMCreateContactPage createContact=new SuiteCRMCreateContactPage();
	SuiteCRMContactInformationPage contactInformation=new SuiteCRMContactInformationPage();
	SuiteCRMDashboardPage dashboard = new SuiteCRMDashboardPage();
	

	@When("^I save a new contact:$")
	public void i_save_a_new_contact(List<ContactBean> contacts) {
	    ContactBean contactBean=contacts.get(0);
	    //open the create contact page
	    BrowserUtils.hover(dashboard.createLink);
		dashboard.createContact.click();
	    //enter data
		createContact.firstName.sendKeys(contactBean.getFirstName());
		createContact.lastName.sendKeys(contactBean.getLastName());
		createContact.officePhoneNumber.sendKeys(contactBean.getOfficePhone());
		createContact.cellPhone.sendKeys(contactBean.getCellPhone());
		createContact.department.sendKeys(contactBean.getDepartment());
		
		// save
		createContact.save();
	    
	    
	   
	    
	  

	    
	}
	
	
}
