package steps;
import POM.FleetDepotPage;
import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

/**
 * This class contains the Step Definitions for all steps related to the Fleet Depot Page
 * @see BaseClass
 * @see FleetDepotPage
 */
public class FleetDepotSteps extends BaseClass {

    static FleetDepotPage fleetDepotPage;

    @When("user enters the depot name as {string}")
    public void userEntersTheDepotNameAs(String depotName) {
        fleetDepotPage = new FleetDepotPage();
        fleetDepotPage.enterDepotName(depotName);

    }

    @And("navigates to Add Orders Page")
    public void navigatesToAddOrdersPage() {
        fleetDepotPage = new FleetDepotPage();
        fleetDepotPage.goToAddOrders();

    }
}
