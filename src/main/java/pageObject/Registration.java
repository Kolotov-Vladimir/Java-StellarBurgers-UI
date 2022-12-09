package pageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Registration {

    SelenideElement registrationButton = $(By.className("button_button_size_medium__3zxIa"));
    SelenideElement nameField = $(By.xpath("//fieldset[1]/div/div/input"));
    SelenideElement emailField = $(By.xpath("//fieldset[2]/div/div/input"));
    SelenideElement passwordField = $(By.xpath("//fieldset[3]/div/div/input"));
    SelenideElement passwordError = $(By.xpath("//p[text()='Некорректный пароль']"));
    SelenideElement logInButton = $(By.xpath("//a[text()='Войти']"));
    SelenideElement lkButton = $(By.xpath("//p[text()='Личный Кабинет']"));

    @Step("Клик по кнопке 'Личный кабинет'")
    public void clickLKButton() {
        lkButton.click();
    }

    @Step("Ввод значения в поле 'Имя'")
    public void setNameField(String name) {
        nameField.setValue(name);
    }

    @Step("Ввод значения в поле 'Email'")
    public void setEmailField(String email) {
        emailField.setValue(email);
    }

    @Step("Ввод значения в поле 'Пароль'")
    public void setPasswordField(String password) {
        passwordField.setValue(password);
    }

    @Step("Клик по кнопке 'Зарегистрироваться'")
    public void clickRegistrationButton() {
        registrationButton.click();
    }

    @Step("Текст ошибки Неккоректный пароль")
    public Boolean getInvalidPasswordError() {
        return passwordError.exists();
    }

    @Step("Клик по кнопке 'Войти'")
    public void clickLogInButton() {
        logInButton.click();
    }

}
