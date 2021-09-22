Feature: Navigation - Session Time Out
  As a Corporate User, I want to be informed that due to inactivity on the session will expire and I will be disconnected.
    # https://ghib.atlassian.net/browse/GBB-31

  Background:
    Given I am logged in with credentials <Username> and <Password>
      |Username |Password |
      |user     |111111   |


  Scenario: GBB-31 - See message when no interaction with the page
    Given The User is logged in to the GHIB Portal
    When he has not made any interaction with the page for ---
    Then A session timeout dialogue box appears
    And The following message is displayed: “Due to inactivity, your session will time out in ---- seconds.”

  Scenario: GBB-31 - Move the mouse and close the dialogue timeout box
    Given The session time out dialogue box is displayed
    When The User moves the mousse
    Then The dialogue box is closed
    And The User can continue to use the website.

  Scenario: GBB-31 - Logout when the timeout timer ends
    Given The session time out dialogue box is displayed
    When The timer gets to 00 seconds
    Then The User is logged out from the session
    And he is redirected to the Log In page

