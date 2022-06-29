package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import untilities.Driver;

import java.util.List;

public class CarvanaHomePage {

    /* public CarvanaHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    } */
    public CarvanaHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (css = "div[data-qa='logo-wrapper']")
    public WebElement carvanaLogo;

    @FindBy (css = "div[data-qa='navigation-wrapper']>div>a")
    public List<WebElement> mainNavigationItems;

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
