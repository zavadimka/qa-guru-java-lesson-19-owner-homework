package com.zavadimka;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.zavadimka.config.DriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    private WebDriver driver;

    @BeforeAll
    static void beforeAll(){
        getDestination();
        createDriverConfig(System.getProperty("destination"));
    }

    @BeforeEach
    void beforeEach() {
        // Подключаем логгер и добавляем слушателя
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    public static void getDestination() {
        String destination = System.getProperty("destination", "remote");
        System.setProperty("destination", destination);
    }

    public static void createDriverConfig(String destination){
        DriverConfig driverConfig = new DriverConfig(destination);

        Configuration.baseUrl = driverConfig.baseUrl;
        Configuration.browser = driverConfig.browserName;
        Configuration.browserSize = driverConfig.browserSize;
        Configuration.browserVersion = driverConfig.browserVersion;

        switch (destination) {
            case "remote": {
                Configuration.remote = driverConfig.remoteUrl;
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                        "enableVNC", true,
                        "enableVideo", true
                ));
                Configuration.browserCapabilities = capabilities;
            }
            case "local": {
                Configuration.pageLoadStrategy = "eager";
                Configuration.timeout = 10_000;
            }
        }

        driverConfig.printDriverConfig();
    }
}
