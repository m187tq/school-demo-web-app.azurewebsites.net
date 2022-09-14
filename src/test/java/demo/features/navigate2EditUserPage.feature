Feature: verifying create user Navigation

  @EditBtn
  Scenario: user should click the Create User button and navigate to the Create Users page
    Given user navigates to the index page as "https://school-demo-web-app.azurewebsites.net/"
    When user clicks on usersLink as "Users"
    Then user is on users Page as "https://school-demo-web-app.azurewebsites.net/User" and title as "User page - SchoolDemo"
    When user clicks Edit button to navigate to edit page
    Then user navigate to edit page as url as "https://school-demo-web-app.azurewebsites.net/User/Edit?userId=" and page title as "Edit user page - SchoolDemo"


