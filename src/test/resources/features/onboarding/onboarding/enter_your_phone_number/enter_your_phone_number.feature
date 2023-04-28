@regression @registration
Feature: Enter your phone number
  As a Spin pro user
  I want a module to register my phone number
  In order to start my registration in the Spin pro system

  Background: The user is at the home of the application.
    Given Elvis Perform the introductory tutorial

  Scenario: Validate help from Enter your number screen
    When he accesses help
    Then he should see the screen: How to use my SPIN PRO charging device

  Scenario: Validate that the Send code button is enabled when accepting terms and conditions.
    When he tries to start his registration accepting terms and conditions
    Then he should see Send code button enabled

  Rule: The Send code button must be disabled until the terms and conditions are accepted.
    Scenario: Validate that the Send code button is disabled when not accepting terms and conditions.
      When he tries to start his registration without accepting terms and conditions
      Then he should see Send code button disabled

  Rule: It should not be allowed to start a new registration with a previously registered cell phone number.
    Scenario: Validate that it is not possible to register a number with existing registration.
      When he tries to start his registration with a phone number previously registered
      Then he should see the message: This number cannot be registered

    Scenario: The Type Code screen should be displayed when a valid phone number is registered.
      When he registers a valid phone number
      Then he should see the screen: Enter your code