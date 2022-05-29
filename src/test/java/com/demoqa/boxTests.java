package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class boxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void successfulTest() {
        String name = "Alex";

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("[id=firstName]").setValue("Daniil");
        $("[id=lastName]").setValue("Davydov");
        $("[id=userEmail]").setValue("da@da.ru");
        $(byText("Male")).click();
        $("[id=userNumber]").setValue("0123456789");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--010:nth-child(3)").click();
        $("#subjectsInput").setValue("Physics").pressEnter();

        $("[id=currentAddress]").setValue("Adress");
        $("[id=submit]").click();

        $("[id=output]").shouldHave(text(name), text("alex@egorov.com"),
                text("Some address 1"), text("Another address 2"));
    }
}
