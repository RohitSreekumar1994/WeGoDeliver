package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
/**
 * Runner class for the Scenario : Create Order Test
 *
 */
@CucumberOptions(features = {"src/test/java/features"} , plugin = {"json:target/cucumber.json", "pretty"},
        glue = {"steps","listeners"}, tags = "@CreateOrderManual")

public class CreateOrderRunner extends AbstractTestNGCucumberTests {

}
