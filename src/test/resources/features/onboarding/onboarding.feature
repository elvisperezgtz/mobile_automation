@regression  @profile

Feature: On boarding

  As a Spin pro user
  I want to be able to get onboard the app
  to start up my business

  Background: He is on the Enter your phone number screen
    Given Elvis Perform the introductory tutorial
    And he wants to start his on boarding

  Rule: Should accept terms and conditions before send a code request


    Scenario: Validate that the button Send Code is enabled when the phone number is valid and he accepts terms and conditions
      When he enter his phone number and accepts terms and conditions
      Then he should see the Send code button enabled

    @onBoarding
    Scenario: Verify that the Enter Your Code screen is displayed when a valid phone number is entered.
      When he enter his phone number and accepts terms and conditions
      And he wants a verification code
      Then he should see the Enter Your Code screen

    Scenario: Verify that the We want to meet you is displayed when a valid verification code is entered.
      And He enters and validates his phone number
      Then he should see the Send code button enabled

  Rule: You can only register the same phone number once.
