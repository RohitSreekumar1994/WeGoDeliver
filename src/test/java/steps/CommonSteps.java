package steps;

import POM.AddOrdersPage;
import POM.FleetDepotPage;
import POM.TourDetailsPage;
import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonSteps extends BaseClass {

    static AddOrdersPage addOrdersPage;
    static FleetDepotPage fleetDepotPage;
    static TourDetailsPage tourDetailsPage;


    @Given("^the user is navigated to the webpage$")
    public void navigateToWebsite(){

        String URL = scenarioContext.getContext("Home Page");
        driver.get(URL);

        fleetDepotPage = new FleetDepotPage();


        if(fleetDepotPage.isDisplayed())
        {
            fleetDepotPage.skipTutorial();
            fleetDepotPage.acceptCookies();
            reportHelper.updateTestLog("Home Page","User navigated to Home Page successfully", "pass", true);
        }
        else{
            reportHelper.updateTestLog("Home Page","User is not navigated to Home Page", "fail", true);
        }


    }



}
