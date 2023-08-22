@regression  @onboarding @AddBankAccount

Feature: On boarding

  As a Spin pro user
  I want to be able to get onboard the app
  to start up my business

  Background: He is on the Enter your phone number screen
    Given Elvis Perform the introductory tutorial
    And he has the information for his registration
    And he wants to start his on boarding

  Rule: In order to begin your on boarding you have to press the Start my registration
    Scenario: Validation of the screen content Enter your number
      Then he should the Enter your phone number screen

    Scenario: The Back button should redirect to the Register in 3 steps screen.
      When he wants go back
      Then he should see the screen Register in three steps

    Scenario: The Help button should redirect to frequently asked questions.
      When  he accesses help
      Then  he should see the Frequently Asked Questions

    Scenario: The Close button should redirect you to the Enter your number screen with the information entered above.
      When he enter his phone number and accepts terms and conditions
      And he goes to the help screen and comes back
      Then he should the Enter your phone number screen with the same information

  Rule: You can only register your phone number once.
    Scenario:  Validate that a previously registered number cannot be registered.
      When he enter his phone number and accepts terms and conditions
      And he wants a verification code
      Then he should see the error message This number cannot be registered

  Rule: Should accept terms and conditions before send a code request
    Scenario: Validate that the button Send Code is enabled when the phone number is valid and he accepts terms and conditions
      When he enter his phone number and accepts terms and conditions
      Then he should see the Send code button enabled

    Scenario: Validation of the mandatory terms and conditions check
      When he enters his phone number, but decline to accept terms and conditions
      Then he should see the Send code button disable

    Scenario: Validate that the Phone number field is required
      When he does not enter his phone number, but accept terms and conditions
      Then he should see the Send code button disable

#      Enter your code

  Rule: You need a valid verification code before continue
    Scenario: Validate error message when entered a not valid code.
      When he enter his phone number and accepts terms and conditions
      And he enters a not valid verification code
      Then he should see the error message The code is incorrect

    Scenario: Verify that the Enter Your Code screen is displayed when a valid phone number is entered.
      When he enter his phone number and accepts terms and conditions
      And he wants a verification code
      Then he should see the Enter Your Code screen

    Scenario: Verify that the We want to meet you is displayed when a valid verification code is entered.
      And He enters and validates his phone number
      And he should see the Create your password screen

  #Create your password

  Rule: You can only register with creating a secure password

    Scenario: Verify that the Continue button remains disabled until a valid password is entered.
      When he enters and validates his phone number
      Then he should see the continue button disabled

    Scenario: Verify that the password is at least 8 characters long.
      When he enters and validates his phone number
      And he enters an unsecured password with 3 lowercase, 1 uppercase, 1 numbers and 0 special characters
      Then he should see the continue button disabled

    Scenario: Verify that the password contains at least one number.
      When he enters and validates his phone number
      And he enters an unsecured password with 4 lowercase, 4 uppercase, 0 numbers and 0 special characters
      Then he should see the continue button disabled

    Scenario: Verify that the password contains at least one capital letter.
      When he enters and validates his phone number
      And he enters an unsecured password with 4 lowercase, 0 uppercase, 4 numbers and 0 special characters
      Then he should see the continue button disabled

    Scenario: Verify that the password contains at least one lower case letter.
      When he enters and validates his phone number
      And he enters an unsecured password with 0 lowercase, 4 uppercase, 4 numbers and 0 special characters
      Then he should see the continue button disabled

    Scenario: Verify that the password is displayed when clicking on the View button.
      When he enters and validates his phone number
      And he enters an unsecured password with 4 lowercase, 2 uppercase, 0 numbers and 0 special characters
      Then he should see the unencrypted password

    Scenario: Verify that the password is hidden by clicking on the Hide button.
      When he enters and validates his phone number
      And he builds a password without visualizing it
      Then he should see the encrypted password

    Scenario: Validate that the Continue button should redirect to the We want to meet you screen, when we enter a valid password.
      And he enters and validates his phone number
      And he enters and validates a secure password
      Then he should see the We want to meet you screen

#We want to meet you

  Rule: You should complete the required fields on the screen We want to meet you to finalize the On boarding.

    Scenario: Verify that the Help button redirects to the Frequently Asked Questions screen.
      And he enters and validates his phone number
      And he enters and validates a secure password
      And he enters the FAQs screen
      Then he should see the FAQs screen

    Scenario: Verify that the close button takes us to the We want to meet you screen.
      And he enters and validates his phone number
      And he enters and validates a secure password
      And he enters the FAQs screen
      And he closes the FAQs screen
      Then he should see the We want to meet you screen

    Scenario: Validate that the Name field does not allow numbers.
      And he enters and validates his phone number
      And he enters and validates a secure password
      And he enters fills in the form with name field with numbers
      Then he should see the continue button disabled on the we want to meet you screen

    Scenario: Validate that the Name field supports special characters
      And he enters and validates his phone number
      And he enters and validates a secure password
      And he enters fills in the form with name field with special characters
      Then he should see the continue button disabled on the we want to meet you screen

    Scenario: Validate the obligatory nature of the Surname field.
      And he enters and validates his phone number
      And he enters and validates a secure password
      And he enters fills in the form with Surname field empty
      Then he should see the continue button disabled on the we want to meet you screen

    Scenario: Validate that the Surname field supports special characters.
      And he enters and validates his phone number
      And he enters and validates a secure password
      And he enters fills in the form with Surname field with special characters
      Then he should see the continue button disabled on the we want to meet you screen

    Scenario: Validate that the Surname field does not allow numbers.
      And he enters and validates his phone number
      And he enters and validates a secure password
      And he enters fills in the form with Surname field with numbers
      Then he should see the continue button disabled on the we want to meet you screen

    Scenario: Validate the Email field is mandatory
      And he enters and validates his phone number
      And he enters and validates a secure password
      And he enters fills in the form with Email field empty
      Then he should see the continue button disabled on the we want to meet you screen

    Scenario: Validate email format of the Email field
      And he enters and validates his phone number
      And he enters and validates a secure password
      And he enters fills in the form with Email field without valid formatting
      Then he should see the continue button disabled on the we want to meet you screen

    Scenario: Validate that emails already registered are not accepted.
      And he enters and validates his phone number
      And he enters and validates a secure password
      And he enters fills in the form with Email previously registered
      Then he should see the continue button disabled on the we want to meet you screen

    Scenario: Validate that your Business Name field is required.
      And he enters and validates his phone number
      And he enters and validates a secure password
      And he enters fills in the form with Business Name field empty
      Then he should see the continue button disabled on the we want to meet you screen

    Scenario: Validate the Activity field is mandatory
      And he enters and validates his phone number
      And he enters and validates a secure password
      And he enters fills in the form with Activity field empty
      Then he should see the continue button disabled on the we want to meet you screen

    Scenario: Validate that your Business Name field does not allow special characters.
      And he enters and validates his phone number
      And he enters and validates a secure password
      And he enters fills in the form with Business Name field with special characters
      Then he should see the continue button disabled on the we want to meet you screen

    Scenario: Validate the mandatory field Zip Code
      And he enters and validates his phone number
      And he enters and validates a secure password
      And he enters fills in the form with Zip Code field empty
      Then he should see the continue button disabled on the we want to meet you screen

    Scenario: Validate that the Zip Code field does not allow less than 5 numeric characters.
      And he enters and validates his phone number
      And he enters and validates a secure password
      And he enters fills in the form with Zip Code field with less than 5 characters
      Then he should see the continue button disabled on the we want to meet you screen

    Scenario: Validate that the Zip Code field does not admit zip codes that are not from Mexico.
      And he enters and validates his phone number
      And he enters and validates a secure password
      And he enters fills in the form with Zip Code field that are not from Mexico
      Then he should see the continue button disabled on the we want to meet you screen

    Scenario: Validate that the Continue button is enabled only when all data is correctly entered.
      And he enters and validates his phone number
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

    Scenario: Validate that the Continue button is not enabled when a required data is not entered
      When he enters and validates his phone number
      And he enters and validates a secure password
      And he enters and completes the form with his personal and business data
      And he wants to skip the linking device processes
      Then he should see the Continue button disabled

  Rule: You should be displayed the You are almost done screen when finish the on boarding process without linking device
    Scenario: Verify that the screen Your almost done appears when the on boarding process is complete without pairing the device
      When he starts his on boarding process with the required information skipping pairing device process
      Then he should see the You are almost done screen

  Rule: When finish the on boarding process you should be the Home screen
    Scenario: On boarding without paring device
      When he starts his on boarding process with the required information skipping pairing device process
      And he finish the on boarding process
      Then he should see the Home screen

    @hookEnableWifi
    Rule: You have to have internet connection  to save the bank account information
    Scenario: Verify modal No internet connection
      When he enters and validates his phone number
      And he enters and validates a secure password
      And he enters and completes the form with his personal and business data
      And he wants to skip the linking device processes
      When he adds his bank account information but lost the internet connection before saving
      Then  he should see the modal No internet connection




