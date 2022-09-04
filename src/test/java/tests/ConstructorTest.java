package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    @Before
    public void setup() {
        open(MainPage.ROOT_URL, MainPage.class);
    }

    @Test
    @DisplayName("Переход в раздел «Булки»")
    public void goToBunsTest() {
        mainPage.clickSaucesButton();
        assertTrue("Переход в раздел «Соусы» не сработал", mainPage.checkSauces());
        mainPage.clickBunsButton();

        assertTrue("Переход в раздел «Булки» не сработал", mainPage.checkBuns());
    }

    @Test
    @DisplayName("Переход в раздел «Соусы»")
    public void goToSaucesTest() {
        mainPage.clickSaucesButton();

        assertTrue("Переход в раздел «Соусы» не сработал", mainPage.checkSauces());
    }

    @Test
    @DisplayName("Переход в раздел «Ингредиенты»")
    public void goToIngredientsTest() {
        mainPage.clickIngredientsButton();

        assertTrue("Переход в раздел «Ингредиенты» не сработал", mainPage.checkIngredients());
    }
}
