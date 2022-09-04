package pages;

import api.model.User;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {

    public final static String ROOT_URL = "https://stellarburgers.nomoreparties.site/register";

    @FindBy(how = How.XPATH, using = ".//fieldset[1]//input")
    private SelenideElement nameInput;

    @FindBy(how = How.XPATH, using = ".//fieldset[2]//input")
    private SelenideElement emailInput;

    @FindBy(how = How.NAME, using = "Пароль")
    private SelenideElement passwordInput;

    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement regButton;

    @FindBy(how = How.XPATH, using = ("//p[text()='Некорректный пароль']"))
    private SelenideElement wrongPasswordError;

    @FindBy(xpath = ".//a[contains(text(),'Войти')]")
    private SelenideElement loginButton;

    @Step("Заполнение полей регистрации")
    public void fillRegistrationFields(User user) {
        nameInput.setValue(user.getName());
        emailInput.setValue(user.getEmail());
        passwordInput.setValue(user.getPassword());
    }

    @Step("Клик по кнопке «Зарегистрироваться»")
    public LoginPage clickRegistrationButton() {
        regButton.click();
        return page(LoginPage.class);
    }

    @Step("Проверка отображения ошибки при неправильном пароле")
    public boolean wrongPasswordError() {
        wrongPasswordError.shouldBe(visible).shouldHave(Condition.ownText("Некорректный пароль"));
        return true;
    }

    @Step("Клик по кнопке «Войти»")
    public LoginPage goToLoginPage() {
        loginButton.click();
        return page(LoginPage.class);
    }
}
