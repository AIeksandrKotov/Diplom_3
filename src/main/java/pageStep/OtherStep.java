package pageStep;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OtherStep {
    private static WebDriver driver;

    public OtherStep(WebDriver driver) {
        this.driver = driver;
    }

    private final By ACCOUNT = By.xpath(".//p[text()='Личный Кабинет']");
    private final By CONSTRUCTOR = By.xpath(".//p[text()='Конструктор']");
    private final By LOGO = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");
    private final By EXIT = By.xpath(".//button[text()='Выход']");
    private final By BUNS = By.xpath(".//span[text()='Булки']/..");
    private final By SAUCES = By.xpath(".//span[text()='Соусы']/..");
    private final By FILLINGS = By.xpath(".//span[text()='Начинки']/..");


    @Step("Кликаем на личный кабинет")
    public OtherStep clickAccountButton() {
        driver.findElement(ACCOUNT).click();
        return this;
    }
    @Step("Кликаем на конструктор")
    public OtherStep clickConstructor() {
        driver.findElement(CONSTRUCTOR).click();
        return this;
    }
    @Step("Кликаем на логотип")
    public OtherStep clickLogo() {
        driver.findElement(LOGO).click();
        return this;
    }
    @Step("Кликаем на кнопку выход")
    public OtherStep clickAccountExit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Выход']")));
        driver.findElement(EXIT).click();
        return this;
    }

    @Step("Переход к разделу Булочки")
    public void clickBuns() {
        driver.findElement(BUNS).click();
    }
    @Step("Переход к разделу Соусы")
    public void clickSauces() {
        driver.findElement(SAUCES).click();
    }
    @Step("Переход к разделу Булочки")
    public void clickFilling() {
        driver.findElement(FILLINGS).click();
    }


    @Step("Проверяем выбранный элемент")
    public boolean selectBuns() {
        return driver.findElement(BUNS).getAttribute("class").contains("current");
    }
    @Step("Проверяем выбранный элемент")
    public boolean selectSauce() {
        return driver.findElement(SAUCES).getAttribute("class").contains("current");
    }
    @Step("Проверяем выбранный элемент")
    public boolean selectFillings() {
        return driver.findElement(FILLINGS).getAttribute("class").contains("current");
    }
}
