package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class LogIn {

    SelenideElement emailField = $(By.xpath(".//fieldset[1]//input"));
    SelenideElement passwordField = $(By.xpath(".//fieldset[2]//input"));
    SelenideElement logInButton = $(By.xpath("//button[text()='Войти']"));
    SelenideElement lkButton = $(By.xpath("//p[text()='Личный Кабинет']"));
    SelenideElement constructorButton = $(By.xpath("//p[text()='Конструктор']"));

    @Step("Ввод значения в поле 'Email'")
    public void setEmailField(String email) {
        emailField.setValue(email);
    }

    @Step("Ввод значения в поле 'Пароль'")
    public void setPasswordField(String password) {
        passwordField.setValue(password);
    }

    @Step("Клик по кнопке 'Войти'")
    public void clickLogInButton() {
        logInButton.click();
    }
    @Step("Кнопка 'Оформить заказ' отображается")
    public boolean isDisplayedGetLogInButton() {
        return logInButton.isDisplayed();
    }
    @Step("Клик по кнопке 'Личный кабинет'")
    public void clickLKButton() {
        lkButton.click();
    }
    @Step("Клик по кнопке 'Конструктор'")
    public void clickLConstructorButton() {
        constructorButton.click();
    }

}
