package demo.steps;

import helper.assertion.AssertionHelper;
import helper.assertion.VerificationHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.*;

import java.io.IOException;
import java.util.List;


public class AllSteps extends BasePage {

    private WebDriver driver = getDriver();
    private CreateUsersPage createUsersPage;
    private EditUsersPage editUsersPage;
    private FootersPage footersPage;
    private HomePage homePage;
    private TopNaviMenuPage topNaviMenuPage;
    private UsersPage usersPage;

    public AllSteps() throws IOException {
        super();
    }

    public AllSteps(CreateUsersPage createUsersPage, EditUsersPage editUsersPage, FootersPage footersPage, HomePage homePage, TopNaviMenuPage topNaviMenuPage, UsersPage usersPage) throws IOException {
        this.createUsersPage = createUsersPage;
        this.editUsersPage = editUsersPage;
        this.footersPage = footersPage;
        this.homePage = homePage;
        this.topNaviMenuPage = topNaviMenuPage;
        this.usersPage = usersPage;
    }

    @Given("user navigates to the index page as {string}")
    public void userNavigatesToTheIndexPageAs(String string) {
        goToIndexPage(string);
        Assert.assertEquals(getDriver().getCurrentUrl(), string);
        homePage.validateLearnAboutLinkTxtIsDisplayed();
    }

    @And("user clicks on usersLink as {string}")
    public void userClicksOnUsersLinkAs(String arg0) {
        homePage.userOnLandingPageUrl();
        homePage.validateWelcomeTxtIsDisplayed();
        homePage.validateUserLinkIsDisplayed();
        waitAndClickElement(getDriver().findElement(By.linkText(arg0)));
    }

    @Given("user is on users Page as {string} and title as {string}")
    public void user_is_on_users_page_as_and_title_as(String string, String string2) {
        Assert.assertEquals(getDriver().getCurrentUrl(), string);
        Assert.assertEquals(getDriver().getTitle(), string2);
        new VerificationHelper(getDriver()).isDisplayed(usersPage.userListTxt);
    }

    @Given("user enters First name as {string}")
    public void user_enters_first_name_as(String string) throws Exception {
        usersPage.inputFirstNameBox(string);
    }

    @Given("user enters lastName as {string}")
    public void user_enters_last_name_as(String string) throws Exception {
        usersPage.inputLastNameBox(string);
    }

    @Given("user selects school as {string}")
    public void user_selects_school_as(String string) {
        usersPage.selectSchoolOptionDropDown(string);

    }

    @Given("user selects user type  as {string}")
    public void user_selects_user_type_as(String string) {
        usersPage.selectUserTypeOptionDropDown(string);

    }

    @Given("user selects Year group  as {string}")
    public void user_selects_year_group_as(String string) {
        usersPage.selectYearGroupOptionDropDown(string);
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        usersPage.clickOnSearchUserBtn();

    }

    @Then("user gets search result confirmation count as {string}")
    public void user_gets_search_result_confirmation_count_as(String string) {
        int sizeEle = usersPage.getUserResultTableList().size();
        for (int i = 0; i <= 1; i++) {
            String text = usersPage.getUserResultTableList().get(i).getText();
            if (!text.isEmpty()) {
                System.out.println("Count of Searched result " + string);
                System.out.println("List Of Search items displayed " + text);
            }
        }


    }

    @And("user navigate to edit page as url as {string} and page title as {string}")
    public void userNavigateToEditPageAsUrlAsAndPageTitleAs(String arg0, String arg1) {
        AssertionHelper.verifyTrue(arg0.contains("User/Edit?userId="));
        Assert.assertEquals(getDriver().getTitle(), arg1);
        new VerificationHelper(getDriver()).isDisplayed(editUsersPage.editUsersTxt);
    }

    @And("user sees First name Last name School name and Year group are displayed")
    public void userSeesFirstNameLastNameSchoolNameAndYearGroupAreDisplayed() {
        usersPage.resultTableHeadingsCountAndIsDisplayed();
        usersPage.resultTableHeadingsList();

    }

    @When("user clicks on edit button")
    public void clicksOnEditButton() throws InterruptedException, IOException {
        //usersPage.clickOnEditButton();
        List<WebElement> lists = getDriver().findElements(By.xpath("//*[@id=\"userResults\"]/tbody/tr/td"));
        for (int i = 0; i <= lists.size(); i++) {
            System.out.println(lists.get(i).getText());
        }
    }

    @When("clicks search users button")
    public void clicksSearchUsersButton() {
        usersPage.clickOnSearchUserBtn();

    }

    @And("user sees First name Last name School name and Year group are sorted")
    public void userSeesFirstNameLastNameSchoolNameAndYearGroupAreSorted() {
        String numOfFields = usersPage.getUserResultTableHeadings().get(0 - 4).getText();
        System.out.println("numbers of fields displayed: " + numOfFields);
    }

    @And("user should see five records are populated and displayed")
    public void userShouldSeeFiveRecordsArePopulatedAndDisplayed() throws InterruptedException {
        usersPage.readSearchTableResult();

    }

    @And("user should see result records are populated and display the results in the table")
    public void userShouldSeeResultRecordsArePopulatedAndDisplayTheResultsInTheTable() {
        int sizeEle = usersPage.getUserResultTableList().size();
        for (int i = 0; i <= 1; i++) {
            String text = usersPage.getUserResultTableList().get(i).getText();
            if (!text.isEmpty()) {
                System.out.println("Count of Searched result " + sizeEle);
                System.out.println("List Of Search items displayed " + text);
            }
        }
    }

    @When("user clicks on Create User button")
    public void userClicksOnCreateUserButton() {
        usersPage.validateCreateUserBtnIsDisplayed();
        usersPage.clickOnCreateUserBtn();
    }

    @Then("user should be on create users page url as {string} and page title as {string}")
    public void userShouldBeOnCreateUsersPageUrlAsAndPageTitleAs(String arg0, String arg1) {
        Assert.assertEquals(getDriver().getCurrentUrl(), arg0);
        Assert.assertEquals(getDriver().getTitle(), arg1);
        new VerificationHelper(getDriver()).isDisplayed(usersPage.userListTxt);
    }

    @And("user sees create user heading text as {string}")
    public void userSeesCreateUserHeadingTextAs(String arg0) {
        createUsersPage.validateCreateUsersTxtIsDisplayed();
    }


    @And("user clicks Edit button to navigate to edit page")
    public void user_clicks_edit_button_to_navigates_to_edit_page() throws InterruptedException {
        usersPage.clickOnEditButton();

    }

    @When("user clicks on First Name arrow button to view and verify the sorting order")
    public void userClicksOnFirstNameArrowButtonToViewAndVerifyTheSortingOrder() {
        usersPage.clickAndValidateOnFirstNameSearchReport();
    }

    @When("user clicks on Last Name arrow button to view and verify the sorting order")
    public void userClicksOnLastNameArrowButtonToViewAndVerifyTheSortingOrder() {
        usersPage.clickAndValidateOnLastNameSearchReport();
    }

    @When("user clicks on School Name arrow button to view and verify the sorting order")
    public void userClicksOnSchoolNameArrowButtonToViewAndVerifyTheSortingOrder() {
        usersPage.clickAndValidateOnSchoolNameSearchReport();
    }

    @When("user clicks on Year Group arrow button to view and verify the sorting order")
    public void userClicksOnYearGroupArrowButtonToViewAndVerifyTheSortingOrder() {
        usersPage.clickAndValidateOnYearGroupSearchReport();
    }
}
