package tests;

import elementLocators.Locators;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import util.SetUp;

import static util.ElementsInteractingMethods.*;
import static util.CommonMethods.*;

import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SimpleExampleTest extends SetUp {



    JavascriptExecutor jse = (JavascriptExecutor)driver;
    Locators locators = new Locators(driver);

    String url = "https://www.icabanken.se/lana/privatlan/hur-mycket-far-jag-lana/";


    @DisplayName("1. WebPage url is right")
    @Order(1)
    @Test
    public void testPageUrlIsRight() throws InterruptedException, MalformedURLException {

        goToPage(driver, url);
        clickOnButton(driver, locators.cookiesButton);
        String currentURL = getCurrentURL(driver);

        //--------------------------------------------------------
        //Assertions.assertTrue(url.equalsIgnoreCase(currentURL));
        if (url.equalsIgnoreCase(currentURL))
        {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"URL is right!\"}}");
        }
        else {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"URL is not right!\"}}");
        }
    }


    @DisplayName("2. Logo is visible")
    //@Disabled
    @Order(2)
    @Test
    public void logoIsVisible()  {

        //Assertions.assertTrue(isElementVisible(driver, locators.logoICABanken));

        if (!isElementVisible(driver, locators.logoICABanken))
        {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Logo is not visible!\"}}");
        }
        else {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Logo is visible!\"}}");

        }


    }


    @DisplayName("3. Log in button is visible")
    //@Disabled
    @Order(3)
    @Test
    public void logInElementIsVisible()  {

       // Assertions.assertTrue(isElementVisible(driver, locators.logInButton));


        if (isElementVisible(driver, locators.logInButton))
        {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"LogIn button is visible!\"}}");
        }
        else
        {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"LogIn button is not visible!\"}}");
        }
    }

    @DisplayName("2. Search web button is visible")
    //@Disabled
    @Order(4)
    @Test
    public void searchWebButtonIsVisible()  {

        if (view.equals("web_chrome") || view.equals("web_firefox"))
        {
            //Assertions.assertTrue(isElementVisible(driver, locators.searchHeaderButton));

            if (isElementVisible(driver, locators.searchHeaderButton))
            {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Header button is visible!\"}}");
            }
            else
            {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Header button is not visible!\"}}");
            }
        }
    }

    @DisplayName("2. Search web button is visible")
    //@Disabled
    @Order(4)
    @Test
    public void searchMobileButtonIsNotVisible()  {

        if (view.equals("mobile_iphone") || view.equals("mobile_samsung"))
        {
            //Assertions.assertTrue(isElementVisible(driver, locators.searchHeaderButton));

            if (!isElementVisible(driver, locators.searchHeaderButton))
            {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Search button button is not visible!\"}}");
            }
            else
            {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Header button is visible!\"}}");
            }
        }
    }

    @DisplayName("2. Hamburger mobile menu is visible ")
    //@Disabled
    @Order(5)
    @Test
    public void hamburgerMobileMenuIsVisible()  {

        if (view.equals("mobile_iphone") || view.equals("mobile_samsung"))
        {
            //Assertions.assertTrue(isElementVisible(driver, locators.gamburgerMenuButton));

            if (isElementVisible(driver, locators.gamburgerMenuButton))
            {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Hamburger menu button is visible!\"}}");
            }
            else
            {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Hamburger menu button is not visible!\"}}");
            }
        }
    }




    @DisplayName("3. Search header web button is enable")
    //@Disabled
    @Order(6)
    @Test
    public void searchHeaderWebButtonIsEnabled() {

        if (view.equals("web_chrome") || view.equals("web_firefox")) {
            //Assertions.assertTrue(isElementEnable(driver, locators.searchHeaderButton));

            if (isElementEnable(driver, locators.searchHeaderButton))
            {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Search button is enabled!\"}}");
            } else {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Search button is not enabled!\"}}");
            }
        }
    }

    @DisplayName("3. Log in web button is enable")
    //@Disabled
    @Order(7)
    @Test
    public void LoginWebButtonIsEnabled() {

            if (view.equals("web_chrome") || view.equals("web_firefox"))
            {
               // Assertions.assertTrue(isElementEnable(driver, locators.logInButton));

                if (isElementEnable(driver, locators.logInButton))
                {
                    jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"LogIn button is enabled!\"}}");
                }
                else
                {
                    jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Log in button button is not enabled!\"}}");
                }
            }
        }

    @DisplayName("3. Login mobile button is enabled")
    //@Disabled
    @Order(8)
    @Test
    public void LoginMobileButtonIsEnabled()
    {

        if (view.equals("mobile_iphone") || view.equals("mobile_samsung"))
        {
            //Assertions.assertTrue(isElementEnable(driver, locators.logInButton));



            if (isElementEnable(driver, locators.logInButton))
            {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"LogIn button is enabled!\"}}");
            }
            else
            {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"LogIn button is not enabled!\"}}");
            }

        }
    }
}







