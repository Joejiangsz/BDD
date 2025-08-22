package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features", // Path to the feature files
        glue = "steps",  // Path to step definition package
        plugin = {
                "pretty",  // Pretty print
                "html:target/cucumber-reports.html",  // HTML report
                "json:target/cucumber-reports/Cucumber.json" // JSON report
        },
        monochrome = true,  // Readable console output
        tags = "@loginTest"  // You can run tests with specific tags
)

public class TestNGRunner extends AbstractTestNGCucumberTests {


}
