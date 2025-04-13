@regression @booksearch
Feature: Searching for a book and printing its details in a file

  Scenario: Verify book search is successful and print Title, Author and Publisher into a text file
    Given the user goes to the URL "https://demoqa.com/login" and successfully logins with username "bala29" and password "Bala@12345"
    Then the "User Name : bala29" should be visible
    And the Log Out button should be visible
    When the user clicks on Book Store in the left menu
    And the user searches with book name "Learning JavaScript Design Patterns"
    Then the title "Learning JavaScript Design Patterns", Author "Addy Osmani" and Publisher "O'Reilly Media" should be displayed
    And these book details are printed in a text file
    When the user clicks on Log Out button
    Then the homepage should be displayed