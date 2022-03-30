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

import java.net.MalformedURLException;
import java.net.URL;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SimpleExampleTest {

    public static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
    public static final String BS_URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver driver;

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
        locators.cookiesButton.click();

        Thread.sleep(3000);

        String currentURL = driver.getCurrentUrl();
        Assertions.assertTrue(url.equalsIgnoreCase(currentURL));

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        if (url.equalsIgnoreCase(currentURL))
        {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"URL is right!\"}}");
        }
        else {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"URL is not right!\"}}");
        }
    }







}
