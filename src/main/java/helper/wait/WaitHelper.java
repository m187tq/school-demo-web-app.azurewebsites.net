package helper.wait;

import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.utilities.datarepo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitHelper {

    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(WaitHelper.class);

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This is ImplicitWait method
     *
     * @param timeout
     * @param unit
     */
    public void setImplicitWait(long timeout, TimeUnit unit) {
        log.info("Implicit Wait has been set to: " + timeout);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(datarepo.SIXTY_SECONDS));
    }

    /**
     * This will help us to get WebDriverWait object
     *
     * @param timeOutInSeconds
     * @param pollingEveryInMiliSec
     * @return
     */
    private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(datarepo.SIXTY_SECONDS));
        wait.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(ElementNotVisibleException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchFrameException.class);
        return wait;
    }

    /**
     * This method will make sure element is visible
     *
     * @param element
     * @param timeOutInSeconds
     * @param pollingEveryInMiliSec
     */
    public void WaitForElementVisibleWithPollingTime(WebElement element, int timeOutInSeconds,
                                                     int pollingEveryInMiliSec) {
        log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
        WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("element is visible now");
    }

    /**
     * This method will make sure elementToBeClickable
     *
     * @param element
     * @param timeOutInSeconds
     */
    public void WaitForElementClickable(WebElement element, int timeOutInSeconds) {
        log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(datarepo.SIXTY_SECONDS));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        log.info("element is clickable now");
    }

    /**
     * This method will make sure invisibilityOf element
     *
     * @param element
     * @param timeOutInSeconds
     * @return
     */
    public boolean waitForElementNotPresent(WebElement element, long timeOutInSeconds) {
        log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(datarepo.SIXTY_SECONDS));
        boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
        log.info("element is invisibile now");
        return status;
    }

    /**
     * This method will wait for frameToBeAvailableAndSwitchToIt
     *
     * @param element
     * @param timeOutInSeconds
     */
    public void waitForframeToBeAvailableAndSwitchToIt(WebElement element, long timeOutInSeconds) {
        log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(datarepo.SIXTY_SECONDS));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        log.info("frame is available and switched");
    }

    /**
     * This method will give is fluentWait object
     *
     * @param timeOutInSeconds
     * @param pollingEveryInMiliSec
     * @return
     */
    private Wait<WebDriver> getfluentWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
        Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeOutInSeconds))
                .pollingEvery(Duration.ofMillis(pollingEveryInMiliSec)).ignoring(NoSuchElementException.class);
        return fWait;
    }

    /**
     * @param element
     * @param timeOutInSeconds
     */
    public WebElement waitForElement(WebElement element, int timeOutInSeconds) {
        Wait<WebDriver> fwait = getfluentWait(timeOutInSeconds, 250);
        fwait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void pageLoadTime(long timeout, TimeUnit unit) {
        log.info("waiting for page to load for : " + unit + " seconds");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(datarepo.SIXTY_SECONDS));
        log.info("page is loaded");
    }

}
