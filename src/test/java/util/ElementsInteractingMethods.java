package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsInteractingMethods {


    /*---------------------------------------------------------------------
     * Method waitUntilVisibility() to wait the visibility of the element
     *---------------------------------------------------------------------*/
    public static void waitUntilVisibility(WebDriver driver, WebElement element)
    {

        Actions actions = new Actions(driver);
        actions.moveToElement(element);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /*---------------------------------------------------------------------
     * Method clickOnButton() to click on element
     *---------------------------------------------------------------------*/
    public static void clickOnButton(WebDriver driver, WebElement element)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        element.click();
    }

}
