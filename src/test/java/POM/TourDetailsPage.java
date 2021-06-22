package POM;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains all the Elements and Methods which can be used for
 * various operations in the "Tour Details Page" of the application under test
 * @see base.BaseClass
 */
public class TourDetailsPage extends BaseClass {

    public TourDetailsPage() {

        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//h1[text()='Tour details']")
    private WebElement tourDetailsHeader;

    @FindBy(id = "button-tour-details-csv")
    private WebElement downloadCSVButton;

    @FindBy(xpath = "//p[text()='Duration']/following-sibling::strong")
    private WebElement duration;

    @FindBy(xpath = "//p[text()='Orders']/following-sibling::strong")
    private WebElement orders;

    @FindBy(xpath = "//p[text()='Stops']/following-sibling::strong")
    private WebElement stops;

    /**
     * Method to check if the page is displayed
     * @return true/false according to visible/not visible
     */
    public boolean isDisplayed()
    {
        return tourDetailsHeader.isDisplayed() && downloadCSVButton.isDisplayed();
    }

}
