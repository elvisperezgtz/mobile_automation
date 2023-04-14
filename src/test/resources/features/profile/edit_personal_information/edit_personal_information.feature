@editPersonalInformation @regression  @hookPersonalData
Feature: Edit personal information
  As a shopkeeper user
  I require that after the successful entity validation, the application allows me to edit and update the bank data captured in the on boarding process of the application,
  so that the user can make adjustments to their information as required.

  Background: The user is in the edit personal information option.
    Given Elvis Perform the introductory tutorial
    And he is logged in to the app by "phone number" with his "valid credentials"
    When he enters in the personal data option


  Scenario: Verify Edit button redirection
    Then Elvis should see his personal data registered

  Scenario: Verify functionality of the Edit button
    And he wants to edit his personal information
    Then he should see a Confirm Password modal


  Scenario: Verify Back button redirection
    And he wants to go back
    Then he should see the Profile screen


  Scenario: Verify functionality of Continue Button with incorrect password
    And he tries to confirm the password with a wrong password "BadPassword"
    Then he should see the error message "Contraseña incorrecta"


  Scenario: Verify functionality of Continue Button with valid password
    And he confirms his password
    Then he should see the personal information form in edit mode


  Scenario Outline: Validate the format of the Email field with <email>
    And he changes his email for "<email>"
    Then he should see the error message "<message>" at the email field
    Examples:
      | email          | message                     |
      | mail           | Formato de email incorrecto |
      | eperez@        | Formato de email incorrecto |
      | eperez@palo-it | Formato de email incorrecto |


  Scenario: Validate that emails already registered are not accepted
    And he edits his personal information
      | firstName | lastName        | email        |
      | Elvis     | Perez Gutierrez | mon@mail.com |
    Then he should see the following message This email already has an account

  @fix
  Scenario Outline: Validate <testCase>
    And he edits his personal information
      | firstName   | lastName   | email   |
      | <firstName> | <lastName> | <email> |
    And he saves changes
    Then he should see the following message: You have updated your data
    Examples:
      | firstName | lastName        | email              | testCase                                                             |
      | E         | Perez Gutierrez | eperez@palo-it.com | length of first name field with 1 character                          |
      | Elvis     | P               | eperez@palo-it.com | length of Last name field with 1 character                           |
      | Elvís     | Pérez Gutierrez | eperez@palo-it.com | that the First name and last name field accepts accented characters  |
      | Elvis     | Perez Gutierrez | eperez@palo-it.com | that when you press the Continue button the data is saved correctly. |

  Scenario: Verify CANCEL button functionality
    And he changes his personal information
      | firstName | lastName        | email              |
      | Elvis     | Perez Gutierrez | eperez@palo-it.com |
    And he wants to cancel editing his personal information
    Then he should see the Do you want to go out? modal

  Scenario: Verify functionality of the EXIT WITHOUT SAVING button
    And he changes his personal information
      | firstName | lastName        | email              |
      | Elvis     | Perez Gutierrez | eperez@palo-it.com |
    And he declines save changes
    Then he should see that there are not changes on his personal information

  Scenario: Validate profile image composition
    And he edits his personal information
      | firstName | lastName | email              |
      | Francis   | Drake    | eperez@palo-it.com |
    And he saves changes
    Then he should see the composite logo with the text "FD"

  Scenario: Verify the title change on the profile screen when changing the first and last name.
    And he edits his personal information
      | firstName | lastName | email              |
      | Francis   | Drake    | eperez@palo-it.com |
    And he saves changes
    And he returns to the profile screen
    And he should see the title "Francis Drake" at the Profile screen



