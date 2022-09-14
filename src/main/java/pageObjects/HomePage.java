package pageObjects;

import helper.assertion.VerificationHelper;
import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;


public class HomePage extends BasePage {
    public static Logger log = LoggerHelper.getLogger(HomePage.class);
    public final String url = "https://automationteststore.com/";
    @FindBy(css = "[class='display-4']")
    public WebElement welcomeTxt;
    @FindBy(xpath = "//body/div[@class='container']/main[@role='main']//p")
    public WebElement learnAboutLinkTxt;
    @FindBy(linkText = "Users")
    public WebElement usersLinkTxt;
    TopNaviMenuPage topMenu = new TopNaviMenuPage();

    public HomePage() throws IOException {
        super();

    }

    public String getUrl() {
        return url;
    }


    public boolean isUserOnLandingPageTitle() {
        return getDriver().getTitle().contains("Home Page - SchoolDemo");

    }

    public boolean validateUserLinkIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(usersLinkTxt);

    }

    public boolean userOnLandingPageUrl() {
        log.info("The current URL was...");
        return getDriver().getCurrentUrl().contains("azurewebsites.net");

    }

    public void goToUrl(String url) throws InterruptedException {
        log.info("got current Page Url....: " + url);
        getDriver().get(url);
    }

    public String getCurrentPageUrl() throws InterruptedException {
        log.info("The current URL was: " + url);
        return getDriver().getCurrentUrl();
    }

    public String getCurrentPageTitle() {
        return getDriver().getTitle();
    }

    public boolean validateWelcomeTxtIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(welcomeTxt);
    }

    public boolean validateLearnAboutLinkTxtIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(learnAboutLinkTxt);
    }


}

