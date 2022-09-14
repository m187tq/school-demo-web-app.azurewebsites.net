Feature: verifying records displayed in search result page

  Scenario: five records will be displayed per page search
    Given user navigates to the index page as "https://school-demo-web-app.azurewebsites.net/"
    And user clicks on usersLink as "Users"
    And user is on users Page as "https://school-demo-web-app.azurewebsites.net/User" and title as "User page - SchoolDemo"
    And user should see five records are populated and displayed

