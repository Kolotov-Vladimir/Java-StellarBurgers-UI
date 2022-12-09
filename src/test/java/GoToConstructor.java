import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import config.YandexBrowser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageObject.LogIn;

import static com.codeborne.selenide.Selenide.open;
import static config.URL.LOGIN_PAGE;
import static config.URL.MAIN_PAGE;

@DisplayName("Переход из личного кабинета в конструктор")
public class GoToConstructor extends YandexBrowser {
    LogIn logIn;

    @Before
    public void setUP() {
        setYandexBrowser();
        logIn = new LogIn();
    }

    @Test
    @DisplayName("Переход по клику в «Конструктор» из личного кабинета")
    public void goToLKLogInPageTest() {

        open(LOGIN_PAGE);
        logIn.clickLConstructorButton();
        Assert.assertEquals("Ошибка перехода в «Конструктор» из личного кабинета", MAIN_PAGE, WebDriverRunner.url());
    }
}
