package POM;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

/**
 * This class contains all the Elements and Methods which can be used for
 * various operations in the "Add Orders Page" of the application under test
 * @see base.BaseClass
 */
public class AddOrdersPage extends BaseClass {

    public AddOrdersPage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[text()='Add orders']")
    private WebElement addOrdersHeader;

    @FindBy(id = "button-orders-mode-Manual")
    private WebElement manualInputButton;

    @FindBy(id = "input-edit-order-name")
    private WebElement nameField;

    @FindBy(id = "input-edit-order-add")
    private WebElement addressField;

    @FindBy(id = "input-edit-order-phone")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//div[@id='input-edit-order-add-options']/child::div")
    private List<WebElement> addressAllOptions;

    @FindBy(id = "button-add-order-manual")
    private WebElement addToOrderButton;

    @FindBy(id = "button-orders-next")
    private WebElement planTourButton;

    /**
     * Method to check if the page is displayed
     * @return true/false according to visible/not visible
     */
    public boolean isDisplayed() {
        return manualInputButton.isDisplayed() && addOrdersHeader.isDisplayed();
    }


    /**
     * Method to select the Order Methos. The oder method can be one of the following
     * \n1. Manual
     * \n2. Import
     *
     * @param orderMethod
     */
    public void selectOrderMethod(String orderMethod) {
        if (orderMethod.equalsIgnoreCase("Manual")) {
            manualInputButton.click();
       }

    }


    /**
     * Method add the order details
     * @param name -
     * @param address
     * @param phone
     */
    public void addOrders(String name, String address, String phone)
    {

        nameField.sendKeys(name);
        addressField.sendKeys(address);
        utility.waitFor(1);
        if(utility.checkVisibility(addressAllOptions.get(0),2)){
            addressAllOptions.get(0).click();
            utility.waitFor(1);

        }

        phoneNumberField.sendKeys(phone);
        reportHelper.updateTestLog("Adding Orders", "Adding order details for : "+ name,"pass",true);
        addToOrderButton.click();

    }

    /**
     * Method to navigate to plan tour
     */
    public void planTour()
    {
        planTourButton.click();
    }

}
