import config.GenerateUserData;
import config.UserAPI;
import config.YandexBrowser;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageObject.Registration;

import static com.codeborne.selenide.Selenide.open;
import static config.URL.REGISTER_PAGE;
import static config.UserAPI.token;

@DisplayName("При регистрации с паролем менее 6-ти символов, отображается сообщение 'Некорректный пароль'")
@RunWith(Parameterized.class)
public class PasswordTest extends YandexBrowser {
    private final String pass;
    private final boolean expected;
    Registration registration;

    GenerateUserData generateUserData;

    public PasswordTest(String pass, boolean expected) {
        this.pass = pass;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Проверяемый пароль: {0}, отображение ошибки: {1}")
    public static Object[][] testPassword() {
        return new Object[][]{
                {RandomStringUtils.randomAlphabetic(0), false},
                {RandomStringUtils.randomAlphabetic(1), true},
                {RandomStringUtils.randomAlphabetic(2), true},
                {RandomStringUtils.randomAlphabetic(3), true},
                {RandomStringUtils.randomAlphabetic(4), true},
                {RandomStringUtils.randomAlphabetic(5), true},
                {RandomStringUtils.randomAlphabetic(6), false}};
    }

    @Before
    @DisplayName("Открытие сайта / генерация данных пользователя")
    public void setUp() {
        setYandexBrowser();
        registration = new Registration();
        open(REGISTER_PAGE);
        generateUserData = GenerateUserData.generateUser();
    }

    @Test
    @DisplayName("Заполнение поля 'Пароль' менее 6-ти символов")
    public void registrationNoValidPasswordTest() {
        generateUserData.setPassword(pass);
        registration.setPasswordField(generateUserData.getPassword());
        registration.setNameField(generateUserData.getName());
        registration.setEmailField(generateUserData.getEmail());
        Boolean actual = registration.getInvalidPasswordError();
        Assert.assertEquals(expected, actual);

    }

    @After
    @DisplayName("Удаление пользователя в случае бага")
    public void deleteUser() {
        ValidatableResponse loginResponse = UserAPI.userAuthorization(new GenerateUserData(generateUserData.getEmail(), generateUserData.getPassword()));
        if (loginResponse.extract().body().path("success").equals(true)) {
            UserAPI.deleteUser(loginResponse.extract().path(token).toString());
        }
    }
}
