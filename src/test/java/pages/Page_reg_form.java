package pages;

import pages.components.Calender_Component;
import pages.components.City_Component;
import pages.components.ResultsTable_Component;
import pages.components.State_Component;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class Page_reg_form {

    Calender_Component calender_component = new Calender_Component();
    ResultsTable_Component resultsTable_component = new ResultsTable_Component();
    State_Component state_component = new State_Component();
    City_Component city_component = new City_Component();
    public Page_reg_form openPage() {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }
    public Page_reg_form setFirstName(String value) {
        $("#firstName").setValue(value);

        return this;
    }
    public Page_reg_form setLastName(String value) {
        $("#lastName").setValue(value);

        return this;
    }
    public Page_reg_form setEmail(String value) {
        $("#userEmail").setValue("dart@tester.com");

        return this;
    }
    public Page_reg_form setGender(String value) {
        $("#genterWrapper").$(byText("Other")).click();

        return this;
    }
    public Page_reg_form setNumber(String value) {
        $("#userNumber").setValue("81233212112");

        return this;
    }
    public Page_reg_form setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calender_component.setDate(day, month, year);

        return this;
    }
    public Page_reg_form setSubject(String value) {
        $("#subjectsInput").sendKeys("Maths");
        $("#subjectsInput").pressEnter();

        return this;
    }
    public Page_reg_form setHobbies(String value) {
        $("#hobbiesWrapper").$(byText("Sports")).click();

        return this;
    }
    public Page_reg_form setPicture(String value) {
        $("#uploadPicture").uploadFromClasspath("pic.png");

        return this;
    }
    public Page_reg_form setAddress(String value) {
        $("#currentAddress").setValue("Address1");

        return this;
    }
    public Page_reg_form setState(String value) {
        $("#state").click();
        state_component.setState(value);

        return this;
    }
    public Page_reg_form setCity(String value) {
        $("#city").click();
        city_component.setCity(value);

        return this;
    }
    public Page_reg_form clickSubmit() {
        $("#submit").click();

        return this;
    }
    public Page_reg_form checkFormOpened(String value) {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    public Page_reg_form checkResult (String key, String value) {
        resultsTable_component.checkResult(key, value);

        return this;
    }


}
