package ru.yandex.praktikum.page_object;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
    private WebDriver driver;

    private By topOrderButton = By.xpath("//button[@class='Button_Button__ra12g']"); // кнопка "заказать" вверху страницы
    private By middleOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']"); // кнопка "заказать" в центре страницы
    private By accordionClickableDropdown = By.xpath(".//div[contains(@id,'accordion__heading')]"); // Элемент дропдауна в аккордионе
    private By accordionInnerElementText = By.xpath(".//div[contains(@id,'accordion__panel')]"); // Внутренний текст элемента аккордиона
    private final By cookieButton = By.xpath(".//button[@class='App_CookieButton__3cvqF']"); // кнопка для закрытия куки

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

   public void clickOnOrderTop() {
        driver.findElement(topOrderButton).click();
   }


    public void clickOnOrderMiddle() {
        WebElement orderButton = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(middleOrderButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", orderButton);
        orderButton.click();
    }
    public void openMainSitePage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }


    public void clickOnAccordionItem(int index) {
        WebElement questionElement = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(accordionClickableDropdown));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", questionElement);
        WebElement questionElementIndex = driver.findElements(accordionClickableDropdown).get(index);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(questionElementIndex));
        questionElementIndex.click();
    }

    public String getDropDownText(int index) {
        WebElement DropDownElement = driver.findElements(accordionClickableDropdown).get(index);
        return DropDownElement.getText();
    }

    public String getInnerText(int index) {
        WebElement InnerElementText = driver.findElements(accordionInnerElementText).get(index);
        return InnerElementText.getText();
    }

    public void clickButtonCookie() {
        WebElement cookie = driver.findElement(cookieButton);
        if (cookie.isDisplayed()) {
            cookie.click();
        }
    }
}
