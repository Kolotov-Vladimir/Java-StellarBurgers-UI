package config;

import com.codeborne.selenide.Configuration;


public class YandexBrowser {
    public static String setProperty() {
        return System.setProperty("webdriver.chrome.driver", "/WebDriver/bin/chromedriver.exe");
    }

    public static String browser() {
        return Configuration.browserBinary = "C:\\Users\\RVL\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe";
    }

    public void setYandexBrowser() {
        setProperty();
        browser();
    }

}
