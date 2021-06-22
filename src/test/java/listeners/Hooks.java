package listeners;

import base.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.ReportHelper;

/**
 * Hooks class is used to specify what needs to be performed
 * before the beginning of each cucumber scenario
 * @see @{@link Before}
 * @see @{@link After}
 */
public class Hooks extends BaseClass {


    /**
     * The initializeTest() method initialises and sets up
     * the TestReporting properties using ExtentReport before each Cucumber Scenario
     * {@link ExtentTest}
     * {@link ExtentSparkReporter}
     * {@link Scenario}
     * @param scenario
     */
    @Before
    public void initializeTest(Scenario scenario) {
        String scenarioName = scenario.getName();
        String fileSeparator = System.getProperty("file.separator");
        String fileName = System.getProperty("user.dir")+ fileSeparator + "src" + fileSeparator + "test" + fileSeparator + "reports" + fileSeparator + scenarioName+".html";
        extentSparkReporter = new ExtentSparkReporter(fileName);
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setDocumentTitle(scenario.getName());
        extentSparkReporter.config().setEncoding("uft-10");
        extentSparkReporter.config().setReportName(scenarioName);
        extentReports.attachReporter(extentSparkReporter);
        ExtentTest feature = extentReports.createTest(Feature.class,scenario.getName());
        scenarioNode = feature.createNode(com.aventstack.extentreports.gherkin.model.Scenario.class, scenario.getName());
        reportHelper = new ReportHelper();
    }

    /**
     * Method tearDown() prepares the report after each cucumber scenario
     */
    @After
    public void tearDown()
    {
        extentReports.flush();
        driver.quit();
    }


}
