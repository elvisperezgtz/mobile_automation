@regression  @onboarding

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

    Scenario: Verify that the Enter Your Code screen is displayed when a valid phone number is entered.
      When he enter his phone number and accepts terms and conditions
      And he wants a verification code
      Then he should see the Enter Your Code screen

    @onBoarding
    Scenario: Verify that the We want to meet you is displayed when a valid verification code is entered.
      And He enters and validates his phone number
      And he should see the Create your password screen

  Rule: You can only register the same phone number once.

    Rule: You can only register with creating a secure password
    Scenario: Validates that only a strong password allows you to continue with the registration.
      And he enters and validates his phone number
      And he enters and validates a secure password
      Then he should see the We want to meet you screen

  Rule: You should complete the required fields on the screen We want to meet you to finalize the On boarding.
    Scenario: Verify that satisfactory filling in the fields of We want to meet you allows to advance in the On boarding.
      When he enters and validates his phone number
      And he enters and validates a secure password
      And he enters and completes the form with his personal and business data
      Then he should see the Already have your device screen

  Rule: You should be displayed the Add bank account information when you skip the linking device process
    Scenario: Verify that the Do it later button skip the linking device processes
      When he enters and validates his phone number
      And he enters and validates a secure password
      And he enters and completes the form with his personal and business data
      And he wants to skip the linking device processes
      Then he should see the Add your bank account screen

      #TODO finish this Scenario
    Scenario: Validate that the Continue button is not enabled when a required data is not entered
      And he adds his bank account information

  Rule: You should be displayed the You are almost done screen when finish the on boarding process without linking device
    Scenario: Verify that the screen Your almost done appears when the on boarding process is complete without pairing the device
      When he starts his on boarding process with the required information skipping pairing device process
      Then he should see the You are almost done screen

  Rule: When finish the on boarding process you should be the Home screen
    Scenario: On boarding without paring device
      When he starts his on boarding process with the required information skipping pairing device process
      And he finish the on boarding process
      Then he should see the Home screen



