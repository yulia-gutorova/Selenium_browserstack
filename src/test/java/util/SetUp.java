package util;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import tests.SimpleExampleTest;

import java.net.MalformedURLException;
import java.net.URL;

public class SetUp  {

    public static String view = "";
    public static WebDriver driver;

    public static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
    public static final String BS_URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

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
}
