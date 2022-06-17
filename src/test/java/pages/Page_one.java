package pages;

import pages.components.Calender_Component;
import pages.components.City_Component;
import pages.components.ResultsTable_Component;
import pages.components.State_Component;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class Page_one {

    Calender_Component calender_component = new Calender_Component();
    ResultsTable_Component resultsTable_component = new ResultsTable_Component();
    State_Component state_component = new State_Component();
    City_Component city_component = new City_Component();
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
    }
    public Page_one setNumber(String value) {
        $("#userNumber").setValue("81233212112");

        return this;
    }
    public Page_one setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calender_component.setDate(day, month, year);

        return this;
    }
    public Page_one setSubject(String value) {
        $("#subjectsInput").sendKeys("Maths");
        $("#subjectsInput").pressEnter();

        return this;
    }
    public Page_one setHobbies(String value) {
        $("#hobbiesWrapper").$(byText("Sports")).click();

        return this;
    }
    public Page_one setPicture(String value) {
        $("#uploadPicture").uploadFromClasspath("pic.png");

        return this;
    }
    public Page_one setAddress(String value) {
        $("#currentAddress").setValue("Address1");

        return this;
    }
    public Page_one setState(String value) {
        $("#state").click();
        state_component.setState(value);

        return this;
    }
    public Page_one setCity(String value) {
        $("#city").click();
        city_component.setCity(value);

        return this;
    }
    public Page_one clickSubmit() {
        $("#submit").click();

        return this;
    }
    public Page_one checkFormOpened(String value) {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    public Page_one checkResult (String key, String value) {
        resultsTable_component.checkResult(key, value);

        return this;
    }


}
