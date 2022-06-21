package pages;

import com.codeborne.selenide.SelenideElement;
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

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            genderInput = $("#genterWrapper"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit"),
            resultTableText = $("#example-modal-sizes-title-lg");

    public Page_reg_form openPage() {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }
    public Page_reg_form setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public Page_reg_form setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public Page_reg_form setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }
    public Page_reg_form setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }
    public Page_reg_form setNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }
    public Page_reg_form setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calender_component.setDate(day, month, year);

        return this;
    }
    public Page_reg_form setSubject(String value) {
        subjectsInput.sendKeys(value);
        subjectsInput.pressEnter();

        return this;
    }
    public Page_reg_form setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }
    public Page_reg_form setPicture(String value) {
        uploadPictureInput.uploadFromClasspath(value);

        return this;
    }
    public Page_reg_form setAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }
    public Page_reg_form setState(String value) {
        stateInput.click();
        state_component.setState(value);

        return this;
    }
    public Page_reg_form setCity(String value) {
        cityInput.click();
        city_component.setCity(value);

        return this;
    }
    public Page_reg_form clickSubmit() {
        submitButton.click();

        return this;
    }
    public Page_reg_form checkFormOpened() {
        resultTableText.shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    public Page_reg_form checkResult (String key, String value) {
        resultsTable_component.checkResult(key, value);

        return this;
    }


}
