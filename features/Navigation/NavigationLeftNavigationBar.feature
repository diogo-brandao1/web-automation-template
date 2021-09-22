Feature: Navigation - Left Navigation Bar
  As a User, I want to see my navigation bar on the left side of the screen so that I can easily access it and perform actions.
  # https://ghib.atlassian.net/browse/GBB-27

  Background:
    Given I am logged in with credentials <Username> and <Password>
      |Username |Password |
      |user     |111111   |


  Scenario: GBB-27 - Go to Accounts Page
    Given the user is on the "Dashboard" and sees the navigation bar on the left side of the screen
    When he selects "Accounts"
    Then the User is redirected to "Accounts Page" (dashboard)

  Scenario: GBB-27 - Go to Transactions Page
    Given the user is on the "Dashboard" and sees the navigation bar on the left side of the screen
    When he selects "Transactions"
    Then the User is redirected to "Transactions" page

  Scenario: GBB-27 - Go to Statements Page
    Given the user is on the "Dashboard" and sees the navigation bar on the left side of the screen
    When he selects "Statements"
    Then the User is redirected to "Statements" Page

  Scenario: GBB-27 - Go to Own Accounts Page
    Given the user is on the "Dashboard" and sees the navigation bar on the left side of the screen
    When he selects "Own Accounts"
    Then he is redirected to "Owns Accounts Transfers" page

  Scenario: GBB-27 - Go to Within GHIB Page
    Given the user is on the "Dashboard" and sees the navigation bar on the left side of the screen
    When he selects "Within GHIB"
    Then he is redirected to "Within GHIB/National Transfers" page

  Scenario: GBB-27 - Go to National (UK) Page
    Given the user is on the "Dashboard" and sees the navigation bar on the left side of the screen
    When he selects "National (UK)"
    Then he is redirected to "Within GHIB/National Transfers" page

  Scenario: GBB-27 - Go to International Page
    Given the user is on the "Dashboard" and sees the navigation bar on the left side of the screen
    When he selects "International"
    Then he is redirected to "International Transfers" page

  Scenario: GBB-27 - Go to Manage Payments Page
    Given the user is on the "Dashboard" and sees the navigation bar on the left side of the screen
    When he selects "Manage Payments"
    Then he is redirected to "Manage Payments" page

  Scenario: GBB-27 - Go to Batches Page
    Given the user is on the "Dashboard" and sees the navigation bar on the left side of the screen
    When he selects "Batches"
    Then the User is redirected to "Batches" page

  Scenario: GBB-27 - Go to Beneficiaries Page
    Given the user is on the "Dashboard" and sees the navigation bar on the left side of the screen
    When he selects "Beneficiaries"
    Then the User is redirected to "Beneficiaries List" page




