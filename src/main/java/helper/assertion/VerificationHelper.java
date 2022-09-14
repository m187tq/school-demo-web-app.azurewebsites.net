package helper.assertion;

import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificationHelper {
    public static Logger log = LoggerHelper.getLogger(VerificationHelper.class);
    private WebDriver driver;

    public VerificationHelper(WebDriver driver) {
        this.driver = driver;
    }

    public static synchronized boolean verifyElementPresent(WebElement element) {
        boolean isDispalyed = false;
        try {
            isDispalyed = element.isDisplayed();
            log.info(element.getText() + " is dispalyed");
        } catch (Exception ex) {
            log.error("Element not found " + ex);
        }

        return isDispalyed;
    }

    public static synchronized boolean verifyElementNotPresent(WebElement element) {
        boolean isDispalyed = false;
        try {
            element.isDisplayed();
            log.info(element.getText() + " is displayed");
        } catch (Exception ex) {
            log.error("Element not found " + ex);
            isDispalyed = true;
        }

        return isDispalyed;
    }

    public static synchronized boolean verifyTextEquals(WebElement element, String expectedText) {
        boolean flag = false;
        try {
            String actualText = element.getText();
            if (actualText.equals(expectedText)) {
                log.info("actualText is :" + actualText + " expected text is: " + expectedText);
                return flag = true;
            } else {
                log.error("actualText is :" + actualText + " expected text is: " + expectedText);
                return flag;
            }
        } catch (Exception ex) {
            log.error("actualText is :" + element.getText() + " expected text is: " + expectedText);
            log.info("text not matching" + ex);
            return flag;
        }
    }

    public boolean isDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            log.info("element is Displayed.." + element.getText());
            return true;
        } catch (Exception e) {
            // log.error("element is not Displayed..", e.getCause());
            return false;
        }
    }

    public boolean isNotDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            log.info("element is present.." + element.getText());
            return false;
        } catch (Exception e) {
            log.error("element is not present..");
            return true;
        }
    }

    public String readValueFromElement(WebElement element) {
        if (null == element) {
            log.info("WebElement is null..");
            return null;
        }
        boolean status = isDisplayed(element);
        if (status) {
            log.info("element text is .." + element.getText());
            return element.getText();
        } else {
            return null;
        }
    }

    public String getText(WebElement element) {
        if (null == element) {
            log.info("WebElement is null..");
            return null;
        }
        boolean status = isDisplayed(element);
        if (status) {
            log.info("element text is .." + element.getText());
            return element.getText();
        } else {
            return null;
        }
    }

    public String getTitle() {
        log.info("page title is: " + driver.getTitle());
        return driver.getTitle();
    }


}
