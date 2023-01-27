package elementLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Locators {

    public static WebDriver driver;

    public Locators(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath=("//span[contains(text(), 'alla cookies')]"))
    public WebElement cookiesButton;

    @FindBy(xpath = "//img[@alt='Logo']")
    public WebElement logoICABanken;

    @FindBy(id = "searchHeaderButton")
    public WebElement searchHeaderButton;

    @FindBy(xpath = "//button[text()='Logga in']")
    public WebElement logInButton;

    @FindBy(xpath = "//a[@class = 'header_action__2xCD3 header_actionHamburger__2PXSx header_borderLeft__22RVi']")
    public WebElement gamburgerMenuButton;

}
