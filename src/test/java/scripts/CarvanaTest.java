package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CarvanaHomePage;
import pages.SearchCarsPage;
import untilities.ConfigReader;
import untilities.ExpectedTexts;
import untilities.Waiters;

public class CarvanaTest extends Base{

    CarvanaHomePage carvanaHomePage;
    SearchCarsPage searchCarsPage;

    @BeforeClass
    public void setUpPages(){
        carvanaHomePage = new CarvanaHomePage();
        searchCarsPage = new SearchCarsPage();
    }

    /* Test Case 1:
    Test name = Validate Carvana home page title and url
    Test priority = 1
    Given user is on "https://www.carvana.com/"
    Then validate title equals to "Carvana | Buy & Finance Used Cars Online | At Home Delivery"
    And validate url equals to "https://www.carvana.com/"
    */
    @Test (priority = 1, description = "Validate Carvana home page title and url")
    public void testHomePageTitle_URL(){
        //driver.get("https://www.carvana.com/");
        Assert.assertEquals(driver.getTitle(),"Carvana | Buy & Finance Used Cars Online | At Home Delivery");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.carvana.com/");
    }

    /* Test Case 2:
    Test name = Validate the Carvana logo
    Test priority = 2
    Given user is on "https://www.carvana.com/"
    Then validate the logo of the “Carvana” is displayed
    */
    @Test (priority = 2, description = "Validate the Carvana logo")
    public void testCarvanaLogo(){
        //driver.get("https://www.carvana.com/");
        Assert.assertTrue(carvanaHomePage.carvanaLogo.isDisplayed());
    }

    /* Test Case 3:
    Test name = Validate the main navigation section items
    Test priority = 3
    Given user is on "https://www.carvana.com/"
    Then validate the navigation section items below are displayed
        |HOW IT WORKS     |
        |ABOUT CARVANA    |
        |SUPPORT & CONTACT|
    */
    @Test (priority = 3, description = "Validate the main navigation section items")
    public void testMainNavigation(){
        //driver.get("https://www.carvana.com/");
        //String[] menuNavigationTexts = {"HOW IT WORKS", "ABOUT CARVANA", "SUPPORT & CONTACT"};
        Waiters.waitForVisibilityOfElement(driver, carvanaHomePage.mainNavigationItems, 10);
        for (int i = 0; i < 3; i++){
            Assert.assertTrue(carvanaHomePage.mainNavigationItems.get(i).isDisplayed());
            Assert.assertEquals(carvanaHomePage.mainNavigationItems.get(i).getText(), ExpectedTexts.menuNavigationTexts[i]);
        }
    }

    /* Test Case 4:
    Test name = Validate the sign in error message
    Test priority = 4
    Given user is on "https://www.carvana.com/"
    When user clicks on “SIGN IN” button
    Then user should be navigated to “Sign in” modal
    When user enters email as “johndoe@gmail.com”
    And user enters password as "abcd1234"
    And user clicks on "SIGN IN" button
    Then user should see error message as:
    "Email address and/or password combination is incorrect
    Please try again or reset your password."
    */
    @Test (priority = 4, description = "Validate the sign in error message")
    public void testSignInErrorMsg(){
        //driver.get("https://www.carvana.com/");
        carvanaHomePage.signInLink.click();
        //driver.switchTo()
        carvanaHomePage.emailInputBox.sendKeys("johndoe@gmail.com");
        carvanaHomePage.passwordInputBox.sendKeys("abcd1234");
        carvanaHomePage.signInButton.click();
        Assert.assertTrue(carvanaHomePage.signInErrorMsg.isDisplayed());
        Assert.assertEquals(carvanaHomePage.signInErrorMsg.getText(),
                "Email address and/or password combination is incorrect\nPlease try again or reset your password.");
    }

    /* Test Case 5:
    Test name = Validate the search filter options and search button
    Test priority = 5
    Given user is on "https://www.carvana.com/"
    When user clicks on "SEARCH CARS" link
    Then user should be routed to "https://www.carvana.com/cars"
    And user should see filter options
        |PAYMENT & PRICE|
        |MAKE & MODEL	|
        |BODY TYPE		|
        |YEAR & MILEAGE |
        |FEATURES	    |
        |MORE FILTERS   |
    */
    @Test (priority = 5, description = "Validate the search filter options and search button")
    public void testSearchFilter_Button(){
        //driver.get("https://www.carvana.com/");
        Waiters.waitForVisibilityOfElement(driver, carvanaHomePage.searchCarsLink, 5);
        carvanaHomePage.searchCarsLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
        String[] filterOptionTexts = {"PAYMENT & PRICE", "MAKE & MODEL", "BODY TYPE", "YEAR & MILEAGE", "FEATURES", "MORE FILTERS"};
        int index = 0;
        for(WebElement option : searchCarsPage.filterOptions){
            Assert.assertTrue(option.isDisplayed());
            Assert.assertEquals(option.getText(), filterOptionTexts[index++]);
        }
    }

    /* Test Case 6:
    Test name = Validate the search result tiles
    Test priority = 6
    Given user is on "https://www.carvana.com/"
    When user clicks on "SEARCH CARS" link
    Then user should be routed to "https://www.carvana.com/cars"
    When user enters "mercedes-benz" to the search input box
    And user clicks on "GO" button in the search input box
    Then user should see "mercedes-benz" in the url
    And validate each result tile

    VALIDATION OF EACH TILE INCLUDES BELOW
    Make sure each result tile is displayed with below information:
    1. an image
    2. add to favorite button
    3. tile body

    ALSO VALIDATE EACH TILE BODY:
    Make sure each tile body has below information:
    1. Inventory type - text should be displayed and should not be null
    2. Year-Make-Model information - text should be displayed and should not be null
    3. Trim-Mileage information - text should be displayed and should not be null
    4. Price - Make sure that each price is more than zero
    5. Monthly Payment information - text should be displayed and should not be null
    6. Down Payment information - text should be displayed and should not be null
    7. Delivery chip must be displayed as “Free Shipping” and should not be null
    NOTE: After completing all scripts, create a xml file called “Regression.xml” and make sure that you can run all scripts using “mvn test -Dsurefire.xmlSuiteFiles=Regression.xml”
    */
    @Test (priority = 6, description = "Validate the search result tiles")
    public void testSearchResultTiles() {
        carvanaHomePage.searchCarsLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), ConfigReader.getProperty("url") + "cars");
        searchCarsPage.searchCarsInputBox.sendKeys("mercedes-benz");
        searchCarsPage.goButton.click();

        while (searchCarsPage.paginationNextButton.isEnabled()) {
            Assert.assertTrue(driver.getCurrentUrl().contains("mercedes-benz"));
            for (int i = 0; i < searchCarsPage.resultTiles.size(); i++) {
                Assert.assertTrue(searchCarsPage.resultTiles.get(i).isDisplayed());
                Assert.assertTrue(searchCarsPage.tileImages.get(i).isDisplayed());
                Assert.assertTrue(searchCarsPage.favoriteButtons.get(i).isDisplayed());
                Assert.assertTrue(searchCarsPage.inventoryType.get(i).isDisplayed());
                Assert.assertFalse(searchCarsPage.inventoryType.get(i).getText().isEmpty());
                Assert.assertNotNull(searchCarsPage.inventoryType.get(i).getText());
                Assert.assertTrue(searchCarsPage.yearMakeModelResults.get(i).isDisplayed());
                Assert.assertFalse(searchCarsPage.yearMakeModelResults.get(i).getText().isEmpty());
                Assert.assertNotNull(searchCarsPage.yearMakeModelResults.get(i).getText());
                Assert.assertTrue(searchCarsPage.trimMileageResults.get(i).isDisplayed());
                Assert.assertFalse(searchCarsPage.trimMileageResults.get(i).getText().isEmpty());
                Assert.assertNotNull(searchCarsPage.trimMileageResults.get(i).getText());
                Assert.assertTrue(searchCarsPage.carPrices.get(i).isDisplayed());
                Assert.assertTrue(Integer.parseInt(searchCarsPage.carPrices.get(i).getText().replaceAll("[^0-9]", "")) > 0);
                Assert.assertTrue(searchCarsPage.carEstimateMonthlyPrices.get(i).isDisplayed());
                Assert.assertFalse(searchCarsPage.carEstimateMonthlyPrices.get(i).getText().isEmpty());
                Assert.assertNotNull(searchCarsPage.carEstimateMonthlyPrices.get(i).getText());
                Assert.assertTrue(searchCarsPage.carDownPaymentPrices.get(i).isDisplayed());
                Assert.assertFalse(searchCarsPage.carDownPaymentPrices.get(i).getText().isEmpty());
                Assert.assertNotNull(searchCarsPage.carDownPaymentPrices.get(i).getText());
                Assert.assertTrue(searchCarsPage.deliveryResults.get(i).isDisplayed());
                Assert.assertFalse(searchCarsPage.deliveryResults.get(i).getText().isEmpty());
                Assert.assertNotNull(searchCarsPage.deliveryResults.get(i).getText());
            }
            searchCarsPage.paginationNextButton.click();
        }
    }
}
