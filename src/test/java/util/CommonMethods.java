package util;

import org.openqa.selenium.WebDriver;


public class CommonMethods {


    public static String getCurrentURL(WebDriver driver)
    {
        return driver.getCurrentUrl();
    }

    public static void goToPage(WebDriver driver, String url)
    {
        driver.get(url);
    }

}
