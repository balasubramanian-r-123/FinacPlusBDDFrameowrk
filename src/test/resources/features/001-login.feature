@regression @login
Feature: Login to DemoQA application

  @valid-login-scenario
  Scenario: Verify Login is successful with valid credentials
    Given The User navigates to "https://demoqa.com/login"
    When The User enters valid username "bala29" and password "Bala@12345"
    And The user clicks on Login button
    Then the "User Name : bala29" should be visible
    And the Log Out button should be visible

  @invalid-login-Scenario
  Scenario: Verify Login is unsuccessful with invalid credentials
    Given The User navigates to "https://demoqa.com/login"
    When The User enters valid username "bala" and password "12345"
    And The user clicks on Login button
    Then the error message "Invalid username or password!" should be displayed