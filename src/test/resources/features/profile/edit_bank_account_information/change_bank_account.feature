@regression


Feature: Edit Bank account information

  As a Spin Pro user
  I want to update my CLABE account no more than 3 times per month and not to allow me to update it more than these
  To protect it from possible fraud.

  Background: He is on the home with a new account
    Given Elvis has a new account

  @editClabe
  Scenario: Validate that the clabe account cannot be updated more than 3 times per month.
    When he edits his bank account information three times
      | joe doe | 123456789123456701 |
      | joe doe | 123456789123456702 |
      | joe doe | 123456789123456703 |

#    And he wants  edit his bank account once again
#      | joe doe | 123456789123456703 |
#    Then he should see the form disabled for editing
    And he should see the message The edition is not available
