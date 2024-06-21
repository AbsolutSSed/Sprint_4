package ru.yandex.praktikum.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderSecondPage {
    private WebDriver driver;

    private By datePickerDropdown = By.xpath("//div[@class='react-datepicker__input-container']"); // дропдаун для выбора даты
    private By datePickerCalendar = By.xpath("//div[@class='react-datepicker__day react-datepicker__day--021 react-datepicker__day--keyboard-selected react-datepicker__day--today']"); // локатор внутри календаря
    private By rentTermDropDown = By.xpath("//div[@class='Dropdown-placeholder']"); // дропдаун для выбора даты аренды
    private By rentTermFiveDays = By.xpath(".//div[@class='Dropdown-option' and text()='пятеро суток']"); // локатор для выбора "пять суток"
    private By upperCheckBox = By.xpath("//input[@id='black']"); // локатор верхнего чекбокса
    private By commentInput = By.xpath("//input[@placeholder='Комментарий для курьера']"); // локатор инпут поля для комментария
    private By orderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']"); // кнопка заказа
    private By yesButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Да']"); // кнопка "да"
    private By cookieButton = By.xpath("//button[@id='rcc-confirm-button']"); // кнопка для закрытия куки
    private By orderMessage = By.xpath("//*[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']"); // локатор сообщения о заказе

    public OrderSecondPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCalendar() {
        driver.findElement(datePickerDropdown).click();
    }
    public void pickDate() {
        driver.findElement(datePickerCalendar).click();
    }
    public void openRentTerm() {
        driver.findElement(rentTermDropDown).click();
    }
    public void pickFiveDays() {
        driver.findElement(rentTermFiveDays).click();
    }
    public void setUpperCheckBox() {
        driver.findElement(upperCheckBox).click();
    }
    public void fillComment(String comment) {
        driver.findElement(commentInput).sendKeys(comment);
    }
    public void clickOnOrderButton() {
        driver.findElement(orderButton).click();
    }
    public void clickOnYesButton() {
        driver.findElement(yesButton).click();
    }
    public void clickButtonCookie() {
        WebElement cookie = driver.findElement(cookieButton);
        if (cookie.isDisplayed()) {
            cookie.click();
        }
    }
    public String getOrderMessage() {
        WebElement orderText = driver.findElement(orderMessage);
        return orderText.getText();
    }

}
