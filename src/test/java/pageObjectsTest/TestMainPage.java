package pageObjectsTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.MainPage;

public class TestMainPage {
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
    public void testFindText99BofB() {
        String expectedText = "99 Bottles of Beer";

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Assert.assertEquals(expectedText, mainPage.get99BofB());
    }

    @Test
    public void testMenuSubNewLanguage() {
        String searchElement = "Submit New Language";

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Assert.assertEquals(mainPage.submitMenuTab(searchElement),
                searchElement.toUpperCase());
        Assert.assertEquals(mainPage.subNewLangText(searchElement),
                searchElement);
    }
}
