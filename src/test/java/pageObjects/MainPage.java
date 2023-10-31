package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MainPage {
    private WebDriver driver;
    private Wait<WebDriver> wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(200));
    }

    public void open() {
        driver.get("http://www.99-bottles-of-beer.net/");
    }

    public String get99BofB() {
        By elby = By.xpath("//h1");
        WebElement element = driver.findElement(elby);
        return element.getText();
    }

    public String subNewLangText(String tab) {
        String tabText = "";

        List<WebElement> tabs = driver.
                findElements(By.xpath("//ul[@id='menu']//a"));

        for (WebElement element : tabs) {
            if (element.getText().equals(tab.toUpperCase())) {
                tabText = tab;
            }
        }
        return tabText;
    }

    public String submitMenuTab(String tabMenu) {
        //  String searchElement = "Submit New Language";
        List<String> findElement = new ArrayList<>();

        List<WebElement> listMenu = driver.
                findElements(By.xpath("//ul[@id='menu']//a"));

        for (WebElement element : listMenu) {
            if (element.getText().equalsIgnoreCase(tabMenu)) {
                findElement.add(element.getText());
            }
        }
        return findElement.toString().replace("[", "")
                .replace("]", "");
    }

    public List<WebElement> getMenuTab() {
        return driver.
                findElements(By.xpath("//ul[@id='menu']//a"));
    }

    public SubmitNewLanguagePage getSubNewLanguagePage() {
        for (WebElement element : getMenuTab()) {
            if (element.getText().equalsIgnoreCase("Submit New Language")) {
                element.click();
            }
        }
        return new SubmitNewLanguagePage(driver);
    }

    public BrowseLanguagesPage getBrowseLanguagePage() {
        for (WebElement element : getMenuTab()) {
            if (element.getText().equalsIgnoreCase("Browse Languages")) {
                element.click();
            }
        }
        return new BrowseLanguagesPage(driver);
    }

//    public BrowseLanguagesPage getBrowseLanguagePage() {
//        for (WebElement element : getMenuTab()) {
//            if (element.getText().equalsIgnoreCase("Browse Languages")) {
//                element.click();
//            }
//        }
//        return new BrowseLanguagesPage(driver);
//    }

//    public BrowseLanguagesPage navigateToBrowseLanguagePage() {
//        for (int i = 0; i < getMenuTab().size(); i++) {
//            if (getMenuTab().get(i).getText().equalsIgnoreCase("Browse Languages")) {
//                getMenuTab().get(i).click();
//            }
//        }
//        return new BrowseLanguagesPage(driver);
//    }
}
