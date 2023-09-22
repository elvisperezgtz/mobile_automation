@regression @help @profile

Feature: Help module

  As a Spin pro user
  I want a help module
  For instructions on application functionality

  Background: the user is on the Profile screen
    Given Elvis Perform the introductory tutorial
    And he is logged in to the app by "phone number" with his "valid credentials"
    And he enters in the Profile screen

  @smoke
  Scenario: Validate that the Help option redirects to the FAQ's screen.
    When he enters to the Help module
    Then he should see the Frequently Asked Questions
