@testAll @ARD-11460
Feature: Business Login Language Switcher
  As a user i want to be able to change language in the business login

  Scenario: Change Language Business
    Given i am in the business login page
    Then want to change language
    And change language successfully