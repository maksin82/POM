package pageObjectsTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.MainPage;
import pageObjects.SubmitNewLanguagePage;

public class TestSubmitNewLanguagePage {
    protected WebDriver driver;

    @BeforeMethod
    public void startApp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void closeApp() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void testSubNewLanguage() {
        String searchElement = "Submit New Language";

        MainPage mainPage = new MainPage(driver);
        mainPage.open();

        SubmitNewLanguagePage submitNewLanguagePage = mainPage.getSubNewLanguagePage();

        Assert.assertEquals(submitNewLanguagePage
                .getElementSubmitNewLanguage().getText(),searchElement);
        Assert.assertEquals(submitNewLanguagePage
                .getTextSubmitNewLanguage(),searchElement);
    }
}
