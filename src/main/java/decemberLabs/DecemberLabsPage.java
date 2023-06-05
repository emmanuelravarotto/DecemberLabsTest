package decemberLabs;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class DecemberLabsPage {
    private WebDriver driver;

    @FindBy(css = "h1")
    private WebElement pageTitle;

    @FindBy(xpath = "//footer//a[contains(@href, '/austin')]")
    private WebElement austinLink;

    @FindBy(xpath = "//nav//ul[@class='content_navigation']//ul//a[text()='Services']")
    private WebElement serviciosMenuLink;


    public DecemberLabsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToDecemberLabs() {
        driver.get("https://inhouse.decemberlabs.com/");
    }
    public boolean validateDecemberLabsPage() {
        return pageTitle.isDisplayed() && serviciosMenuLink.isDisplayed();
    }

    public void navigateToAustinPage() {
        austinLink.click();
    }


}
