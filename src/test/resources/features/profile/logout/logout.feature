@regression @profile @logout
Feature: Logout

  As a Spin pro user
  I want a logout option
  To logout from the app

  Background: the user is on the Profile screen
    Given Elvis Perform the introductory tutorial
    And he is logged in to the app by "phone number" with his "valid credentials"
    And he enters in the Profile screen

  Scenario: Logout
    And he logout from the app
    Then he should see the login screen

  Scenario: Verify redirection of the Back button after logout
    And he logs out of the app and try to go back to the previous session.
    Then he should see the screen Register in three steps

  Scenario: Verify that the Logout button displays the You want to logout modal
    And he wants to close the active session
    Then he should see the Do you want to logout modal





