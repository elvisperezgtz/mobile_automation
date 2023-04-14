@regression @profile @editBusinessInfo
Feature: Edit business information

  As a Spin pro user
  I want a module to view and edit my business information.
  To keep this information up to date

  Background: The user is in the edit business information option.
    Given Elvis Perform the introductory tutorial
    And he is logged in to the app by "phone number" with his "valid credentials"
    When he enters in the Business data option

  Scenario: Verify Edit button redirection
    Then he should see his Business information registered

  Scenario: Verify functionality of the Edit button
    And he wants to edit his Business information
    Then he should see a Confirm Password modal

  Scenario: Verify Back button redirection
    And he wants to go back
    Then he should see the Profile screen

  Rule: The system must request password confirmation before enabling the fields for editing.
    Scenario: Verify functionality of Continue Button with incorrect password
      And he tries to confirm the password with a wrong password "BadPassword"
      Then he should see the error message "Contraseña incorrecta"

    Scenario: Verify functionality of Continue Button with valid password
      And he confirms his password
      Then he should see the business information form in edit mode

  Rule: The system must request a confirmation before saving the edited data
    Scenario Outline: Validate the length of your Business Name field with <testCase>
      And he changes his Business name for "<businessName>"
      And he saves changes
      Then he should see the following message: You have updated your data
      Examples:
        | businessName                        | testCase      |
        | Merchantasdfglkjhgasdflkjhgasdfglkj | 35 characters |
        | m                                   | 1 character   |
        | Merchant123456789123456789123456789 | numbers       |

    Scenario: Validate the length of your Postal code field with an empty postal code
      And he changes his postal code for ""
      And he tries to save the changes
      Then he should see the following message: You have updated your data

    Scenario: Validate the length of your Postal code field with a one digit postal code
      And he changes his postal code for "1"
      And he tries to save the changes
      Then he should see the following message: Wrong postal code

  Rule: The app should not admit zip codes that are not from Mexico.
    Scenario: Validate that the Zip Code field does not admit zip codes that are not from Mexico.
      And he changes his postal code for "50001"
      And he saves changes
      Then he should see the following message: Wrong postal code

    Scenario: Verify CANCEL button functionality
      And he edits his business information
        | businessName | businessActivity | postalCode |
        | Surtimax     | GASOLINERA       | 43401      |
      And he wants to cancel editing his personal information
      Then he should see the Do you want to go out? modal

    Scenario: Verify functionality of the EXIT WITHOUT SAVING button
      And he changes his business information
        | businessName | businessActivity | postalCode |
        | Surtimax     | GASOLINERA       | 43401      |
      And he declines save changes
      Then he should see that there are not changes on his business information

    Scenario: Verify that the information was updated
      And he changes his business information
        | businessName | businessActivity | postalCode |
        | Surtimax     | GASOLINERA       | 43401      |
      And he saves changes
      And he returns to the home screen
      Then he should see the title "Surtimax" at the Home screen

    Scenario: Validate that the title at home change when update the Business information
      And he changes his business information
        | businessName | businessActivity | postalCode |
        | Surtimax     | GASOLINERA       | 43401      |
      And he saves changes
      And he returns to the home screen
      Then he should see the title "Surtimax" at the Home screen




