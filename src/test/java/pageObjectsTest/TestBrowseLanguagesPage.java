package pageObjectsTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.BrowseLanguagesPage;
import pageObjects.MainPage;

import java.util.ArrayList;
import java.util.List;

public class TestBrowseLanguagesPage {
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
    public void testTextFirstTab() {
        String str = "0-9";

        MainPage mainPage = new MainPage(driver);
        mainPage.open();

        BrowseLanguagesPage browseLanguagesPage = mainPage.getBrowseLanguagePage();
        //BrowseLanguagesPage browseLanguagesPage = mainPage.navigateToBrowseLanguagePage();

        Assert.assertEquals(browseLanguagesPage.getTextFirstTab(), str);
    }
}
