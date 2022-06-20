package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarvanaHomePage {

    public CarvanaHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "div[data-qa='logo-wrapper']")
    public WebElement carvanaLogo;

    @FindBy (xpath = "//div[@data-qa='menu-wrapper']")
    public List<WebElement> mainNavigationItems;
    // technically this locator found 4 elements but only need elements at index 0-2; so need to initialize loop accordingly

    @FindBy (css = "a[data-cv-test='headerSignInLink']")
    public WebElement signInLink;

    @FindBy (id = "usernameField")
    public WebElement emailInputBox;

    @FindBy (id = "passwordField")
    public WebElement passwordInputBox;

    @FindBy (css = "button[data-cv='sign-in-submit']")
    public WebElement signInButton;

    @FindBy (css = "div[data-qa='error-message-container']")
    public WebElement signInErrorMsg;

    @FindBy (css = "a[data-cv-test='headerSearchLink']")
    public WebElement searchCarsLink;



}
