package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    SelenideElement orderButton = $(By.xpath("//button[text() = 'Оформить заказ']"));
    SelenideElement logInAccountButton = $(By.xpath("//button[text()='Войти в аккаунт']"));
    SelenideElement lkButton = $(By.xpath("//p[text()='Личный Кабинет']"));
    SelenideElement sauceSection = $(By.xpath("//div/span[text()='Соусы']"));
    SelenideElement fillingSection = $(By.xpath("//div/span[text()='Начинки']"));
    SelenideElement bunSection = $(By.xpath("//div/span[text()='Булки']"));
    SelenideElement currentSection = $(By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span"));
    @Step("Кнопка 'Оформить заказ' отображается")
    public boolean isDisplayedGetOrderButton() {
        orderButton.shouldBe(Condition.visible, Duration.ofSeconds(5));
        return orderButton.isDisplayed();
    }
    @Step("Клик по кнопке 'Войти в аккаунт'")
    public void clickLogInAccountButton() {
        logInAccountButton.click();
    }

    @Step("Клик по кнопке 'Личный кабинет'")
    public void clickLKButton() {
        lkButton.click();
    }
    @Step("Клик на раздел Булки")
    public void clickBunTab() {
        bunSection.click();
    }
    @Step("Клик на раздел Соусы")
    public void clickSaucesTab() {
        sauceSection.click();
    }

    @Step("Клик на раздел Начинки")
    public void clickFillingTab() {
        fillingSection.click();
    }
    @Step("Получить название активного раздела ингредиентов")
    public String getCurrentTab() {
        return currentSection.getText();
    }

}
