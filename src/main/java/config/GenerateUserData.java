package config;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import lombok.Data;

@Data
public class GenerateUserData {
    private String email;
    private String password;
    private String name;
    public GenerateUserData() {
    }

    public GenerateUserData(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
    public GenerateUserData(String email, String password) {
        this.email = email;
        this.password = password;
    }
    @Step("Создание пользователя")
    public static GenerateUserData generateUser() {
        return new GenerateUserData(Faker.instance().internet().emailAddress(),
                Faker.instance().internet().password(),
                Faker.instance().name().firstName());
    }

}
