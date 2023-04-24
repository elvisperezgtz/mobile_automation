@regression   @login

Feature: Login
  As a user
  I want a login module
  To access my Spin pro account

  Background: The user is at the home of the application.
    Given Elvis Perform the introductory tutorial

  Scenario: Validate Login with phone number
    When he logs in by "phone number" with his "valid credentials"
    Then he should see the message: Logging in

  Scenario: Verify error message when logging in with an unregistered phone
    When he logs in by "phone number" with his "wrong credentials"
    Then he should see the message: Wrong Data

  Scenario: Validate Login with email
    When he logs in by "email" with his "valid credentials"
    Then he should see the message: Logging in

  Scenario: Verify error message when logging in with an unregistered email
    When he logs in by "email" with his "wrong credentials"
    Then he should see the message: Wrong Data

  Scenario: Verify that the Password field is mandatory
    When he enters a empty password
    Then he should see the alert "Este campo es obligatorio"

  Scenario: Verify that the Email or Cell phone number field is mandatory
    When he enters a empty email or phone number
    Then he should see the alert "Este campo es obligatorio"

  Scenario:Verify Back button redirection
    When he wants to login
    And he wants to go back
    Then he should be able to see the Register in three steps screen

  Scenario:Verify redirection of Forgot Password button
    When he wants to recover his password
    Then he should see the Reset password screen