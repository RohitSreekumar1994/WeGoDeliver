package POM;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TourDetails extends BaseClass {

    public TourDetails() {

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

}
