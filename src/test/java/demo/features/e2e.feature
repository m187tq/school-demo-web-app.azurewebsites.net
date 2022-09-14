Feature: verifying users, create and edit Page Functionality


  Background: common steps in scenarios
    Given user navigates to the index page as "https://school-demo-web-app.azurewebsites.net/"
    And user clicks on usersLink as "Users"
    And user is on users Page as "https://school-demo-web-app.azurewebsites.net/User" and title as "User page - SchoolDemo"

  @e2e_users
  Scenario Outline: users should be able to filter on the various input fields

    And user enters First name as "<firstName>"
    And user enters lastName as "<lastName>"
    And user selects school as "<schoolName>"
    And user selects user type  as "<user_type>"
    And user selects Year group  as "<year_group>"
    When user clicks on search button
    Then user gets search result confirmation count as "<searchValidationCount>"

    Examples:
      | firstName     | lastName          | schoolName  | user_type | year_group | searchValidationCount |
      | ****&&&&&&&&& | 2098390428******* | Test name   | Teacher   | Year 6     | 25                    |
      | :@            | @                 |             | Pupil     | Year 1     | 25                    |
      | 123           | 456               | Test name2  | Teacher   | Year 4     | 25                    |
      | Amir1 Updated | Shaw updated      | Test name 2 |           | Year 12    | 25                    |
      | Benedict      | Rangasamy         | Test name3  | Teacher   | Year 5     | 25                    |

  Scenario: The following will be displayed in the results table
    And user sees First name Last name School name and Year group are displayed

  Scenario: user should click edit button and navigate to the edit page
    And user clicks Edit button to navigate to edit page
    And user navigate to edit page as url as "https://school-demo-web-app.azurewebsites.net/User/Edit?userId=" and page title as "Edit user page - SchoolDemo"

  Scenario: user should see fields will be sortable
    When clicks search users button
    And user sees First name Last name School name and Year group are sorted

  Scenario: five records will be displayed per page search
    When clicks search users button
    And user should see five records are populated and displayed

  Scenario: user should be able to click the Search Users button to search and display the results in the table based on the filters
    When clicks search users button
    And user should see result records are populated and display the results in the table

  Scenario: user should be able click the Create User button and navigate to the Create Users page
    When user clicks on Create User button
    Then user should be on create users page url as "https://school-demo-web-app.azurewebsites.net/User/Create" and page title as "Create user page - SchoolDemo"
    And user sees create user heading text as "Create user"
