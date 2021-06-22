package util;

import base.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class ReportHelper contains methods for report generation.
 * It uses the ExtentReports class for building a custom Execution Report
 *
 */
public class ReportHelper extends BaseClass {

    /**
     * Method which updates the Test Log. When this method is called, it creates a new step in the report and writes the result accordingly
     * @param stepName - The current step name
     * @param message - The message or step description
     * @param status - either "Pass" or "Fail"
     * @param takeScreenshot - if true, the screenshot is appended with the report
     */
    public void updateTestLog(String stepName, String message, String status, boolean takeScreenshot)  {

        try {
            utility.waitFor(1);
            ExtentTest steps = scenarioNode.createNode(new GherkinKeyword("When"), "<b>Step: </b>" +stepName);
            if (status.equalsIgnoreCase("fail")) {


                String screenshot = getScreenshot(stepName);
                steps.fail("<b>Result: </b>" +message).fail(new Exception(message)).
                        fail(MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build()).fail("<i class='fa fa-frown-o' style='background-color:white;color:red'></i>");

                Assert.fail(message);
//                steps.fail(message).fail(new Exception(message)).addScreenCaptureFromPath(screenshot).fail("<i class='fa fa-frown-o' style='background-color:white;color:red'></i>");
            } else if (status.equalsIgnoreCase("pass")) {
                if (takeScreenshot) {
                    String screenshot = getScreenshot(stepName);
                    steps.pass("<b>Result: </b>" +message).
                            pass(MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build()).pass("<i class='fa fa-smile-o' style='background-color:white;color:Chartreuse'></i>");


//                    steps.pass(message).addScreenCaptureFromPath(screenshot).pass("<i class='fa fa-smile-o' style='background-color:white;color:Chartreuse'></i>");


                } else {
                    steps.pass("<b>Result: </b>" +message).pass("<i class='fa fa-smile-o' style='background-color:white;color:Chartreuse'></i>");

                }

                Assert.assertTrue(true,message);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Method to capture the screenshot and place it under src/test/reports/Screenshots.
     * It appends the current timestamp with the step name as the screenshot name
     * @param screenshotName -
     * @return - the complete path where the screenshot is stored - src/test/reports/Screenshots/{screenshotName>}
     * @throws Exception
     */
    private String getScreenshot(String screenshotName) throws Exception {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String fileSeparator = System.getProperty("file.separator");
        String destination = System.getProperty("user.dir") + fileSeparator + "src"  + fileSeparator + "test" + fileSeparator + "reports" +fileSeparator+ "Screenshots" +fileSeparator+  screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return "Screenshots" +fileSeparator+  screenshotName + dateName + ".png";
    }
}
