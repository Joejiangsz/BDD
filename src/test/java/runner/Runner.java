package runner;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features", // Path to the feature files
        glue = "steps",  // Path to step definition package
        plugin = {
                "pretty",  // Pretty print
                "html:target/cucumber-reports.html",  // HTML report
                "json:target/cucumber-reports/Cucumber.json" // JSON report
        },
        monochrome = true,  // Readable console output
        tags = "@tagFeatures"  // You can run tests with specific tags
)

public class Runner {

}
