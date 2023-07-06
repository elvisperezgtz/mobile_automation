@regression  @profile

Feature: On boarding

  As a Spin pro user
  I want to be able to get onboard the app
  to start up my business

  Background: He is on the Enter your phone number screen
    Given Elvis Perform the introductory tutorial
    And he wants to start his on boarding

  Rule: Should accept terms and conditions before send a code request

    @onBoarding
    Scenario: Validate that the button Send Code is enabled when the phone number is valid and he accepts terms and conditions
      When he enter his phone number and accepts terms and conditions
      Then he should see the Send code button enabled
