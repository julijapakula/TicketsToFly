package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class RegistrationPage {
    private BaseFunc baseFunc;
    private final By NAME = By.id("name");
    private final By SURNAME = By.id("surname");
    private final By DISCOUNT = By.id("discount");
    private final By ADULTS = By.id("adults");
    private final By CHILDREN = By.id("children");
    private final By BAGS = By.id("bugs");
    private final By FLIGHT = By.id("flight");
    private final By GET_PRICE_BTN = By.xpath(".//span[contains(@onclick, 'setLang')]");
    private final By BOOK_BTN = By.id("book2");
    private final By DESTINATIONS = By.xpath(".//span[@class = 'bTxt']");

    public RegistrationPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void typeTo() {
        baseFunc.typeToField(NAME, "Julija");
        baseFunc.typeToField(SURNAME, "Pakula");
        baseFunc.typeToField(DISCOUNT, "Hacker");
        baseFunc.typeToField(ADULTS, "0");
        baseFunc.typeToField(CHILDREN, "0");
        baseFunc.typeToField(BAGS, "1");
    }

    public void selectFlight() {
        baseFunc.selectFromDropdown(FLIGHT, "11-05-2018");
    }

    public void clickGetPrice() {
        baseFunc.waitClick(GET_PRICE_BTN);
    }

    public void clickBookBtn() {
        baseFunc.waitClick(BOOK_BTN);
    }

    public void checkRegistration() {
        String textTo = baseFunc.getElementFromList(DESTINATIONS, 0).getText();
        Assertions.assertEquals("RIX", textTo, "Check departure destination - not equal on Home and registration page");
        String textFrom = baseFunc.getElementFromList(DESTINATIONS, 1).getText();
        Assertions.assertEquals("SVO", textFrom, "Check arrival destination - not equal on Home and registration page");
        String textName = baseFunc.getElementFromList(DESTINATIONS, 2).getText();
        Assertions.assertEquals("Julija!", textName, "Check a name of a customer  - not equal on Form and greeting");
    }
}
