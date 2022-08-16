Feature: check car MOT history on dvla website

  Background: Dvla link
    Given open the website dvla
  @SmokeTest
 Scenario: Does given link is active
   When Check does the link open
   Then link is active

  @RegressionTest
  Scenario: when correct registration number is entered
    When enter the correct car registration number
    And confirm the input
    Then your car history is displayed
  @SmokeTest @RegressionTest
  Scenario: when wrong registration number is entered
    When enter the incorrect car registration number
    Then The entered registration number is wrong

