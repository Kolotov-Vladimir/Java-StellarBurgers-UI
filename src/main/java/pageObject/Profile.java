package pageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Profile {
    SelenideElement logOutButton = $(By.xpath("//button[text()='Выход']"));
    SelenideElement lkButton = $(By.xpath("//p[text()='Личный Кабинет']"));

    @Step("Клик по кнопке 'Личный кабинет'")
    public void clickLKButton() {
        lkButton.click();
    }

    @Step("Клик по кнопке 'Выход'")
    public void clickLogOutButton() {
        logOutButton.click();
    }
}
