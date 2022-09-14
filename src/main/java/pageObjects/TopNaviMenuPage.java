package pageObjects;

import helper.assertion.VerificationHelper;
import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.utilities.datarepo;

import java.io.IOException;
import java.util.List;

public class TopNaviMenuPage extends BasePage {
    public static Logger log = LoggerHelper.getLogger(TopNaviMenuPage.class);
    public final String URL = datarepo.BASE_URL;
    CreateUsersPage createUsersPage = new CreateUsersPage();
    @FindBy(css = "a.navbar-brand")
    private WebElement logoImage;
    @FindBy(xpath = "a.nav-link.text-dark")
    private List<WebElement> menuList;
    @FindBy(xpath = "li:nth-of-type(1) > .nav-link.text-dark")
    private WebElement home;
    @FindBy(xpath = "li:nth-of-type(2) > .nav-link.text-dark")
    private WebElement privacy;
    @FindBy(css = "li:nth-of-type(3) > .nav-link.text-dark")
    private WebElement users;
    @FindBy(css = "[type='submit']")
    private WebElement welshBtn;

    public TopNaviMenuPage() throws IOException {
        super();
    }

    public void navigateToUrl(String string) {
        navigateToIndexPage(string);
        log.info("navigate To IndexPage...");
    }

    public boolean validateLogoImageIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(logoImage);
    }

    public List<WebElement> getMenuList() {
        return menuList;
    }

    public boolean validateHomeLinkIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(this.home);
    }

    public boolean validatePrivacyIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(this.privacy);
    }

    public boolean validateUsersLinkIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(this.users);
    }

    public void clickOnUsers() {
        waitAndClickElement(users);
    }

    public boolean validateWelshBtnIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(welshBtn);
    }

    public CreateUsersPage clickOnUsersBtn() throws IOException {
        log.info("Waited and clicked on the element: " + users.getText());
        waitForWebElementAndClick(users);
        waitFor(createUsersPage.createUsersTxt);
        log.info("Waited for element on CreateUsersPage");
        return new CreateUsersPage();
    }


}