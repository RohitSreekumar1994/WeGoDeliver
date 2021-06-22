package POM;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddOrders extends BaseClass {

    public AddOrders() {

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

    @FindBy(id = "//div[@id='input-edit-order-add-options']/child::div")
    private List<WebElement> addressAllOptions;

    @FindBy(id = "button-add-order-manual")
    private WebElement addToOrderButton;

    @FindBy(id = "button-orders-next")
    private WebElement planTourButton;





}
