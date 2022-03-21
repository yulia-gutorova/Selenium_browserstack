package elementLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.SimpleExampleTest;

public class Locators {

    public static RemoteWebDriver driver;

    public Locators(RemoteWebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath=("//button[contains(text(), 'cookies')]"))
    public WebElement cookiesButton;

}
