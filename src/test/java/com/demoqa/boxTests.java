package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

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

        // Text
        $("[id=firstName]").setValue("Daniil");
        $("[id=lastName]").setValue("Davydov");
        $("[id=userEmail]").setValue("da@da.ru");

        // Radio-button
        $("[for='gender-radio-1']").click(); //$(byText("Male")).click(); - аналогично
        $("[id=userNumber]").setValue("0123456789");

        // Date
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1993");
        $(".react-datepicker__day--010:nth-child(3)").click();

        // Text
        $("#subjectsInput").sendKeys("Maths");
        $("#subjectsInput").pressEnter();

        // Check-box
        $("[for='hobbies-checkbox-1']").click(); // $(byText("Sports")).click(); - аналогично
        $("[for='hobbies-checkbox-2']").click();
        $("[for='hobbies-checkbox-3']").click();

        // Picture
        $("#uploadPicture").uploadFile (new File("src/test/resources/pic.png"));

        // Text
        $("[id=currentAddress]").setValue("Adress");

        // Drop-down list
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();

        $("[id=submit]").click();

        // Result:
        $(".modal-body").shouldHave(text("Daniil Davydov"),
                text("da@da.ru"),
                text("Male"),
                text("0123456789"),
                text("10 August,1993"),
                text("Maths"),
                text("Sports, Reading, Music"),
                text("pic.png"),
                text("Adress"),
                text("NCR Delhi")
        );
    }
}
