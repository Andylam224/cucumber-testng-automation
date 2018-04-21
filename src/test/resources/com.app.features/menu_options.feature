Feature: SugarCRM menu options

@smoke
Scenario: Verify Collaboratino menu options
Given I logged into suiteCRM
When I hover over the Collaboration menu
Then following menu options should be visisble for Collaboration:
	|Home|
	|Emails|
	|Documents|
	|Projects|
	
@f&f
Scenario: Verify Support menu options
Given I logged into suiteCRM
When I hover over the Support menu
Then following menu options should be visisble for Support:
	|Home|
	|Accounts|
	|Contacts|
	|Cases|

@f&f
Scenario: Verify Sales menu options
Given I logged into suiteCRM
When I hover over the Sales menu
Then following menu options should be visisble for Sales:
	|Home|
	|Accounts|
	|Contacts|
	|Opportunities|
	|Leads|
	





