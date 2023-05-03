Feature: Intro wallet
  As a wallet user
  I want a tutorial
  To learn about how to use the app

  Background: He is logged in
    Given Elvis Perform the introductory tutorial
    And he is logged in to the app by "phone number" with his "dev credentials"

  @introWallet
  Scenario: Validate Wallet intro
    When he performs the Wallet intro
    Then  he should see the app home

  Scenario: Verify the operation of the Continue button within the INTRO to WALLET

  Scenario: Verify that the onboarding process is complete before entering the password.

  Scenario: Verify resumption of onboarding cut off, on the We want to meet you screen

  Scenario: Verify resumption of the cut onboarding, before entering the password.

  Scenario: Verify onboarding process cut off, after entering the password.

  Scenario: Verify resumption of the onboarding process, after entering the password.