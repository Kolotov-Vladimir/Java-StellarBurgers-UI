import config.GenerateUserData;
import config.UserAPI;
import config.YandexBrowser;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObject.Registration;

import static com.codeborne.selenide.Selenide.open;
import static config.URL.REGISTER_PAGE;
import static config.UserAPI.token;

@DisplayName("Регистрация пользователя")
public class RegistrationTest extends YandexBrowser {
    Registration registration;
    GenerateUserData generateUserData;

    @Before
    @DisplayName("Открытие сайта / генерация данных пользователя")
    public void setUp() {
        setYandexBrowser();
        registration = new Registration();
        open(REGISTER_PAGE);
        generateUserData = GenerateUserData.generateUser();
    }

    @Test
    @DisplayName("Заполнение данных пользователя и нажатие на кнопку 'Зарегистрироваться'")
    public void registrationValidTest() {
        registration.setNameField(generateUserData.getName());
        registration.setPasswordField(generateUserData.getPassword());
        registration.setEmailField(generateUserData.getEmail());
        registration.clickRegistrationButton();
    }

    @After
    @DisplayName("Удаление пользователя")
    public void deleteUser() {

        ValidatableResponse loginResponse = UserAPI.userAuthorization(new GenerateUserData(generateUserData.getEmail(), generateUserData.getPassword()));
        UserAPI.deleteUser(loginResponse.extract().path(token).toString());

    }
}
