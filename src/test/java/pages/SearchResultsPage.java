package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage {

    public SearchResultsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "[id='results-section']>div")
    public List<WebElement> resultTiles; // 25

    @FindBy (css = "[data-test='BaseFavoriteVehicle']")
    public List<WebElement> favoriteButtons; // 20

    @FindBy (css = "[id='results-section'] picture")
    public List<WebElement> tileImages; // 20

    @FindBy (css = "div[class='tk-frame middle-frame']")
    public List<WebElement> middleOfTileBody; // 20

    @FindBy (css = "div[class='tk-frame bottom-frame']")
    public List<WebElement> bottomOfTileBody; // 20

    @FindBy(css = "div[data-test='BaseInventoryType']")
    public List<WebElement> inventoryType; //20

    @FindBy (css = "div[data-qa='make-model']")
    public List<WebElement> yearMakeModelResults; // 20

    @FindBy(css = ".trim-mileage")
    public List<WebElement> trimMileageResults; //20

    @FindBy(css = ".price")
    public List<WebElement> carPrices; //20

    @FindBy(css = ".monthly-payment span")
    public List<WebElement> carEstimateMonthlyPrices; //20

    @FindBy(css = ".down-payment")
    public List<WebElement> carDownPaymentPrices; //20

    @FindBy(css = ".delivery-chip")
    public List<WebElement> deliveryResults; //20

}
