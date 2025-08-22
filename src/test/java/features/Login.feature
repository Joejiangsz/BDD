Feature: test

  @loginTest
  Scenario Outline: Login to the application
    Given Go to Home Page <url> and click Login
    Given Login with <user> and <password>
    Given Click on Login Button

    Examples:
      | url                  | user       | password   |
      | https://ceshiren.com | joejiangsz | Joejiangsz |
