Feature: Navigation - Change Context
  As a Corporate User, I want to be able to select the context when I am inside the GHIB Portal so that I can easily see other accounts.
  # https://ghib.atlassian.net/browse/GBB-29

  Background:
    Given I am logged in with credentials "<Username>" and "<Password>"
      |Username |Password |
      |user     |111111   |


  Scenario: GBB-29 - Open the profile dropdown list
    Given the User is on the Dashboard
    When he presses on the profile dropdown list
    Then The dropdown list opens


  Scenario: GBB-29 - See the change context modal with the correct data
    Given the User is seeing the Context info button
    When he clicks on Change Context
    Then a modal is displayed with the following data:
      #  Text: “Select Context”
      #  Text: “You are logged in as: (username)”
      #  Search bar (if more than 5 SA)
      #  Label: Current Context
      #    Icon
      #    Service agreement Name
      #    Service Agreement description
      #    Number of entities
      #  Label: Switch to Context:
      #    List of available contexts (with the following information displayed to all service agrrements available):
      #    icon
      #    Service agreement Name
      #    Service Agreement description
      #    Number of Entities
      #  Cancel Button

  |username|Icon|Current Context - Service agreement Name|Current Context - Service Agreement description|Current Context - Number of entities|
    |Switch to Context -|



  Scenario: GBB-29 - ??????
  Given the User is on Change Context Modal
  When he selects another context
  Then the modal closes
  And a loading spinner is displayed while the information is loading
  And the page the user is on is updated with information from the selected context


  Scenario: GBB-29 - Autocomplete feature on search bar
  Given the User is on the Change Context Modal
  When he types the service agreement name into the search bar
  Then the corresponding service agreement name is displayed (autocomplete feature)


  Scenario: GBB-29 - ?????? - POSSO JUNTAR O SCENARIO DE CIMA COM ESTE ???
  Given the User is seeing the result of his search
  When he clicks over the desired Service Agreement
  Then the modal closes
  And a loading spinner is displayed while the information is loading
  And the page the user is on is updated with information from the selected context


  Scenario: GBB-29 - Close modal
  Given the User is on Change Context modal
  When he presses the Cancel Button
  Then the modal closes

