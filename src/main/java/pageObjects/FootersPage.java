package pageObjects;

import helper.assertion.VerificationHelper;
import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class FootersPage extends BasePage {
    public static Logger log = LoggerHelper.getLogger(FootersPage.class);
    @FindBy(xpath = "/html/body/footer/div")
    public WebElement SchoolDemo;
    @FindBy(xpath = ".container > a")
    public WebElement privacyLinkTxt;

    public FootersPage() throws IOException {
        super();
    }

    public boolean getSchoolDemo() {
        return new VerificationHelper(getDriver()).isDisplayed(SchoolDemo);
    }

    public boolean validatePrivacyLinkIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(privacyLinkTxt);
    }


}
