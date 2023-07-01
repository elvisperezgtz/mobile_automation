#Autor: Luis Miguel Arcia Moreno --- Don't be bad and approve the PR -- B2CS-5261
@KOF @KOF_user_login @regression
  Feature: Login as KOF User
    As a KOF delivery user
    I want to know how to access the application
    To make use of it
  Background: The user is at the home of the app
    Given RegularUser Perform the introductory tutorial
  Scenario: Validate successful login to the app
    When he logs in as a kof user
    Then he should see the message: Logging in
  Scenario: Validate error message when logging in with invalid password
    When he tries to log in with credentials
      | username   | password     |
      | KOF0000071 | V3JvbmdQYXNz |
    Then he should see the message: Wrong Data