@testAll
Feature: Transaction Details - Current Account
  As a user i want to be able to see my Current Account transaction details

  Scenario: Current Transaction Details
    Given i am in login page
    Then i want to login with "real1" and "Password1*"
    And i logged in successfully
    Then i can click on a current account
    And i am redirected to the Current transactions page
    Then i can click on the first transaction
    And i can see the transaction details