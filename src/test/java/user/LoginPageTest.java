package user;

import base.BaseTest;
import io.qameta.allure.junit4.DisplayName;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import page.LoginPage;


public class LoginPageTest extends BaseTest {
    private CreateUser createUser;
    private UserStep userStep;
    private LoginPage loginPage;


    @Before
    public void SetUp() {
        createUser = UserRandom.getUserRandom();
        loginPage = new LoginPage(driver);
        userStep = new UserStep();
        userStep.registerUser(createUser);
    }


    @Test
    @DisplayName("Логин пользователя на главной странице")
    public void loginOfMainPage() {
        loginPage.ofMainPage(createUser.getEmail(), createUser.getPassword());
        Assert.assertTrue("Получаем main page", loginPage.successLogin());
    }

    @Test
    @DisplayName("Логин пользователя через личный кабинет")
    public void loginPersonalAccount() {
        loginPage.personalAccount(createUser.getEmail(), createUser.getPassword());
        Assert.assertTrue("Получаем main page", loginPage.successLogin());
    }

    @Test
    @DisplayName("Логин пользователя через форму регистрации")
    public void loginRegistrationForm() {
        loginPage.registrationForm(createUser.getEmail(), createUser.getPassword());
        Assert.assertTrue("Получаем main page", loginPage.successLogin());
    }

    @Test
    @DisplayName("Логин пользователя через форму востановления пароля")
    public void loginPasswordRecovery() {
        loginPage.passwordRecovery(createUser.getEmail(), createUser.getPassword());
        Assert.assertTrue("Получаем main page", loginPage.successLogin());
    }
}