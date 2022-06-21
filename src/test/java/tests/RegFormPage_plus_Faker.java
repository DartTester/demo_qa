package tests;

import org.junit.jupiter.api.Test;

public class RegFormPage_plus_Faker extends TestBase {

    @Test
    void successfulTest() {
        page_regform.openPage()
        .setFirstName(testData.firstName)
        .setLastName(testData.lastName)
        .setEmail(testData.email)
        .setGender(testData.gender)
        .setNumber(testData.mobileNum)
        .setDateOfBirth(testData.day, testData.month, testData.year)
        .setSubject(testData.subject)
        .setHobbies(testData.hobby)
        .setPicture(testData.picture)
        .setAddress(testData.address)
        .setState(testData.state)
        .setCity(testData.city)
        .clickSubmit()
        .checkFormOpened()
                .checkResult("Student Email", testData.email)
                .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobby)
                .checkResult("Picture", testData.picture)
                .checkResult("Address", testData.address)
                .checkResult("State and City", testData.state + " " + testData.city);
    }

    @Test
    void UnsuccessfulTest() {
        page_regform.openPage()
                .setFirstName(" ")
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setNumber(testData.mobileNum)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setSubject(testData.subject)
                .setHobbies(testData.hobby)
                .setPicture(testData.picture)
                .setAddress(testData.address)
                .setState(testData.state)
                .setCity(testData.city)
                .clickSubmit()
                .checkFormOpened()
                .checkResult("Student Email", testData.email)
                .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobby)
                .checkResult("Picture", testData.picture)
                .checkResult("Address", testData.address)
                .checkResult("State and City", testData.state + " " + testData.city);
    }
}
