package user;

import base.BaseTest;
import io.qameta.allure.junit4.DisplayName;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageStep.BasePage;
import pageStep.RegisterPage;


public class RegisterPageTest extends BaseTest {
    private RegisterPage registerPage;
    private CreateUser createUser;


    @Before
    public void SetUp() {
        createUser = UserRandom.getUserRandom();
        registerPage = new RegisterPage(driver);
    }

    @Test
    @DisplayName("Регистрируем пользователя")
    public void register() {
        registerPage.register(createUser.getName(), createUser.getEmail(), createUser.getPassword());
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/login", registerPage.successRegister());
    }

    @Test
    @DisplayName("Регистрируем пользователя с неверным паролем")
    public void registerError() {
        registerPage.register(createUser.getName(), createUser.getEmail(), "01234");
        Assert.assertEquals("Некорректный пароль", registerPage.errorText());
    }
}
