package steps;
import POM.TourDetailsPage;
import base.BaseClass;
import io.cucumber.java.en.Then;

/**
 * This class contains the Step Definitions for all steps related to the  Tour Details Page
 * @see BaseClass
 * @see TourDetailsPage
 */
public class TourDetailsSteps extends BaseClass {

    static TourDetailsPage tourDetailsPage;

    @Then("the tour details are available")
    public void theTourDetailsAreAvailable() {
        tourDetailsPage = new TourDetailsPage();
        if(tourDetailsPage.isDisplayed()){
            reportHelper.updateTestLog("Tour Details Page", "Tour Details page is opened", "pass", true);
        }
        else{
            reportHelper.updateTestLog("Tour Details Page", "Tour Details page is not opened", "fail", true);
        }
    }


}
