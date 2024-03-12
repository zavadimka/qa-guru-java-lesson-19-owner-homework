package com.zavadimka;

import com.zavadimka.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Simple tests")
public class SimpleTest extends TestBase {

    @Test
    @DisplayName("Simple parametrized test with different WebDrivers destination")
    void simpleTest() {

        MainPage mainPage = new MainPage();

        mainPage.openPage();
        mainPage.checkTitle();
    }
}
