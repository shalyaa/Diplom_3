package tests;

import api.client.UserClient;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import pages.*;

import static api.client.UserClient.*;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Before
    public void setup() {
        open(MainPage.ROOT_URL, MainPage.class);
        user = user.getRandomUser();
        userClient = new UserClient();
        responseCreate = createUser(user);
    }

    @After
    public void tearDown() {
        if (responseCreate.statusCode() == 200) {
            accessToken = getAccessToken(responseCreate);
            userClient.deleteUser(accessToken);
        }
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginWithLoginButtonTest() {
        mainPage.clickLoginButton();
        loginPage.fillRegistrationFields(user);
        loginPage.clickLoginButton();

        assertTrue("Не удалось войти в аккаунт", mainPage.checkCreateOrderButton());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginWithAccountButtonTest() {
        mainPage.clickAccountButton();
        loginPage.fillRegistrationFields(user);
        loginPage.clickLoginButton();

        assertTrue("Не удалось войти в аккаунт", mainPage.checkCreateOrderButton());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginThroughRegPageTest() {
        open(RegistrationPage.ROOT_URL, RegistrationPage.class);
        registrationPage.goToLoginPage();
        loginPage.fillRegistrationFields(user);
        loginPage.clickLoginButton();

        assertTrue("Не удалось войти в аккаунт", mainPage.checkCreateOrderButton());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginThroughRestorePassPageTest() {
        open(RestorePasswordPage.ROOT_URL, RestorePasswordPage.class);
        restorePasswordPage.goToLoginPage();
        loginPage.fillRegistrationFields(user);
        loginPage.clickLoginButton();

        assertTrue("Не удалось войти в аккаунт", mainPage.checkCreateOrderButton());
    }
}
