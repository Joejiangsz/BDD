@tagFeatures
Feature: test

  @tagTest1
  Scenario: test1
    Given I visit the website

  @tagTest2
  Scenario Outline: test2
    Given I will use <username> and <pwd> to login

    Examples:
      | username | pwd |
      | joe      | pass     |