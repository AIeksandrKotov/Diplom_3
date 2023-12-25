package user;
import base.BaseTest;
import io.qameta.allure.junit4.DisplayName;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageStep.LoginPage;
import pageStep.OtherStep;

public class OtherTest extends  BaseTest {
    private CreateUser createUser;
    private UserStep userStep;
    private LoginPage loginPage;
    private OtherStep otherStep;

    @Before
    public void SetUp() {
        createUser = UserRandom.getUserRandom();
        otherStep = new OtherStep(driver);
        loginPage = new LoginPage(driver);
        userStep = new UserStep();
        userStep.registerUser(createUser);
    }


    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    public void crossing() {
        otherStep.clickAccountButton();
        otherStep.clickConstructor();
        Assert.assertTrue("Получаем main page", loginPage.successLogin());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор и кликаем на логотип Stellar Burgers")
    public void crossingLogo() {
        otherStep.clickAccountButton();
        otherStep.clickConstructor();
        otherStep.clickLogo();
        Assert.assertTrue("Получаем main page", loginPage.successLogin());
    }

    @Test
    @DisplayName("Проверяем кнопку выход в личном кабинете")
    public void crossingExit() {
        loginPage.ofMainPage(createUser.getEmail(), createUser.getPassword());
        otherStep.clickAccountButton();
        otherStep.clickAccountExit();
        Assert.assertTrue("Получаем login page", loginPage.successButtonExitLogin());
    }

    @Test
    public void SelectBuns(){
        otherStep.clickSauces();
        otherStep.clickBuns();
        otherStep.selectBuns();
        Assert.assertTrue("Булочки выбраны", otherStep.selectBuns());
    }

    @Test
    public void SelectSauces(){
        otherStep.clickSauces();
        otherStep.selectSauce();
        Assert.assertTrue("Соусы выбраны", otherStep.selectSauce());
    }

    @Test
    public void SelectFillings(){
        otherStep.clickFilling();
        otherStep.selectFillings();
        Assert.assertTrue("Начинки выбраны", otherStep.selectFillings());
    }
}

