package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class ThankYouPage {
    private BaseFunc baseFunc;
    private final By FINAL_TNX = By.xpath(".//div[@class ='finalTxt']");

    public ThankYouPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void getFinalTnx() {
        String text = baseFunc.getElement(FINAL_TNX).getText();
        Assertions.assertEquals("Thank You for flying with us!", text, "Thank you statement lost");
    }

}
