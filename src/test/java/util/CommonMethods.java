package util;

import org.openqa.selenium.WebDriver;



public class CommonMethods {


    public static String getCurrentURL(WebDriver driver)
    {
        return driver.getCurrentUrl();
    }

}
