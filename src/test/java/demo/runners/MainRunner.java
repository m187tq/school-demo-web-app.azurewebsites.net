package demo.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        //features = {"src/test/java/com/features/"},
        //glue = {"com/steps"},
        features = {"src/test/java/demo/features/"},
        glue = {"demo/steps"},
        // tags = "@Login_Both",
        //tags = "@LoginValidCredentials",
        //tags = "@RegistrationFunctionality",
        tags = "@sortable",
        //tags = "@e2e",
        // tags = "@e2e_users",
        // tags = "@resultHeadings",
        //tags = "@EditBtn",
        monochrome = true,
        //Strict = true,
        //dryRun = false,

        //name = "Login",
        plugin = {"pretty",
                "html:target/cucumber",
                "json:target/cucumber.json",
                "html:target/cucumber-reports/cucumber-pretty",
                "rerun:target/cucumber-reports/rerun.txt"})

public class MainRunner extends AbstractTestNGCucumberTests {
  /*  // Parallel scenario execution //
     @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }*/
}
