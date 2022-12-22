import config.GenerateUserData;
import config.UserAPI;
import config.YandexBrowser;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObject.ForgotPassword;
import pageObject.LogIn;
import pageObject.MainPage;
import pageObject.Registration;

import static com.codeborne.selenide.Selenide.open;
import static config.URL.*;
import static config.UserAPI.token;

@DisplayName("Авторизация пользователя")
public class LogInTest extends YandexBrowser {
    LogIn logIn;
    MainPage mainPage;
    Registration registration;
    ForgotPassword forgotPassword;
    GenerateUserData generateUserData;
    ValidatableResponse response;

    @Before
    @DisplayName("Регистрация пользователя")
    public void setUp() {
        setYandexBrowser();
        logIn = new LogIn();
        mainPage = new MainPage();
        registration = new Registration();
        forgotPassword = new ForgotPassword();
        generateUserData = GenerateUserData.generateUser();
        response = UserAPI.createNewUser(generateUserData);
    }

    @Test
    @DisplayName("Авторизация пользователя по кнопке 'Войти в аккаунт' на главной странице")
    public void logInMainPageTest() {
        open(MAIN_PAGE);
        mainPage.clickLogInAccountButton();
        logIn.setEmailField(generateUserData.getEmail());
        logIn.setPasswordField(generateUserData.getPassword());
        logIn.clickLogInButton();
        mainPage.isDisplayedGetOrderButton();
    }

    @Test
    @DisplayName("Авторизация пользователя по кнопке 'Личный кабинет' на главной странице")
    public void LKMainPageTest() {
        open(MAIN_PAGE);
        mainPage.clickLKButton();
        logIn.setEmailField(generateUserData.getEmail());
        logIn.setPasswordField(generateUserData.getPassword());
        logIn.clickLogInButton();
        mainPage.isDisplayedGetOrderButton();
    }

    @Test
    @DisplayName("Авторизация пользователя по кнопке 'Войти' на странице регистрации")
    public void logInRegistrationPageTest() {
        open(REGISTER_PAGE);
        registration.clickLogInButton();
        logIn.setEmailField(generateUserData.getEmail());
        logIn.setPasswordField(generateUserData.getPassword());
        logIn.clickLogInButton();
        mainPage.isDisplayedGetOrderButton();
    }

    @Test
    @DisplayName("Авторизация пользователя по кнопке 'Войти' на странице восстановления пароля")
    public void logInForgotPasswordPageTest() {
        open(FORGOT_PASSWORD_PAGE);
        forgotPassword.clickLogInButton();
        logIn.setEmailField(generateUserData.getEmail());
        logIn.setPasswordField(generateUserData.getPassword());
        logIn.clickLogInButton();
        mainPage.isDisplayedGetOrderButton();
    }

    @After
    @DisplayName("Удаление пользователя")
    public void deleteData() {
        UserAPI.deleteUser(response.extract().path(token).toString());
    }
}
