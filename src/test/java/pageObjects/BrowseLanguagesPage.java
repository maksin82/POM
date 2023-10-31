package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowseLanguagesPage {
    private WebDriver driver;
    private Wait<WebDriver> wait;

    public BrowseLanguagesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(200));
    }

    public String getTextFirstTab() {
        List<WebElement> tabs = driver.findElements(By.xpath("//ul[@id='submenu']//a"));
        List<String> elementsText = new ArrayList<>();

        for (WebElement element : tabs) {
            elementsText.add(element.getText());
        }
        return elementsText.get(0);
    }
/*
    private List<WebElement> getSubMenuList() {
        return driver.findElements(By.xpath("//ul[@id='submenu']/a"));
    }
    public String getSubMenuFirstElement() {
        String firstPageTitle = "";
        for (int i = 0; i < getSubMenuList().size()-1; i++) {
            if (getSubMenuList().get(0).getText().equals("0-9")) {
                firstPageTitle = "0-9";
                break;
            }
        }
        return firstPageTitle;
    }

 */
}
