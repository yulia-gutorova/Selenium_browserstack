package tests;

import elementLocators.Locators;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import util.SetUp;

import static util.ElementsInteractingMethods.*;
import static util.CommonMethods.*;

import java.net.MalformedURLException;



@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SimpleExampleTest extends SetUp {



    JavascriptExecutor jse = (JavascriptExecutor)driver;
    Locators locators = new Locators(driver);

    String url = "https://www.icabanken.se/lana/privatlan/hur-mycket-far-jag-lana/";


    @DisplayName("WebPage url is right")
    @Order(1)
    @Test
    public void testPageUrlIsRight() throws InterruptedException, MalformedURLException {

        goToPage(driver, url);
        clickOnButton(driver, locators.cookiesButton);
        String currentURL = getCurrentURL(driver);

        //--------------------------------------------------------
        Assertions.assertTrue(url.equalsIgnoreCase(currentURL));
/*        if (url.equalsIgnoreCase(currentURL))
        {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"URL is right!\"}}");
        }
        else {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"URL is not right!\"}}");
        }*/
    }


    @DisplayName("2. Logo and header elements are visible")
    //@Disabled
    @Order(2)
    @Test
    public void logoAndHeaderElementsAreVisible()  {

        Assertions.assertTrue(isElementVisible(driver, locators.logoICABanken));

/*        if (isElementVisible(driver, locators.logoICABanken))
        {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Logo is visible!\"}}");
        }
        else {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Logo is not visible!\"}}");
        }*/


        Assertions.assertTrue(isElementVisible(driver, locators.logInButton));

/*        if (isElementVisible(driver, locators.logInButton))
        {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"LogIn button is visible!\"}}");
        }
        else {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"LogIn button is not visible!\"}}");
        }*/


        if (view.equals("web_chrome") || view.equals("web_firefox"))
        {
            Assertions.assertTrue(isElementVisible(driver, locators.searchHeaderButton));

/*            if (isElementVisible(driver, locators.searchHeaderButton))
            {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Header button is visible!\"}}");
            }
            else {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Header button is not visible!\"}}");
            }*/
        }
        if (view.equals("mobile"))
        {
            Assertions.assertTrue(isElementVisible(driver, locators.gamburgerMenuButton));

/*            if (isElementVisible(driver, locators.gamburgerMenuButton))
            {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Gamburger menu button is visible!\"}}");
            }
            else {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Gamburger menu button is not visible!\"}}");
            }*/
        }

    }


    @DisplayName("3. Header elements are enable")
    //@Disabled
    @Order(3)
    @Test
    public void headerElementsAreEnabled()  {

        if (view.equals("web_chrome") || view.equals("web_firefox"))
        {
            Assertions.assertTrue(isElementEnable(driver, locators.searchHeaderButton));

/*            if (isElementEnable(driver, locators.searchHeaderButton))
            {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Search button is enable!\"}}");
            }
            else {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Gamburger menu button is not enable!\"}}");
            }*/

            Assertions.assertTrue(isElementEnable(driver, locators.logInButton));

/*            if (isElementEnable(driver, locators.logInButton))
            {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"LogIn button is enable!\"}}");
            }
            else {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Gamburger menu button is not enable!\"}}");
            }*/
        }

/*        if (view.equals("mobile_iphone") || view.equals("mobile_samsung"))
        {
            Assertions.assertTrue(isElementEnable(driver, locators.logInButton));

        }
        if (isElementEnable(driver, locators.logInButton))
        {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"LogIn button is enable!\"}}");
        }
        else {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Gamburger menu button is not enable!\"}}");
        }*/

    }
}
