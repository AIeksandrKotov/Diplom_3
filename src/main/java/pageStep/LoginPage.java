package pageStep;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private static WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By ACCOUNT = By.xpath(".//p[text()='Личный Кабинет']");
    private final By ENTER_ACCOUNT = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By REGISTER = By.xpath(".//a[text()='Зарегистрироваться']");
    private final By ENTER_BUTTON = By.xpath(".//a[text()='Войти']");
    private final By PASSWORD_RECOVERY = By.xpath(".//a[text()='Восстановить пароль']");
    private final By EMAIL = By.xpath(".//input[@name='name']");
    private final By PASSWORD =  By.xpath(".//input[@name='Пароль']");
    private final By ENTER = By.xpath("//button[text()='Войти']");


    @Step("Получаем main page")
    public boolean successLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));
        return driver.getCurrentUrl().equals("https://stellarburgers.nomoreparties.site/");
    }
    @Step("Получаем login page")
    public boolean successButtonExitLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));
        return driver.getCurrentUrl().equals("https://stellarburgers.nomoreparties.site/login");
    }

    @Step("Кликаем на личный кабинет")
    public LoginPage clickAccountButton() {
        driver.findElement(ACCOUNT).click();
        return this;
    }

    @Step("Кликаем войти в аккаунт")
    public LoginPage clickEnterAccountButton() {
        driver.findElement(ENTER_ACCOUNT).click();
        return this;
    }

    @Step("Кликаем на кнопку региcтрации")
    public LoginPage clickRegisterButton() {
        driver.findElement(REGISTER).click();
        return this;
    }

    @Step("Кликаем кнопку войти")
    public LoginPage clickEnterButtonRegistrationForm() {
        driver.findElement(ENTER_BUTTON).click();
        return this;
    }

    @Step("Кликаем кнопку восстановить пароль")
    public LoginPage clickEnterButtonPasswordRecovery() {
        driver.findElement(PASSWORD_RECOVERY).click();
        return this;
    }

    @Step("Вводим email")
    public LoginPage clickEmail(String email) {
        driver.findElement(EMAIL).click();
        driver.findElement(EMAIL).sendKeys(email);
        return this;
    }
    @Step("Вводим пароль")
    public LoginPage clickPassword(String password) {
        driver.findElement(PASSWORD).click();
        driver.findElement(PASSWORD).sendKeys(password);
        return this;
    }
    @Step("Кликаем на кнопку войти")
    public LoginPage clickEnterButton() {
        driver.findElement(ENTER).click();
        return this;
    }

    @Step("Логин пользователя на главной странице")
    public void ofMainPage(String email, String password) {
        clickEnterAccountButton();
        clickEmail(email);
        clickPassword(password);
        clickEnterButton();
    }

    @Step("Логин пользователя через личный кабинет")
    public void personalAccount(String email, String password) {
        clickAccountButton();
        clickEmail(email);
        clickPassword(password);
        clickEnterButton();
    }
    @Step("Логин пользователя через форму регистрации")
    public void registrationForm(String email, String password) {
        clickAccountButton();
        clickRegisterButton();
        clickEnterButtonRegistrationForm();
        clickEmail(email);
        clickPassword(password);
        clickEnterButton();
    }
    @Step("Логин пользователя через форму востановления пароля")
    public void passwordRecovery(String email, String password) {
        clickAccountButton();
        clickEnterButtonPasswordRecovery();
        clickEnterButtonRegistrationForm();
        clickEmail(email);
        clickPassword(password);
        clickEnterButton();
    }
}
