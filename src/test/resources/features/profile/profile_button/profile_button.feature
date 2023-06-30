@regression @profileButton

Feature: Profile button
  As a shopkeeper user
  I want the application to do an identity validation every time I need to edit information
  To generate confidence in the user when modifying his account information

  Background: the user accesses the Profile screen
    Given Elvis Perform the introductory tutorial
    And he logs in by "phone number"
    When he enters in the Profile screen

  Scenario: Verify functionality of the Profile button
    Then he should see the Profile screen
  Scenario: Display phone number in the profile screen
    Then he should be able to see your registered phone number

