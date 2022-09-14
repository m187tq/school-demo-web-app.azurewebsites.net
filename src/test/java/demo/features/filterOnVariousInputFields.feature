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
