@regression  @hookBankAccountInfo

Feature: Edit Bank account information
  As a Spin pro user
  I want a module to change my bank account information
  to keep up to date this information

  Background: The user is in the edit personal information option.
    Given Elvis Perform the introductory tutorial
    And he logs in by "phone number"
    When he enters in the bank account information option

  Scenario: Verify Edit button redirection
    Then Elvis should see his Bank account information registered

  Scenario: Verify functionality of the Edit button
    And he wants to edit his information
    Then he should see a Confirm Password modal

  Scenario: Verify functionality of Continue Button with incorrect password
    And he tries to confirm the password with a wrong password "BadPassword"
    Then he should see the error message "Contraseña incorrecta"

  Scenario: Verify functionality of Continue Button with valid password
    And he confirms his password
    Then he should see the bank account information form in edit mode

  Rule: The interbank CLABE must be 18 digits

    Scenario: Validate length of interbank CLABE field with less than 18 digits
      And he edits his interbank CLABE information with "12345678912345678"
      And he tries to save the changes
      Then he should see the message The CLABE must have 18 digits

    Scenario: Validate mandatory of the field Account Holder
      And he edits his interbank CLABE information with ""
      And he tries to save the changes
      Then he should see the alert This field is required

    Scenario:  Validate mandatory of the field CLABE
      And he edits the CLABE field with ""
      And he tries to save the changes
      Then he should see the alert This field is required

    Scenario: Verify CANCEL button functionality
      And he changes his bank account information
        | clabe              | accountHolder         |
        | 123456789123456789 | Elvis Perez Gutierrez |
      And he wants to cancel editing his personal information
      Then he should see the Do you want to go out? modal

    Scenario: Verify functionality of the EXIT WITHOUT SAVING button
      And he changes his bank account information
        | clabe              | accountHolder         |
        | 123456789123456789 | Elvis Perez Gutierrez |
      And he declines save changes
      Then he should see that there are not changes on his bank account information

    Scenario: Verify saved change when editing bank account information
      And he changes his bank account information
        | clabe              | accountHolder         |
        | 123456789123456789 | Elvis Perez Gutierrez |
      And he saves changes
      Then he should see the following message: You have updated your data
      And he should see the bank account information updated
        | clabe              | accountHolder         |
        | 123456789123456789 | Elvis Perez Gutierrez |

    @editBankAccount
  Rule: In order to update your interbank Information, you have to change  the field Interbank Clabe

    Scenario:Validate that when changing the Account Holder without changing the interbank CLABE the changes do not apply.
      And he changes his account holder name for "John Doe"
      Then he should see that there are not changes on his bank account information

    Scenario: Validate that it is allowed to modify the Interbank Clabe without modifying the name
      And he changes his interbank Clabe for "123456789123456999"
      Then he should see that the changes on the interbank CLABE were applied

    Scenario: Validate that the changes are correctly applied when both the holder and the interbank account are modified.
      And he changes the account holder for "John Doe" and the interbank CLABE for "123456789123456999"
      Then he should see that the changes were applied

    Scenario: Validate that the save confirmation modal is not displayed when the information is not modified.
      And he does not make any changes on his bank account information
      Then he should see that there are not changes on his bank account information

#    @noRun
#    Scenario: Validate that the save button is not enabled when no data is modified.
#      Then he should see the Save button disabled
#
#    @noRun @unimplemented
#    Scenario: Validate that the Save button is disabled when confirm the password
#      And he confirms his password
#      Then he should see the bank account information form in edit mode
#      And he should see the Save button disabled

    Scenario: Validate that the save confirmation modal is not displayed when the information entered is the same as before.
      And he enters the same bank account information
      Then he should see that the save confirmation modal is not displayed



