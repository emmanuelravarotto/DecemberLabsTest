package Selenium;

import decemberLabs.AustinPage;
import decemberLabs.DecemberLabsPage;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DecemberLabsTest {
    private WebDriver driver;
    public DecemberLabsPage decemberLabsPage;
    public AustinPage austinPage;

    public DecemberLabsTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\emanuel.ravarotto\\documents\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        decemberLabsPage = new DecemberLabsPage(driver);
        austinPage = new AustinPage(driver);
    }
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void runTest(){
        decemberLabsPage.navigateToDecemberLabs();
        Assert.assertTrue(decemberLabsPage.validateDecemberLabsPage(), "Failed to open December Labs page");

        decemberLabsPage.navigateToAustinPage();
        Assert.assertTrue(austinPage.validateAustinPage(), "Failed to open Austin page");

        austinPage.openConsultationPopup();
        Assert.assertTrue(austinPage.validateConsultationPopup(), "Failed to display consultation popup");
        austinPage.closePopup();
        Assert.assertFalse(austinPage.validatePopupClosed(), "Failed to close consultation popup");
        closeBrowser();
    }
}
