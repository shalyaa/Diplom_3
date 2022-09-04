package pages;

import api.model.User;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    public final static String ROOT_URL = "https://stellarburgers.nomoreparties.site/login";

    @FindBy(how = How.NAME, using = "name")
    private SelenideElement emailInput;

    @FindBy(how = How.NAME, using = "Пароль")
    private SelenideElement passwordInput;

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement loginButton;

    @Step("Заполнение полей авторизации")
    public void fillRegistrationFields(User user) {
        emailInput.setValue(user.getEmail());
        passwordInput.setValue(user.getPassword());
    }

    @Step("Клик по кнопке «Войти»")
    public MainPage clickLoginButton() {
        loginButton.click();
        return page(MainPage.class);
    }

    @Step("Проверка отображения кнопки «Войти»")
    public boolean checkLoginButton() {
        loginButton.shouldBe(visible);
        return true;
    }
}
