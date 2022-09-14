package demo.AllyTests;

import com.deque.axe.AXE;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;

public class demoAllyTest {
    private static final URL scriptUrl = demoAllyTest.class.getResource("axe.min.js");
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test
    public void testAccessibility() {
        driver.get("https://school-demo-web-app.azurewebsites.net/User");
        JSONObject responseJson = new AXE.Builder(driver, scriptUrl).analyze();
        JSONArray violations = responseJson.getJSONArray("violations");

        if (violations.length() == 0) {
            System.out.println("No violations found......");
        } else {
            AXE.writeResults("testAccessibility", responseJson);
            Assert.assertTrue(false, AXE.report(violations));
        }

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
