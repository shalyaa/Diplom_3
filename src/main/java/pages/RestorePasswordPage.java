package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RestorePasswordPage {

    public final static String ROOT_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    @FindBy(how = How.XPATH, using = ("//a[text()='Войти']"))
    private SelenideElement loginButton;

    @Step("Клик по кнопке «Войти»")
    public LoginPage goToLoginPage() {
        loginButton.click();
        return page(LoginPage.class);
    }
}
