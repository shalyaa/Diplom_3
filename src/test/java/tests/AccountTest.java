package tests;

import api.client.UserClient;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import pages.*;

import static api.client.UserClient.*;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class AccountTest extends BaseTest {

    @Before
    public void setup() {
        open(LoginPage.ROOT_URL, LoginPage.class);
        user = user.getRandomUser();
        userClient = new UserClient();
        responseCreate = createUser(user);
        loginPage.fillRegistrationFields(user);
        loginPage.clickLoginButton();
    }

    @After
    public void tearDown() {
        if (responseCreate.statusCode() == 200) {
            accessToken = getAccessToken(responseCreate);
            userClient.deleteUser(accessToken);
        }
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    public void goToAccountTest() {
        mainPage.clickAccountButton();

        assertTrue("Переход в личный кабинет не сработал", accountPage.checkLogoutButton());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на кнопку «Конструктор»")
    public void clickConstructorButtonTest() {
        mainPage.clickAccountButton();
        accountPage.clickConstructorButton();

        assertTrue("Переход в конструктор не сработал", mainPage.checkCreateOrderButton());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип")
    public void clickLogoTest() {
        mainPage.clickAccountButton();
        accountPage.clickLogo();

        assertTrue("Переход в конструктор не сработал", mainPage.checkCreateOrderButton());
    }

    @Test
    @DisplayName("Выход из личного кабинета")
    public void logoutTest() {
        mainPage.clickAccountButton();
        accountPage.logoutAccount();

        assertTrue("Выход из личного кабинета не сработал", loginPage.checkLoginButton());
    }
}
