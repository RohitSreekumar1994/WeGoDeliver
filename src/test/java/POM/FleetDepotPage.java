package POM;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;


/**
 * This class contains all the Elements and Methods which can be used for
 * various operations in the "Fleet Depot Page" of the application under test
 * @see base.BaseClass
 */
public class FleetDepotPage extends BaseClass {

    public FleetDepotPage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a/following-sibling::div[text()='HERE WeGo Deliver']")
    private WebElement mainPageHeader;

    @FindBy(xpath = "//div[text()='Skip']")
    private WebElement skipButton;

    @FindBy(id = "input-depot-loca")
    private WebElement depotField;

    @FindBy(id = "button-fleet-next")
    private WebElement nextButton;

    @FindBy(xpath = "//div[@id='input-depot-loca-options']/child::div")
    private List<WebElement> depotAllOptions;

    @FindBy(xpath = "//strong[text()='Accept cookies']")
    private WebElement acceptCookies;

    /**
     * Method to check if the page is displayed
     * @return true/false according to visible/not visible
     */
    public boolean isDisplayed()
    {
        return mainPageHeader.isDisplayed() && skipButton.isDisplayed();

    }

    /**
     * Method to Skip Tutorial
     */
    public void skipTutorial()
    {
        skipButton.click();
    }

    /**
     * Method to Accept Cookies
     */
    public void acceptCookies()
    {
        acceptCookies.click();
    }

    /**
     * Method to enter the Depot Name
     * @param depotName
     */
    public void enterDepotName(String depotName)
    {
        boolean flag = false;
        depotField.sendKeys(depotName);
        utility.waitFor(1);
        if(utility.checkVisibility(depotAllOptions.get(0),2)){
            flag = true;
            depotAllOptions.get(0).click();
            utility.waitFor(1);
        }

        if(flag){
            reportHelper.updateTestLog("Depot Name", "Depot Name added successfully","pass",true);
        }
        else{
            reportHelper.updateTestLog("Depot Name", "Unable to add Depot Name","fail",true);
        }

    }


    /**
     * Method to navigate to Add Orders Page
     */
    public void goToAddOrders()
    {
        nextButton.click();
    }


}
