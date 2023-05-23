#Autor: Luis Miguel Arcia Moreno --- Don't be bad and approve the PR -- B2CS-5262/5229/5231/5216/5212
@KOF @KOF_user_permissions @regression

  Feature: KOF user permissions
    As a KOF delivery user
    I want to access only to the functions delimited by my profile
    To avoid modifying and viewing sensitive Business information
  Background: the KOF user accesses the Profile screen
    Given RegularUser Perform the introductory tutorial
      And he logs in by "KOF ID" with his "Valid KOF credentials"
      And he enters in the Profile screen
    @KOFProfile
    Scenario: Verify personal information from the profile screen
      Then he should see the personal data of the KOF profile correctly
    Scenario: Verify the impossibility to change the personal data of the account KOF
      Then he should not be able to edit personal data
    Scenario: Verify that the KOF user does not have access to business data
      Then he should not be able to access the business data
    Scenario: Verify the denial of the interbank password query
      Then he should not be able to access the CLABE button

