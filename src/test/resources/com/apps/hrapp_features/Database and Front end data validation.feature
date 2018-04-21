Feature: Hr Application Database and UI data verification

Background: 
Given I am on DeptEmpPage


Scenario: Department data Ui and Database verfication
When I search for department id 60
Then I query database with sql "Select department_name,manager_id,location_id from departments where department_id=10"
Then UI data and Database data must match
@HRAppDB
Scenario Outline: Firstname and lastname search by email-UI vs DB verification
When I search for email "<email>" to see firstname and lastname
And I query database with sql "Select first_name,last_name From employees where email='<email>'"
Then UI data and Database data must match
Examples: 
|email|
|JWHALEN|
|HBAER|
|JRUSSEL|
@HRAppDB

Scenario Outline: Verify Number of employees for departments 
When I search for department id <departmentID> and get number of employees
And I query database with sql "Select count(*) as EMPLOYEES_COUNT from employees where department_id=<departmentID>"
Then UI data and Database data must match
Examples: 
|departmentID|
|50|
|60|

