package com.zavadimka.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    SelenideElement titleElement = $(".h0-mktg span");
    String title = "Let’s build from here";

    @Step("Open page")
    public void openPage(){
        open("/");
    }

    @Step("Check title")
    public void checkTitle(){
        titleElement.shouldBe(visible)
                .shouldHave(text(title));
    }
}
