import com.codeborne.selenide.WebDriverRunner;
import config.GenerateUserData;
import config.UserAPI;
import config.YandexBrowser;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageObject.*;

import static com.codeborne.selenide.Selenide.open;
import static config.URL.*;
import static config.UserAPI.token;

@DisplayName("Переход по клику на «Личный кабинет»")
public class GoToLKTest extends YandexBrowser {
    Profile profile;
    Feed feed;
    LogIn logIn;
    MainPage mainPage;
    Registration registration;
    ForgotPassword forgotPassword;
    GenerateUserData generateUserData;
    ValidatableResponse response;

    @Before
    public void setUP() {
        setYandexBrowser();
        profile = new Profile();
        feed = new Feed();
        logIn = new LogIn();
        mainPage = new MainPage();
        forgotPassword = new ForgotPassword();
        registration = new Registration();
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет» с главной страницы")
    public void goToLKMainPageTest() {
        open(MAIN_PAGE);
        mainPage.clickLKButton();
        Assert.assertEquals("Ошибка перехода в «Личный кабинет» с главной страницы", LOGIN_PAGE, WebDriverRunner.url());
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет» из личного кабинета")
    public void goToLKLogInPageTest() {
        open(LOGIN_PAGE);
        logIn.clickLKButton();
        Assert.assertEquals("Ошибка перехода в «Личный кабинет» из личного кабинета", LOGIN_PAGE, WebDriverRunner.url());
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет» из ленты заказов")
    public void goToLKFeedPageTest() {
        open(USER_FEED_PAGE);
        feed.clickLKButton();
        Assert.assertEquals("Ошибка перехода в «Личный кабинет» из ленты заказов", LOGIN_PAGE, WebDriverRunner.url());
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет» из формы регистрации")
    public void goToLKRegistrationPageTest() {
        open(REGISTER_PAGE);
        registration.clickLKButton();
        Assert.assertEquals("Ошибка перехода в «Личный кабинет» из формы регистрации", LOGIN_PAGE, WebDriverRunner.url());
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет» из формы восстановления пароля")
    public void goToLKForgotPasswordPageTest() {
        open(FORGOT_PASSWORD_PAGE);
        forgotPassword.clickLKButton();
        Assert.assertEquals("Ошибка перехода в «Личный кабинет» из формы восстановления пароля", LOGIN_PAGE, WebDriverRunner.url());
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет» из профиля пользователя")
    public void goToLKProfilePageTest() {
        open(LOGIN_PAGE);
        generateUserData = GenerateUserData.generateUser();
        response = UserAPI.createNewUser(generateUserData);
        logIn.setEmailField(generateUserData.getEmail());
        logIn.setPasswordField(generateUserData.getPassword());
        logIn.clickLogInButton();
        mainPage.clickLKButton();
        profile.clickLKButton();
        Assert.assertEquals("Ошибка перехода в «Личный кабинет» из профиля пользователя", USER_ACCOUNT_PAGE, WebDriverRunner.url());
        UserAPI.deleteUser(response.extract().path(token).toString());
    }
}
