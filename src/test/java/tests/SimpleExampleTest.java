package tests;

import elementLocators.Locators;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementsInteractingMethods;

import static util.ElementsInteractingMethods.*;
import static util.CommonMethods.*;

import java.net.MalformedURLException;
import java.net.URL;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SimpleExampleTest {

    public static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
    public static final String BS_URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver driver;
    JavascriptExecutor jse = (JavascriptExecutor)driver;

    Locators locators = new Locators(driver);

    static String view = "";

    String url = "https://www.icabanken.se/lana/privatlan/hur-mycket-far-jag-lana/";

    @BeforeAll
    public static void setUpp () throws InterruptedException, MalformedURLException
    {
        //mvn test -Dviewmode="web_chrome"

        DesiredCapabilities caps = new DesiredCapabilities();
        view = System.getProperty("viewmode");
        switch (view)
        {
            case "web_chrome":

                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "98.0");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.14.0");
                break;

            case "web-firefox":

                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Firefox");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.14.0");
                break;


            case "mobile":

                caps.setCapability("os_version", "10.0");
                caps.setCapability("device", "Samsung Galaxy S20");
                caps.setCapability("real_mobile", "true");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browser", "chrome");
                break;
        }
        driver = new RemoteWebDriver(new URL(BS_URL), caps);

    }

    @AfterAll
    public static void tearDown()
    {
        driver.quit();
    }


    @DisplayName("WebPage url is right")
    @Order(1)
    @Test
    public void testPageUrlIsRight() throws InterruptedException, MalformedURLException {

/*        //mvn test -Dviewmode="web_chrome"

        view = System.getProperty("viewmode");
        DesiredCapabilities caps = new DesiredCapabilities();

        switch (view)
        {
            case "web_chrome":

                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "98.0");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.14.0");

                break;

            case "mobile":

                caps.setCapability("os_version", "10.0");
                caps.setCapability("device", "Samsung Galaxy S20");
                caps.setCapability("real_mobile", "true");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browser", "chrome");

                break;
        }

        WebDriver driver = new RemoteWebDriver(new URL(BS_URL), caps);
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        Locators locators = new Locators(driver);*/

        driver.get(url);

        //Actions actions = new Actions(driver);
        //WebElement cookiesButton = driver.findElement(By.xpath("//button[contains(text(), 'cookies')]"));
        //actions.moveToElement(locators.cookiesButton);

        //Thread.sleep(3000);
       // WebDriverWait wait = new WebDriverWait(driver, 10);
       // wait.until(ExpectedConditions.visibilityOf(locators.cookiesButton));
        waitUntilVisibility(driver, locators.cookiesButton);
        //locators.cookiesButton.click();

        clickOnButton(driver, locators.cookiesButton);
        Thread.sleep(3000);

        String currentURL = getCurrentURL(driver);

        Assertions.assertTrue(url.equalsIgnoreCase(currentURL));

        //JavascriptExecutor jse = (JavascriptExecutor)driver;
        if (url.equalsIgnoreCase(currentURL))
        {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"URL is right!\"}}");
        }
        else {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"URL is not right!\"}}");
        }

    }


    @DisplayName("2. Logo and header elements are visible")
    //@Disabled
    @Order(2)
    @Test
    public void logoAndHeaderElementsAreVisible()  {

        Assertions.assertTrue(isElementVisible(driver, locators.logoICABanken));

        if (isElementVisible(driver, locators.logoICABanken))
        {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Logo is visible!\"}}");
        }
        else {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Logo is not visible!\"}}");
        }


        Assertions.assertTrue(isElementVisible(driver, locators.logInButton));

        if (isElementVisible(driver, locators.logInButton))
        {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"LogIn button is visible!\"}}");
        }
        else {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"LogIn button is not visible!\"}}");
        }


        if (view.equals("web_chrome") || view.equals("web_firefox"))
        {
            Assertions.assertTrue(isElementVisible(driver, locators.searchHeaderButton));

            if (isElementVisible(driver, locators.searchHeaderButton))
            {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Header button is visible!\"}}");
            }
            else {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Header button is not visible!\"}}");
            }
        }
        if (view.equals("mobile"))
        {
            Assertions.assertTrue(isElementVisible(driver, locators.gamburgerMenuButton));

            if (isElementVisible(driver, locators.gamburgerMenuButton))
            {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Gamburger menu button is visible!\"}}");
            }
            else {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Gamburger menu button is not visible!\"}}");
            }
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

            if (isElementEnable(driver, locators.searchHeaderButton))
            {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Search button is enable!\"}}");
            }
            else {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Gamburger menu button is not enable!\"}}");
            }

            Assertions.assertTrue(isElementEnable(driver, locators.logInButton));

            if (isElementEnable(driver, locators.logInButton))
            {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"LogIn button is enable!\"}}");
            }
            else {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Gamburger menu button is not enable!\"}}");
            }
        }

        if (view.equals("mobile"))
        {
            Assertions.assertTrue(isElementEnable(driver, locators.logInButton));

        }
        if (isElementEnable(driver, locators.logInButton))
        {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"LogIn button is enable!\"}}");
        }
        else {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Gamburger menu button is not enable!\"}}");
        }

    }
}
