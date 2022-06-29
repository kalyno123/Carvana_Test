package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import untilities.Driver;

import java.util.List;

public class SearchCarsPage {

    /* public SearchCarsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    } */

    public SearchCarsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (css = "div[data-qa='menu-flex']>button")
    public List<WebElement> filterOptions;

    @FindBy (css = "input[data-test='SearchBarInput']")
    public WebElement searchCarsInputBox;

    @FindBy (css = "button[data-qa='go-button']")
    public WebElement goButton;

    @FindBy (css = ".result-tile")
    public List<WebElement> resultTiles;

    @FindBy (css = "[data-test='BaseFavoriteVehicle']")
    public List<WebElement> favoriteButtons;

    @FindBy (css = "[id='results-section'] picture")
    public List<WebElement> tileImages;

    @FindBy(css = "div[data-test='BaseInventoryType']")
    public List<WebElement> inventoryType;

    @FindBy (css = "div[data-qa='make-model']")
    public List<WebElement> yearMakeModelResults;

    @FindBy(css = ".trim-mileage")
    public List<WebElement> trimMileageResults;

    @FindBy(css = ".price")
    public List<WebElement> carPrices;

    @FindBy(css = ".monthly-payment span")
    public List<WebElement> carEstimateMonthlyPrices;

    @FindBy(css = ".down-payment")
    public List<WebElement> carDownPaymentPrices;

    @FindBy(css = ".delivery-chip")
    public List<WebElement> deliveryResults;

    @FindBy(css = "button[data-cv-test='Cv.Search.Pagination.NextPageButton']")
    public WebElement paginationNextButton;

}
