@KOF @KOF_user_purchases @regression

Feature: KOF user permissions
  As a KOF delivery user
  I want the users to provide me with the Purchase Order from the application.
  To relate it to each purchase they make.
  Background: the KOF user accesses the Profile screen
    Given KOF_User Perform the introductory tutorial
    And he logs in as a kof user with credentials
    When he enter the purchase screen

  Scenario: Verify purchase order field for KOF users
    Then he should see the order field for KOF users
  Scenario: Verify character entry for purchase order field for KOF users
    And he enters an alphanumeric text in the purchase order field
    Then he verifies that the text has been inserted
  Scenario: Verify a purchase without the purchase order field
    And he makes a charge without entering a purchase order
    Then he displays the page looking for the device
