package POM;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FleetDepot extends BaseClass {

    public FleetDepot() {

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


    public boolean isDisplayed()
    {
        if(utility.checkVisibility(mainPageHeader,10))
        {
            return true;
        }
        else return false;
    }




}
