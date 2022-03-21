package tests;

import elementLocators.Locators;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SimpleExampleTest {

    // capabilities generator
    // https://www.browserstack.com/automate/capabilities?tag=selenium-2-3

    //command in command prompt to run the test
    // mvn test -Dviewmode="mobile_chrome" or web_chrome

    public static RemoteWebDriver driver;
    Locators locators = new Locators(driver);
    Actions actions = new Actions(driver);
    JavascriptExecutor jse = (JavascriptExecutor)driver;

    static String view = "";
    static String url = "https://www.icabanken.se/lana/privatlan/hur-mycket-far-jag-lana/";

    public static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
    public static final String BS_URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


    /*---------------------------------------------------------------------
     * BeforeAll() method executes before all methods
     *---------------------------------------------------------------------*/
    @BeforeAll
    public static void setUpp() throws IOException {

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
        driver.get(url);
    }


    /*---------------------------------------------------------------------
     * AfterAll() method executes before all methods
     *---------------------------------------------------------------------*/
    @AfterAll
    public static void tearDown() throws IOException {

        //driver.quit();
    }


    //----------------------------------------------------------------------------------------------------------------------
    @DisplayName("WebPage url is right")
    @Order(1)
    @Test
    public void testPageUrlIsRight() throws InterruptedException, MalformedURLException {

        //view = System.getProperty("viewmode");

/*        DesiredCapabilities caps = new DesiredCapabilities();

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

            case "mobile_chrome":


                caps.setCapability("os_version", "10.0");
                caps.setCapability("device", "Samsung Galaxy S20");
                caps.setCapability("real_mobile", "true");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browser", "chrome");

                break;
        }

        WebDriver driver = new RemoteWebDriver(new URL(BS_URL), caps);
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        driver.get(url);*/

       // WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement cookies= driver.findElement(By.xpath("//button[contains(text(), 'cookies')]"));
       // wait.until(ExpectedConditions.visibilityOf(cookies));

        actions.moveToElement(cookies);
        Thread.sleep(3000);
        cookies.click();
        Thread.sleep(3000);

        String currentURL = driver.getCurrentUrl();
        Assertions.assertTrue(url.equalsIgnoreCase(currentURL));

        if (url.equalsIgnoreCase(currentURL))
        {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"URL is right!\"}}");
        }
        else {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"URL is not right!\"}}");
        }

        driver.quit();
    }

}
