@testAll
Feature: Dashboard - Summary of Loans Account
  As a user i want to be able to see the summary of Loans Account on the Dashboard

  Scenario: Load Dashboard - Summary of Loans Account
    Given i am in login page
    And i change the language to english
    And change language successfully
    Then i want to login with "thiago.oliveira" and "Password1*"
    And i logged in successfully
    Then i can click on a "loans" account
    And i am redirected to the transactions page