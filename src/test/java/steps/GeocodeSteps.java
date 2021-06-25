package steps;
import base.BaseClass;
import com.intuit.karate.http.Response;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import com.intuit.karate.*;
import io.cucumber.java.en.Then;
import java.util.Map;

public class GeocodeSteps extends BaseClass {

    static Response response;

    @Given("user sends a request with the below details")
    public void userSendsARequestWithTheBelowDetails(DataTable dataTable) {

        try {
            Map<String, String> apiDetailsMap = dataTable.asMap(String.class, String.class);
            String endPoint = apiDetailsMap.get("endPoint");
            endPoint = endPoint + "?qq=";
            for (Map.Entry<String, String> map : apiDetailsMap.entrySet()) {

                String key = map.getKey();
                if (key.equalsIgnoreCase("endPoint")) continue;
                String value = map.getValue();
                String param = key + "=" + value + ";";
                endPoint = endPoint + param;
            }
            endPoint = endPoint.substring(0, endPoint.length() - 1);
            String apiKey = scenarioContext.getContext("apiKey");
            endPoint = endPoint + "&apiKey=" + apiKey;
            response = Http.to(endPoint).get();
            reportHelper.updateTestLog("Request Sent","Request sent successfully\n" + response.json().toString(),"pass",false);
        }
        catch(Exception e)
        {
            reportHelper.updateTestLog("Unable to send the request",e.getMessage(),"fail",false);
        }
    }

    @Then("the response code returned is {string}")
    public void theResponseCodeReturnedIs(String expectedResponseCode) {

        int actualResponseCode = response.getStatus();
        if(actualResponseCode == Integer.parseInt(expectedResponseCode)){
            reportHelper.updateTestLog("Response Code","Response Code 200 received","pass",false);
        }
        else
        {
            reportHelper.updateTestLog("Response Code","Response Code 200 is not received, instead "+ actualResponseCode+" is received","false",false);
        }


    }

    @And("the position coordinates returned are")
    public void theCoordinatesReturnedAre(DataTable dataTable) {
        Map<String,String> map = dataTable.asMap(String.class,String.class);
        double expectedLat = Double.parseDouble(map.get("lat"));
        double expectedLng = Double.parseDouble(map.get("lng"));
        double actualLat = response.json().get("items[0].position.lat");
        double actualLng = response.json().get("items[0].position.lng");

        if(actualLat==expectedLat){
            reportHelper.updateTestLog("Lat","Lat value is as expected; lat:"+actualLat,"pass",false);

        }
        else {
            reportHelper.updateTestLog("Lat", "Lat value is not as expected; actualLat:" + actualLat+" Expected Lat:"+expectedLat,"fail", false);
        }


        if(actualLng==expectedLng){
            reportHelper.updateTestLog("Lng","Lng value is as expected; lng:"+actualLng,"pass",false);

        }
        else {
            reportHelper.updateTestLog("Lng", "Lng value is not as expected; actualLng:" + actualLng+" Expected Lng:"+expectedLng,"fail", false);
        }

    }
}
