import config.YandexBrowser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageObject.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static config.URL.MAIN_PAGE;

@DisplayName("Переключение вкладок конструктора")
public class ConstructorTest extends YandexBrowser {
    MainPage mainPage;

    @Before
    public void setUp() {
        setYandexBrowser();
        open(MAIN_PAGE);
        mainPage = new MainPage();
    }

    @Test
    @DisplayName("Переключение на вкладку Соусы")
    public void sauceTabSwitch() {
        mainPage.clickSaucesTab();
        Assert.assertEquals("Соусы", mainPage.getCurrentTab());
    }

    @Test
    @DisplayName("Переключение на вкладку Булки")
    public void bunTabSwitch() {
        mainPage.clickFillingTab();
        mainPage.clickBunTab();
        Assert.assertEquals("Булки", mainPage.getCurrentTab());
    }

    @Test
    @DisplayName("Переключение на вкладку Начинки")
    public void fillingTabSwitch() {
        mainPage.clickFillingTab();
        Assert.assertEquals("Начинки", mainPage.getCurrentTab());
    }
}
