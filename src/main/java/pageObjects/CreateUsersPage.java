package pageObjects;

import helper.action.Action;
import helper.assertion.VerificationHelper;
import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;


public class CreateUsersPage extends BasePage {
    public static Logger log = LoggerHelper.getLogger(CreateUsersPage.class);
    // URL, LOGO, TEXTS//
    public final String URL = "https://automationteststore.com/index.php?rt=account/create";
    @FindBy(css = "[class='display-4']")
    public WebElement createUsersTxt;
    @FindBy(xpath = "main[role='main'] > a")
    public WebElement backBtn;
    @FindBy(css = "#User_FirstName")
    public WebElement userFirstName;
    @FindBy(css = "#User_LastName")
    public WebElement userLastName;
    @FindBy(xpath = "#User_UserSchools")
    public WebElement schoolUsers;
    @FindBy(css = "#User_UserTypeId")
    public WebElement userTypeId;
    @FindBy(css = "#User_YearGroupId")
    public WebElement userYearGroupId;
    @FindBy(css = "input[value='Save']")
    public WebElement saveBtn;
    Action act = new Action();
    UsersPage usersPage = new UsersPage();
    String loginName = "covid19" + generateRandomString(5);
    String email = System.currentTimeMillis() + "Apr";

    public CreateUsersPage() throws IOException {
        super();

    }

    public boolean validateCreateUsersTxtIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(this.createUsersTxt);
        //return createUsersTxt;
    }

    public boolean getBackBtn() {
        return new VerificationHelper(getDriver()).isDisplayed(this.backBtn);
        //return backBtn;
    }

    public void clickOnBackBtn() {
        waitAndClickElement(backBtn);
        //return backBtn;
    }

    public void inputUserFirstName(String firstName) throws Exception {
        sendKeysToWebElement(userFirstName, firstName);
        //return userFirstName;
    }

    public void inputUserLastName(String lastName) throws Exception {
        sendKeysToWebElement(userLastName, lastName);
        //return userLastName;
    }

    public void selectSchoolUsers(String arg0) {
        log.info("selecting school user....");
        WebElement ele = getDriver().findElement(By.xpath("//option[contains(text(),'" + arg0 + "')]"));
        ele.click();
        //return schoolUsers;
    }

    public void selectUserTypeId(String arg0) {
        log.info("selecting user type Id....");
        WebElement ele = getDriver().findElement(By.xpath("//option[contains(text(),'" + arg0 + "')]"));
        ele.click();
        // return userTypeId;
    }

    public void selectUserYearGroupId(String arg0) {
        log.info("selecting user year group....");
        WebElement ele = getDriver().findElement(By.xpath("//option[contains(text(),'" + arg0 + "')]"));
        ele.click();
        //return userYearGroupId;
    }

    public UsersPage clickOnEditSaveBtn() throws IOException {
        waitAndClickElement(saveBtn);
        waitFor(usersPage.userListTxt);
        return new UsersPage();
    }

}


