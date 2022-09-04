package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class AccountPage {

    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    @FindBy(how = How.CLASS_NAME, using = ("AppHeader_header__logo__2D0X2"))
    private SelenideElement logo;

    @FindBy(how = How.XPATH, using = ("//button[text()='Выход']"))
    private SelenideElement logoutButton;

    @Step("Клик по кнопке «Конструктор»")
    public MainPage clickConstructorButton() {
        constructorButton.click();
        return page(MainPage.class);
    }

    @Step("Клик по лого")
    public MainPage clickLogo() {
        logo.click();
        return page(MainPage.class);
    }

    @Step("Клик по кнопке «Выход»")
    public LoginPage logoutAccount() {
        logoutButton.click();
        return page(LoginPage.class);
    }

    @Step("Проверка отображения кнопки «Выход»")
    public boolean checkLogoutButton() {
        logoutButton.shouldBe(visible);
        return true;
    }
}
