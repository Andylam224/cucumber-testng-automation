Feature: Creating contacts

  Scenario: Create contact using CREATE page
    When I logged into suiteCRM
    And I open the create contact page
    And I enter the first name "Bilbo" and the last name "Baggins"
    And I enter the phone number "240-123-3210"
    And I enter the department "IT"
    When click on the save button
    Then I should see contact information for "Bilbo Baggins"
@tagg
  Scenario: Create contact using CREATE page
    When I logged into suiteCRM
    And I open the create contact page
    And I enter the first name "Sarah" and the last name "Connor"
    And I enter the phone number "240-123-3210"
    And I enter the department "IT"
    When click on the save button
    Then I should see contact information for "Sarah Connor"

  Scenario Outline: Create multiple contacts
    When I logged into suiteCRM
    And I open the create contact page
    And I enter the first name "<firstname>" and the last name "<lastname>"
    And I enter the phone number "<phonenumber>"
    And I enter the department "<department>"
    When click on the save button
    Then I should see contact information for "<firstname> <lastname>"
    Examples: 
      | firstname | lastname | phonenumber    | department |
      | Satoshi   | Nakamuro | 98724398472947 | IT         |
      | John      | Snow     |     4132345567 | Sales      |
      | Bonnie    | Garcia   |     0928398887 | IT         |
      | Maddy     | TheDaddy |     3459879654 | HR         |
      | Rhiannon  | Morrison | 1-917-4613     | aa         |
      | Zeus      | Wright   | 1-328-4518     | ing        |
      | Samantha  | Maxwell  | 1-678-3953     | ss         |
      | Neil      | Sampson  | 1-826-6519     | ting       |
      | Teagan    | Larsen   | 1-247-2016     | dd         |
      | Kermit    | Goff     | 1-732-3727     | ing        |
      | Dennis    | Hoffman  | 1-602-5630     | ting       |
      | Quon      | Frank    | 1-191-8707     | sdf        |
      | Mason     | Mendez   | 1-710-5803     | sd         |
      | Herrod    | Berry    | 1-966-9204     | ing        |
      | Inez      | Slater   | 1-442-3808     | df         |
      | Todd      | Lyons    | 1-537-7100     | df         |
      | Brendan   | Meyer    | 1-1280-7814    | df         |
      
      #CTRL+SHIFT+F - formats the code
