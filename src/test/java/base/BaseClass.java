package base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import util.PropertyFileOperations;
import util.ReportHelper;
import util.ScenarioContext;
import util.Utility;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * BaseClass initialises the framework. It mainly performs the following:
 * 1. Initialises the driver with the desired capabilities given in the "env.properties" file
 * 2. Setup framework properties such as - ImplicitWaitTimeOut, ExplicitWaitTimeOut
 * 3. Initialises the ReportHelper class, which is used for Test Reporting using ExtentReport
 * {@link ExtentReports}
 * {@link WebDriver}
 * {@link WebDriverWait}
 */
public class BaseClass {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    public static Utility utility;
    public static ScenarioContext scenarioContext;
    public static ExtentReports extentReports;
    public static ExtentSparkReporter extentSparkReporter;
    public static ExtentTest scenarioNode;
    public static ReportHelper reportHelper;
    private static int implicitWaitTimeOutInSeconds;

    private PropertyFileOperations propertyFileOperations;

    private DesiredCapabilities desiredCapabilities;


    /**
     * The constructor initialises the PropertyFileOperations object
     * @see PropertyFileOperations
     */
    public BaseClass() {
        propertyFileOperations = new PropertyFileOperations();
    }

    /**
     * Method initialize will be called before the Test Execution starts
     * @see listeners.MyListener#onTestStart(ITestResult)
     * @throws IOException
     */
    public void initialize() throws IOException {

        initializeDriver();
        setFrameworkProperties();

    }


    private void initializeDriver()  {

        String driverName = propertyFileOperations.getProperty("driver.name");

        if(driverName.equalsIgnoreCase("chromeDriver")){
            String driverPath = propertyFileOperations.getProperty("webdriver.chrome.driver");
            System.setProperty("webdriver.chrome.driver",driverPath);
            driver = new ChromeDriver();

        }
        driver.manage().window().maximize();
    }


    /**
     * Method setFrameworkProperties() configures the framework properties
     * such as implicitWait, explicitWait according to the information given in the "env.properties" file
     */
    private void setFrameworkProperties() {
        implicitWaitTimeOutInSeconds = Integer.parseInt(propertyFileOperations.getProperty("selenium.implicitWait.timeOutInSeconds"));
        driver.manage().timeouts().implicitlyWait(implicitWaitTimeOutInSeconds, TimeUnit.SECONDS);
        int explicitWaitTimeOutInSeconds = Integer.parseInt(propertyFileOperations.getProperty("selenium.explicitWait.timeOutInSeconds"));
        webDriverWait = new WebDriverWait(driver, explicitWaitTimeOutInSeconds);
        utility = new Utility();
        scenarioContext = new ScenarioContext();
        extentReports = new ExtentReports();

        scenarioContext.setContext("Home Page",propertyFileOperations.getProperty("homePage.URL"));
        scenarioContext.setContext("tourDataPath",System.getProperty("user.dir")+System.getProperty("file.separator")+propertyFileOperations.getProperty("tourDataPath"));


    }



    public void terminate() {

        driver.quit();
    }

    /**
     * Method to get the implicit wait timeout seconds
     * @return - int value which corresponds to the timeout in seconds
     */
    public int getImplicitWaitTimeOutInSeconds() {
        return implicitWaitTimeOutInSeconds;
    }


}
