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

    @FindBy(xpath = "//div[@class='dl-modal calendar-modal open']//div[@class='btn-close-modal']")
    private WebElement btnClose;

    @FindBy(xpath = "//div[@class='start-project-form content_form']//iframe")
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
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(btnClose));
        btn.click();
    }
    public boolean validatePopupClosed() {
        return !popup.isDisplayed();
    }

}

