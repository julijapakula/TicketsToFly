package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BaseFunc {
    private WebDriver driver; // нужен для использования только в рамках данного класса
    public String text;

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

    public void selectFromDropdown(By locator, String text) {
        Select select = new Select(driver.findElement(locator)); //не требуется клик, нашли и выбрали
        select.selectByVisibleText(text);
    }

    public WebElement getElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement getElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator); // можно добавить проверку на то, что элемент существует
        // можно поставить ожидание на исчезновение крутилки(загрузки) F12/ Network -> Online -> Offline
    }

    public WebElement getElementFromList(By locator, int index) {
        return driver.findElements(locator).get(index);
    }

    public void waitClick(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement getElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        getElement.click();
    }

    public void typeToField(By locator, String text) {
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }

    public void quitButtleField() {
        driver.quit();
    }
}


