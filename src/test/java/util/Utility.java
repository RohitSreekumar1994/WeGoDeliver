package util;
import base.BaseClass;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * This class contains common reusable methods which can be used across Scenarios
 */
public class Utility extends BaseClass {

    /**
     * Method to check visibility of a given element.
     * @param element
     * @return true/false based on visible/not visible
     */
    public boolean checkVisibility(WebElement element)
    {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }
        catch(TimeoutException e)
        {
            return false;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Method to check visibility of a given element.
     * @param element
     * @param timeOutInSeconds - Seconds to wait for the element to be present
     * @return true/false based on visible/not visible
     */

    public boolean checkVisibility(WebElement element, int timeOutInSeconds)
    {
        WebDriverWait webDriverWait;
        driver.manage().timeouts().implicitlyWait(timeOutInSeconds, TimeUnit.SECONDS);
        try {
            webDriverWait = new WebDriverWait(driver,timeOutInSeconds);
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }
        catch(StaleElementReferenceException s)
        {
            int retryCount=3;
            while(retryCount>0) {
                try {
                    element.getText();
                    driver.manage().timeouts().implicitlyWait(getImplicitWaitTimeOutInSeconds(), TimeUnit.SECONDS);
                    return true;
                } catch (StaleElementReferenceException e){

                    try{
                        Thread.sleep(500);
                    }
                    catch (InterruptedException ie)
                    {
                        ie.printStackTrace();
                    }
                    retryCount--;
                }
            }
            return false;
        }
        catch (TimeoutException t)
        {
            return false;
        }



        finally {
            driver.manage().timeouts().implicitlyWait(getImplicitWaitTimeOutInSeconds(), TimeUnit.SECONDS);
        }
    }


    /**
     * Method to pause the execution
     * @param time - time in seconds
     */
    public void waitFor(int time){

        try {
            Thread.sleep(time * 1000);
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }


    /**
     * Method to navigate back to the previous page
     */
    public void goBack()
    {
        driver.navigate().back();
    }




}
