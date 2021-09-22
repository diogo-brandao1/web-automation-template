Feature: Navigation - Logout
  As a Corporate User, I want to log out of the platform so that I can securely terminate my session
  # https://ghib.atlassian.net/browse/GBB-30

  Background:
    Given I am logged in with credentials <Username> and <Password>
      |Username |Password |
      |user     |111111   |


  Scenario: GBB-30 - Go to Accounts Page - ????? isto ja exist no 29
  Given the User is on the Dashboard
  When he presses on the profile dropdown list
  Then The dropdown list opens


  Scenario: GBB-30 - The User logged out of the portal
  Given The User is seeing the Log Out button in the dropdown list
  When he clicks on it
  Then The User is logged out of the portal