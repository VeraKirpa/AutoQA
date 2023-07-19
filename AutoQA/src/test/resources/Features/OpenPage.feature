@baseTest
Feature: OpenPage and click on home button

    Description: Ability to open page, click button and close browser after it


 #   Scenario: Website is opened user click button
 #    When webpage is opened
 #     Then click on home button

  Scenario: Automate 1
    When user open webpage
    And click radio button Radio1
    And type in text field "American Samoa"
    And click dropdown and select "option1"
    And get checkbox text
  #  Then close webpage

  Scenario: Automate 2
   When user open webpage
   And print out list
  Then close webpage


  Scenario: Automate 3
 #   When user open webpage
  #  And Get all prices into map where key is Course name and value is price
    And print out map
    Then close webpage

