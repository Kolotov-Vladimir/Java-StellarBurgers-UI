package config;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static config.URL.*;

public class UserAPI {
    public static final String token = "accessToken";
    @Step("Создание пользователя")
    public static ValidatableResponse createNewUser(GenerateUserData body) {
        return RestAssured.given()
                .spec(getDefaultRequestSpec())
                .body(body)
                .when()
                .post(AUTH_REGISTER)
                .then().log().ifError();
    }

    @Step("Базовая конфигурация запроса")
    public static RequestSpecification getDefaultRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON)
                .build();
    }

    @Step("Авторизация пользователя")
    public static ValidatableResponse userAuthorization(GenerateUserData body) {
        return RestAssured.given()
                .spec(getDefaultRequestSpec())
                .body(body)
                .when()
                .post(AUTH_LOGIN)
                .then().log().ifError();
    }

    @Step("Удаление пользователя")
    public static ValidatableResponse deleteUser(String accessToken) {
        return RestAssured.given()
                .spec(getDefaultRequestSpec())
                .header("Authorization", accessToken)
                .when()
                .delete(AUTH_USER)
                .then().log().ifError();
    }
}
