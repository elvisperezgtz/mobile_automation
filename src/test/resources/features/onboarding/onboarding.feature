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
@test1234
  Rule: You should complete the required fields on the screen We want to meet you to finalize the On boarding.
    Scenario: Verify that satisfactory filling in the fields of We want to meet you allows to advance in the On boarding.
      When he enters and validates his phone number
      And he enters and validates a secure password
      And he enters and completes the form with his personal and business data
      Then he should see the Already have your device screen