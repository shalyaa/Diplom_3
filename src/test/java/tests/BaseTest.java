package tests;

import api.client.UserClient;
import api.model.User;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.restassured.response.Response;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import pages.*;

import static com.codeborne.selenide.Selenide.page;

public abstract class BaseTest {

    User user;
    UserClient userClient;
    String accessToken;
    Response responseCreate;

    AccountPage accountPage = page(AccountPage.class);
    LoginPage loginPage = page(LoginPage.class);
    MainPage mainPage = page(MainPage.class);
    RegistrationPage registrationPage = page(RegistrationPage.class);
    RestorePasswordPage restorePasswordPage = page(RestorePasswordPage.class);

    @BeforeClass
    public static void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\yab\\yandexdriver.exe");
        //System.setProperty("selenide.browser", "chrome");
    }

    @AfterClass
    public static void closeBrowser() {
        Selenide.closeWindow();
    }
}
