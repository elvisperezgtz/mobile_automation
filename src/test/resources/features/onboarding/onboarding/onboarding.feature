Feature: Onboarding

  As a Spin pro user
  I want a way to sign up into the application
  In order to create my account into Spin pro app

  Background: The user is at the home of the application.
    Given Elvis Perform the introductory tutorial


  Scenario: Registration without device linking
    When he starts his registration
      | phoneNumber | nip  | password   |
      | 5521996723  | 1234 | Prueba1234 |
    And he fills in the We want to meet you form
    And he does not link the device or bank details
    Then he should see the home page of the app


