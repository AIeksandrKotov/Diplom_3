package pageStep;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private static WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By ACCOUNT = By.xpath(".//p[text()='Личный Кабинет']");
    private final By REGISTER = By.xpath(".//a[text()='Зарегистрироваться']");
    private final By NAME = By.xpath(".//label[text()='Имя']//following-sibling::input");
    private final By EMAIL = By.xpath(".//label[text()='Email']//following-sibling::input");
    private final By PASSWORD = By.xpath(".//label[text()='Пароль']//following-sibling::input");
    private final By SIGN_UP = By.xpath("//button[text()='Зарегистрироваться']");
    private final String SUCCESS_REGISTER = "https://stellarburgers.nomoreparties.site/login";
    private final By TEXT_ERROR = By.xpath("//p[text()='Некорректный пароль']");

    @Step("Кликаем на личный кабинет")
    public RegisterPage clickAccountButton() {
        driver.findElement(ACCOUNT).click();
        return this;
    }
    @Step("Кликаем на кнопку регитсрации")
    public RegisterPage clickRegisterButton() {
        driver.findElement(REGISTER).click();
        return this;
    }

    @Step("Кликаем на поле Name")
    public RegisterPage clickNameInput(String name) {
        driver.findElement(NAME).click();
        driver.findElement(NAME).sendKeys(name);
        return this;
    }
    @Step("Кликаем на поле Email")
    public RegisterPage clickEmailInput(String email) {
        driver.findElement(EMAIL).click();
        driver.findElement(EMAIL).sendKeys(email);
        return this;
    }
    @Step("Кликаем на поле пароль")
    public RegisterPage clickPasswordInput(String password) {
        driver.findElement(PASSWORD).click();
        driver.findElement(PASSWORD).sendKeys(password);
        return this;
    }
    @Step("Кликаем на кнопку зарегистрироваться")
    public RegisterPage clickSignUpButton() {
        driver.findElement(SIGN_UP).click();
        return this;
    }

    @Step("Получаем подтверждение регистрации")
    public String successRegister() {
        driver.get(SUCCESS_REGISTER);
        return driver.getCurrentUrl();
    }
    @Step("Получаем текст ошибки")
    public String errorText() {
        return driver.findElement(TEXT_ERROR).getText();
    }

    @Step
    public void register(String name, String email, String password) {
        clickAccountButton();
        clickRegisterButton();
        clickNameInput(name);
        clickEmailInput(email);
        clickPasswordInput(password);
        clickSignUpButton();
    }
}
