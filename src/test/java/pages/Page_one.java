package pages;

import pages.components.Calender_Component;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class Page_one {

    Calender_Component calender_component = new Calender_Component();
    public Page_one openPage() {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }
    public Page_one setFirstName(String value) {
        $("#firstName").setValue(value);

        return this;
    }
    public Page_one setLastName(String value) {
        $("#lastName").setValue(value);

        return this;
    }
    public Page_one setEmail(String value) {
        $("#userEmail").setValue("dart@tester.com");

        return this;
    }
    public Page_one setGender(String value) {
        $("#genterWrapper").$(byText("Other")).click();

        return this;
    }public Page_one setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calender_component.setDate(day, month, year);

        return this;
    }
}
