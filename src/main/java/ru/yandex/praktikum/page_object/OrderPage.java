package ru.yandex.praktikum.page_object;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;
    private By inputName = By.xpath("//input[@placeholder='* Имя']"); // локатор для поля "Имя"
    private By inputSurname = By.xpath("//input[@placeholder='* Фамилия']"); // локатор для поля "Фамилия"
    private By inputAddress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']"); // локатор для поля "Адрес"
    private By inputTelephoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"); // локатор для поля "телефон"
    private By selectSubway = By.xpath(".//input[@placeholder='* Станция метро']"); // локатор для поля "Станция метро
    private By nextButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Далее']"); // локатор для кнопки "далее"

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setNameField(String username) {
        driver.findElement(inputName).sendKeys(username);
    }
    public void setSurnameField(String surname) {
        driver.findElement(inputSurname).sendKeys(surname);
    }
    public void setAddressField(String address) {
        driver.findElement(inputAddress).sendKeys(address);
    }
    public void setTelephoneNumber(String telephoneNumber) {
        driver.findElement(inputTelephoneNumber).sendKeys(telephoneNumber);
    }
    public void setSelectSubway(String metroStation) {
        driver.findElement(selectSubway).sendKeys(metroStation, Keys.DOWN, Keys.ENTER);
    }
    public void clickOnNextButton(){
        driver.findElement(nextButton).click();
    }
}
