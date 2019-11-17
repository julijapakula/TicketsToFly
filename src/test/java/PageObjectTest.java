import org.junit.jupiter.api.Test;
import pages.*;

public class PageObjectTest {
    String name ="Julija";
    String surname = "Pakula";
    String discount = "Hacker";
    String adult = "0";
    String children = "0";
    String bags = "1";
    @Test
    public void poTest() {
        // open  browser
        // maximize windows
        BaseFunc baseFunc = new BaseFunc(); // отработал конструктор Область видимости (private, public) не указываем, потому что он внутри метода
        //go to url
        baseFunc.goToUrl("qaguru.lv:8089/tickets/");
        HomePage homePage = new HomePage(baseFunc);
        //select departure
        homePage.selectDeparture("RIX");
        // select destination
        homePage.selectDestination("SVO");
        //click gogogo
        homePage.getGO();
        //fill in fields
        RegistrationPage registrationPage = new RegistrationPage(baseFunc);
        registrationPage.typeTo(name, surname,discount, adult, children, bags);
        registrationPage.selectFlight();
        // click get price
        registrationPage.clickGetPrice();
        registrationPage.checkRegistration();
        //click book
        registrationPage.clickBookBtn();
        //select seats
        SeatsPage seatsPage = new SeatsPage(baseFunc);
        seatsPage.chooseSeat();
        //click book
        seatsPage.checkSeat();
        seatsPage.clickBookBtn();
        //check thank you page
        ThankYouPage thankYouPage = new ThankYouPage(baseFunc);
        thankYouPage.getFinalTnx();
        //close browser
        baseFunc.quitButtleField();
    }
}
