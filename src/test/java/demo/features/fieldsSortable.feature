Feature: verifying create user Navigation

  @sortable
  Scenario: user should click the Create User button and navigate to the Create Users page
    Given user navigates to the index page as "https://school-demo-web-app.azurewebsites.net/"
    When user clicks on usersLink as "Users"
    Then user is on users Page as "https://school-demo-web-app.azurewebsites.net/User" and title as "User page - SchoolDemo"
    When user clicks on First Name arrow button to view and verify the sorting order
    When user clicks on Last Name arrow button to view and verify the sorting order
    When user clicks on School Name arrow button to view and verify the sorting order
    When user clicks on Year Group arrow button to view and verify the sorting order
