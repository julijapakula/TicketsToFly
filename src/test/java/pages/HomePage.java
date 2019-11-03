package pages;

import org.openqa.selenium.By;

public class HomePage {
    private BaseFunc baseFunc;
    private final By HP_FIRST_SPAN = By.id("afrom");

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    
}
