package decemberLabs;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AustinPage {
    private WebDriver driver;

    @FindBy(css = "h1")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class='left']//a[text()='Schedule free consultation']")
    private WebElement scheduleConsultationButton;

    @FindBy(xpath = "//div[@class='js-calendar-selector']")
    private WebElement popup;

    public AustinPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean validateAustinPage() {
        return pageTitle.isDisplayed() && driver.getCurrentUrl().contains("/austin");
    }

    public void openConsultationPopup() {
        scheduleConsultationButton.click();
    }

    public boolean validateConsultationPopup() {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOf(popup));
        return popup.isDisplayed();
    }

    public void closePopup() {
        driver.switchTo().frame("calendly-popup-widget");
        driver.findElement(By.xpath("//div[@class='dl-modal calendar-modal open']//div[@class='btn-close-modal']")).click();
        driver.switchTo().defaultContent();
    }

    public boolean validatePopupClosed() {
        return !popup.isDisplayed();
    }
}

