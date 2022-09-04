package tests;

import api.client.UserClient;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import pages.RegistrationPage;

import static api.client.UserClient.getAccessToken;
import static org.junit.Assert.assertTrue;


public class RegistrationTest extends BaseTest {

    @Before
    public void setup() {
        user = user.getRandomUser();
        userClient = new UserClient();
        Selenide.open(RegistrationPage.ROOT_URL, RegistrationPage.class);
    }

    @After
    public void tearDown() {
        if (userClient.authUser(user).statusCode() == 200) {
            accessToken = getAccessToken(userClient.authUser(user));
            userClient.deleteUser(accessToken);
        }
    }

    @Test
    @DisplayName("Регистрация пользователя")
    public void registrationTest() {
        registrationPage.fillRegistrationFields(user);
        registrationPage.clickRegistrationButton();

        assertTrue("Не удалось зарегистрировать пользователя", loginPage.checkLoginButton());
    }

    @Test
    @DisplayName("Проверка ограничения пароля - минимум 6 символов")
    public void registrationWithInvalidTest() {
        user.setPassword(RandomStringUtils.randomAlphabetic(5));
        registrationPage.fillRegistrationFields(user);
        registrationPage.clickRegistrationButton();

        assertTrue("Ожидаемая ошибка не появилась", registrationPage.wrongPasswordError());
    }
}
