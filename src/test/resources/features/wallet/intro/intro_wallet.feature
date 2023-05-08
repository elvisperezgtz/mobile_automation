Feature: Intro wallet
  As a new Spin pro user
  I want to have a clear and concise introduction to the Wallet functionality
  so I can understand how to use it and get the most out of it.

  Background: He is logged in
    Given Elvis Perform the introductory tutorial
    And he is logged in to the app by "phone number" with his "dev credentials"

  @introWallet
  Scenario: Validate functionality of intro to Wallet
    When he performs the Wallet intro
    Then he should see the app home


  Rule: The Wallet introduction should be displayed the first time the user logs into the application, even if the linking process has been interrupted.
    Scenario: Verify that the Wallet intro is shown when there is an onboarding process cut off after the We want to meet you screen.
    Scenario: Verify that it does not show the Wallet intro, when he completes the intro previously
