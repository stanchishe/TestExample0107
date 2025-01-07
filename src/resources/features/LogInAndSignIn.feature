Feature: As a User of the practice.automationtesting.in page I would like to be able to register and login to the website.
  Scenario: Open the login page and fail to log in
    Given the browser is open on  the login page
    When user email "EmailSoVeryFake@gmail.com" with password "pass321" is used
    Then the log in fails
  Scenario: Open the login page and fail to sign in
