package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SubmitNewLanguagePage {
    private WebDriver driver;
    private Wait<WebDriver> wait;

    public SubmitNewLanguagePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(200));
    }

    public WebElement getElementSubmitNewLanguage() {
        WebElement element = driver.findElement(By.xpath("//ul[@id='submenu']"));
        return element;
    }
    public String getTextSubmitNewLanguage() {
        return driver.findElement(By.xpath("//ul[@id='submenu']")).getText();
    }
}
