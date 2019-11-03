package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseFunc {
    private WebDriver driver; // нужен для использования только в рамках данного класса

    // create constructor // Открываем браузер
    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void goToUrl(String url) {
        if (url.startsWith("http://") || url.startsWith("https://")) {

        } else {
            url = "http://" + url;
        }
        driver.get(url);
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public void selectFromDropdown(By locator, String text) {
        Select dropDown = new Select(driver.findElement(locator));
        dropDown.selectByValue(text);
    }


}
