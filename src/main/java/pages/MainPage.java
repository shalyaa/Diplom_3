package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    public final static String ROOT_URL = "https://stellarburgers.nomoreparties.site";

    private void open() {
        Selenide.open(ROOT_URL);
    }

    @FindBy(how = How.XPATH, using = ("//button[text()='Войти в аккаунт']"))
    private SelenideElement loginButton;

    @FindBy(how = How.XPATH, using = ("//p[text()='Личный Кабинет']"))
    private SelenideElement accountButton;

    @FindBy(xpath = "//button[text() = 'Оформить заказ']")
    private SelenideElement createOrderButton;

    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    @FindBy(how = How.CLASS_NAME, using = ("AppHeader_header__logo__2D0X2"))
    private SelenideElement logo;

    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunsButton;

    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement saucesButton;

    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement ingredientsButton;

    @FindBy(how = How.XPATH, using = ("//h2[text()='Булки']"))
    private SelenideElement bunsTitle;

    @FindBy(how = How.XPATH, using = ("//h2[text()='Соусы']"))
    private SelenideElement saucesTitle;

    @FindBy(how = How.XPATH, using = ("//h2[text()='Начинки']"))
    private SelenideElement ingredientsTitle;

    @FindBy(how = How.XPATH, using = ("//div/ul[1]"))
    private SelenideElement bunsList;

    @FindBy(how = How.XPATH, using = ("//div/ul[2]"))
    private SelenideElement saucesList;

    @FindBy(how = How.XPATH, using = ("//div/ul[3]"))
    private SelenideElement ingredientsList;

    @Step("Клик на кнопку «Войти в аккаунт»")
    public LoginPage clickLoginButton() {
        loginButton.click();
        return page(LoginPage.class);
    }

    @Step("Клик на кнопку «Личный кабинет»")
    public LoginPage clickAccountButton() {
        accountButton.click();
        return page(LoginPage.class);
    }

    @Step("Проверка отображения кнопки «Оформить заказ»")
    public boolean checkCreateOrderButton() {
        createOrderButton.shouldBe(visible);
        return true;
    }

    @Step("Переход в раздел «Булки»")
    public void clickBunsButton() {
        bunsButton.click();
    }

    @Step("Переход в раздел «Соусы»")
    public void clickSaucesButton() {
        saucesButton.click();
    }

    @Step("Переход в раздел «Ингредиенты»")
    public void clickIngredientsButton() {
        ingredientsButton.click();
    }

    @Step("Проверка перехода к списку «Булки»")
    public boolean checkBuns() {
        Selenide.sleep(1000);
        bunsTitle.shouldBe(visible);
        bunsList.shouldBe(visible);
        return true;
    }

    @Step("Проверка перехода к списку «Соусы»")
    public boolean checkSauces() {
        Selenide.sleep(1000);
        saucesTitle.shouldBe(visible);
        saucesList.shouldBe(visible);
        return true;
    }

    @Step("Проверка перехода к списку «Ингредиенты»")
    public boolean checkIngredients() {
        Selenide.sleep(1000);
        ingredientsTitle.shouldBe(visible);
        ingredientsList.shouldBe(visible);
        return true;
    }
}
