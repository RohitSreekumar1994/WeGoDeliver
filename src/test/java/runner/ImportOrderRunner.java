package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Runner class for the Scenario : Create Order - Import CSV
 *
 */
@CucumberOptions(features = {"src/test/java/features"} , plugin = {"json:target/cucumber.json", "pretty"},
        glue = {"steps","listeners"}, tags = "@CreateOrderImport")

public class ImportOrderRunner extends AbstractTestNGCucumberTests {

}
