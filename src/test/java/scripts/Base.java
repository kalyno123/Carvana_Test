package scripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.CarvanaHomePage;
import pages.SearchCarsPage;
import untilities.ConfigReader;
import untilities.Driver;

import java.util.concurrent.TimeUnit;

public class Base {

    // DECLARE GLOBAL VARIABLE
    WebDriver driver;
    WebDriverWait explicitWait;
    Wait fluentWait;
    SoftAssert softAssert;
    Actions actions;
    JavascriptExecutor js;
    //CarvanaHomePage carvanaHomePage;
    //SearchCarsPage searchCarsPage;

    @BeforeMethod (alwaysRun = true)
    // INITIALIZING OBJECTS VARIABLES
    public void setup(){
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("url"));
        explicitWait = new WebDriverWait(driver, 10);
        fluentWait = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS).ignoring(Exception.class);
        softAssert = new SoftAssert();
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
        //carvanaHomePage = new CarvanaHomePage(driver);
        //searchCarsPage = new SearchCarsPage(driver);
    }

    @AfterMethod (alwaysRun = true)
    public void teardown(){
        softAssert.assertAll();
        Driver.quitDriver(); // THIS METHOD IN OUR UTIL. CLASS TEARDOWN THE DRIVER COMPLETELY INCLUDING DELETING ANY STORED DATA(COOKIES)
    }

}
