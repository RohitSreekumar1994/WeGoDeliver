package steps;
import POM.AddOrdersPage;
import base.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Map;

/**
 * This class contains the Step Definitions for all steps related to the AddOrders Page
 * @see BaseClass
 * @see AddOrdersPage
 */
public class AddOrdersSteps extends BaseClass {

    static AddOrdersPage addOrdersPage;

    @Then("the Add Orders page is opened")
    public void theAddOrdersPageIsOpened() {
        addOrdersPage = new AddOrdersPage();
        if(addOrdersPage.isDisplayed())
        {
            reportHelper.updateTestLog("Add Order Page","Add Order page is displayed", "pass", true);
        }
        else
        {
            reportHelper.updateTestLog("Add Order Page","Add Order page is not displayed", "fail", true);

        }
    }


    @When("user selects {string} add orders option")
    public void userSelectsAddOrdersOption(String orderType) {
        addOrdersPage = new AddOrdersPage();
        addOrdersPage.selectOrderMethod(orderType);


    }

    @And("adds orders with the below values")
    public void addsOrdersWithTheBelowValues(DataTable orderDetails) {
        addOrdersPage = new AddOrdersPage();
        Map<String, String> orderMap = orderDetails.asMap(String.class, String.class);
        for(int i =1;i<=(orderMap.size())/3;i++){
            String name = orderMap.get("Name"+i);
            String address = orderMap.get("Address"+i);
            String phone = orderMap.get("Phone"+i);
            addOrdersPage.addOrders(name,address,phone);

        }



    }

    @And("plans the order")
    public void plansTheOrder() {
        addOrdersPage = new AddOrdersPage();
        addOrdersPage.planTour();

    }


}
