package ru.yandex.praktikum;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.page_object.MainPage;
import ru.yandex.praktikum.page_object.OrderPage;
import ru.yandex.praktikum.page_object.OrderSecondPage;
import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class OrderTest {

    private final String name;
    private final String surName;
    private final String address;
    private final String telephoneNumber;
    private final String subwayStation;
    private final String comment;
    private String expectedOrderText = "Заказ оформлен";

    public OrderTest(String name, String surName, String address, String telephoneNumber, String metroStation, String comment) {
        this.name = name;
        this.surName = surName;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.comment = comment;
        this.subwayStation = metroStation;
    }

    @Parameterized.Parameters()
    public static Object[][] orderInsert() {
        return new Object[][]{
                {"Саша", "Иванов", "Тверь", "89991333322", "Аэропорт", "Проверка"},
                {"Иван", "Сашев", "Серпухов", "89991111322", "Жулебино", "Не проверка"},
        };
    }

    WebDriver driver;

    @Before
    public void setup() {
        //driver = new ChromeDriver();
         WebDriverManager.firefoxdriver().setup();
         driver = new FirefoxDriver();
    }

    @Test
    public void createOrderTopButton() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        OrderSecondPage orderSecondPage = new OrderSecondPage(driver);

        mainPage.openMainSitePage();
        mainPage.clickOnOrderTop();

        orderPage.setNameField(name);
        orderPage.setSurnameField(surName);
        orderPage.setAddressField(address);
        orderPage.setTelephoneNumber(telephoneNumber);
        orderPage.setSelectSubway(subwayStation);
        orderPage.clickOnNextButton();

        orderSecondPage.clickButtonCookie(); // если видна
        orderSecondPage.openCalendar();
        orderSecondPage.pickDate();
        orderSecondPage.openRentTerm();
        orderSecondPage.pickFiveDays();
        orderSecondPage.setUpperCheckBox();
        orderSecondPage.fillComment(comment);
        orderSecondPage.clickOnOrderButton();
        orderSecondPage.clickOnYesButton();
        assertTrue("Произошла ошибка",orderSecondPage.getOrderMessage().contains(expectedOrderText));
    }

    @Test
    public void createOrderMiddleButton() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        OrderSecondPage orderSecondPage = new OrderSecondPage(driver);

        mainPage.openMainSitePage();
        mainPage.clickOnOrderMiddle();

        orderPage.setNameField(name);
        orderPage.setSurnameField(surName);
        orderPage.setAddressField(address);
        orderPage.setTelephoneNumber(telephoneNumber);
        orderPage.setSelectSubway(subwayStation);
        orderPage.clickOnNextButton();

        orderSecondPage.clickButtonCookie(); // если видна
        orderSecondPage.openCalendar();
        orderSecondPage.pickDate();
        orderSecondPage.openRentTerm();
        orderSecondPage.pickFiveDays();
        orderSecondPage.setUpperCheckBox();
        orderSecondPage.fillComment(comment);
        orderSecondPage.clickOnOrderButton();
        orderSecondPage.clickOnYesButton();
        assertTrue("Произошла ошибка",orderSecondPage.getOrderMessage().contains(expectedOrderText));
    }

   @After
    public void teardown() {
        driver.quit();
    }
}
