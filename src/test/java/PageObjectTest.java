import org.junit.jupiter.api.Test;
import pages.BaseFunc;
import pages.HomePage;

public class PageObjectTest {

    private BaseFunc baseFunc = new BaseFunc();
    @Test
    public void poTest () {
        baseFunc.goToUrl("http://qaguru.lv:8089/tickets/"); //Переходим на сайт http://qaguru.lv:8089/tickets/

        HomePage homePage = new HomePage(baseFunc);
    }
}
