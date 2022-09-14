package pageObjects;

import helper.action.Action;
import helper.assertion.VerificationHelper;
import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class EditUsersPage extends BasePage {
    public static Logger log = LoggerHelper.getLogger(EditUsersPage.class);
    // URL, LOGO, TEXTS//
    public final String URL = "https://automationteststore.com/index.php?rt=account/create";
    @FindBy(css = "[class='display-4']")
    public WebElement editUsersTxt;
    @FindBy(xpath = "main[role='main'] > a")
    public WebElement backBtn;
    @FindBy(css = "#User_FirstName")
    public WebElement editUserFirstName;
    @FindBy(css = "#User_LastName")
    public WebElement editUserLastName;
    @FindBy(xpath = "#User_UserSchools")
    public WebElement editSchoolUsers;
    @FindBy(css = "#User_UserTypeId")
    public WebElement editUserTypeId;
    @FindBy(css = "#User_YearGroupId")
    public WebElement editUserYearGroupId;
    @FindBy(css = "input[value='Save']")
    public WebElement editSaveBtn;
    Action act = new Action();
    String loginName = "covid19" + generateRandomString(5);

    public EditUsersPage() throws IOException {
        super();

    }

    public boolean validateEditUsersTxtIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(editUsersTxt);
    }

    public boolean validateBackBtnIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(backBtn);
    }

    public void getEditUserFirstName(String firstName) throws Exception {
        sendKeysToWebElement(editUserFirstName, firstName);
    }

    public void inputEditUserLastName(String lastName) throws Exception {
        sendKeysToWebElement(editUserLastName, lastName);
    }

    public void selectEditSchoolUsers(String arg0) {
        log.info("selecting school user....");
        WebElement ele = getDriver().findElement(By.xpath("//option[contains(text(),'" + arg0 + "')]"));
        ele.click();
    }

    public void selectEditUserTypeId(String arg0) {
        log.info("selecting user type Id....");
        WebElement ele = getDriver().findElement(By.xpath("//option[contains(text(),'" + arg0 + "')]"));
        ele.click();
    }

    public void selectEditUserYearGroupId(String arg0) {
        log.info("selecting user year group....");
        WebElement ele = getDriver().findElement(By.xpath("//option[contains(text(),'" + arg0 + "')]"));
        ele.click();
        //return editUserYearGroupId;
    }


}


