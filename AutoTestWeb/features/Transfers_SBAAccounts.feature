@testAll
Feature: Transfer - SBA Accounts
  As a user i want to be able to do transfers for another SBA account

  Scenario: Transfer Savings account to Jane Doe contact
    Given i am in login page
    Then i want to login with "real1" and "Password1*"
    And i logged in successfully
    Then i can click on new transfer on the quick action button
    And i am redirected to the new transfer page
    Then i select a savings account on the from selector
    And i select Jane Doe on the to selector
    And i insert "73" on the amount input
    Then i click on next button
    And i am redirected to the review page
#  Next 4 lines are implemented, but commented because of the duplicated transfer error
#    Then i click on the authorize button
#    And i fill the OTP modal
#    Then click on the transfer button
#    And transfers was successfully made

  Scenario: Transfer Savings account to wrong BBAN
    Given i am in login page
    Then i want to login with "real1" and "Password1*"
    And i logged in successfully
    Then i can click on new transfer on the quick action button
    And i am redirected to the new transfer page
    Then i select a savings account on the from selector
    And i insert a recipients name "abc"
    Then i insert a wrong BBAN "5555555555"
    And i insert "73" on the amount input
    Then i click on next button
    And i am redirected to the review page
    And a error message appears