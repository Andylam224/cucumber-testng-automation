
Feature:  Note on Dashboard
@testing
Scenario: Post a note on Dashboard
Given  I logged into suiteCRM
When I post "Hello Everyone"
Then Post should be displayed
	Then I logout from application
	
	
	@testing
	Scenario: Post another note on Dashboard
Given  I logged into suiteCRM
When I post "Hello Everyone"
Then Post should be displayed
	Then I logout from application
	

