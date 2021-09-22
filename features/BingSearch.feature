Feature: Bing
  As a user i want to be able to search on bing

  Scenario: Bring webpage
    Given the user is on the bing page
    When the user search for "bring global" page
    And click in "Bring Global – Inspired by people" searched item
    Then the user should be able to check if the text "Future creators" is present
    And check if page URL is correct