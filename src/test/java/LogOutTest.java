import config.GenerateUserData;
import config.UserAPI;
import config.YandexBrowser;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObject.LogIn;
import pageObject.MainPage;
import pageObject.Profile;

import static com.codeborne.selenide.Selenide.open;
import static config.URL.MAIN_PAGE;
import static config.UserAPI.token;

@DisplayName("Выход из аккаунта")
public class LogOutTest extends YandexBrowser {
    Profile profile;
    LogIn logIn;
    MainPage mainPage;
    GenerateUserData generateUserData;
    ValidatableResponse response;

    @Before
    @DisplayName("Открытие сайта / генерация данных пользователя / авторизация пользователя")
    public void setUp() {
        setYandexBrowser();
        mainPage = new MainPage();
        profile = new Profile();
        logIn = new LogIn();

        open(MAIN_PAGE);
        generateUserData = GenerateUserData.generateUser();
        response = UserAPI.createNewUser(generateUserData);
        mainPage.clickLogInAccountButton();
        logIn.setEmailField(generateUserData.getEmail());
        logIn.setPasswordField(generateUserData.getPassword());
        logIn.clickLogInButton();

    }

    @Test
    @DisplayName("Выход из аккаунта")
    public void logInForgotPasswordPageTest() {
        mainPage.clickLKButton();
        profile.clickLogOutButton();
        logIn.isDisplayedGetLogInButton();
    }

    @After
    @DisplayName("Удаление пользователя")
    public void deleteData() {
        UserAPI.deleteUser(response.extract().path(token).toString());
    }

}


