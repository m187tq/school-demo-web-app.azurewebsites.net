Feature: verifying create user Navigation

  Scenario: user should click the Create User button and navigate to the Create Users page
    Given user navigates to the index page as "https://school-demo-web-app.azurewebsites.net/"
    And user clicks on usersLink as "Users"
    And user is on users Page as "https://school-demo-web-app.azurewebsites.net/User" and title as "User page - SchoolDemo"
    When user clicks on Create User button
    Then user should be on create users page url as "https://school-demo-web-app.azurewebsites.net/User/Create" and page title as "Create user page - SchoolDemo"
    And user sees create user heading text as "Create user"

