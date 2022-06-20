package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchCarsPage {

    public SearchCarsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "div[data-qa='menu-flex']>button")
    public List<WebElement> filterOptions;

    @FindBy (css = "input[data-test='SearchBarInput']")
    public WebElement searchCarsInputBox;

    @FindBy (css = "button[data-qa='go-button']")
    public WebElement goButton;

}
