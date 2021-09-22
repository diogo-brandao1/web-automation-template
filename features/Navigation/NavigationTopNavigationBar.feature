Feature: Navigation - Top Navigation Bar
  As a Corporate User, I want to see my name in the top bar of the page so I know I am logged in.
  # https://ghib.atlassian.net/browse/GBB-28

  Background:
    Given I am logged in with credentials <Username> and <Password>
      |Username |Password |
      |user     |111111   |

  Scenario: GBB-28 - The menu collapses to the left
    Given the User is on the dashboard and sees the displayed data
    When he presses the hamburger menu
    Then the menu collapses to the left

  Scenario: GBB-28 - The menu expands to the right
    Given the User is on the dashboard and sees the displayed data
    When he presses the hamburger menu
    Then the menu expands to the right