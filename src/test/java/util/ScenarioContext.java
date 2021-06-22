package util;
import java.util.HashMap;
import java.util.Map;


/**
 * Class to store the intermediate values during execution, which can be shared and accessed across the methods for a particular Scenario
 */

public class ScenarioContext {

    private static Map<String, String> scenarioContext;

    public ScenarioContext(){
        scenarioContext = new HashMap<>();
    }

    /**
     * Method to set a context variable value
     * @param key
     * @param value
     */
    public void setContext(String key, String value) {
        scenarioContext.put(key.toString(), value);
    }

    /**
     * Method to get the value of a context variable
     * @param key
     * @return
     */
    public String getContext(String key){
        return scenarioContext.get(key.toString());
    }

    /**
     * Method to check whether a context variable is present
     * @param key
     * @return
     */
    public Boolean isContains(String key){
        return scenarioContext.containsKey(key.toString());
    }

}