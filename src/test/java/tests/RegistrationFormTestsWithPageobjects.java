package tests;

import org.junit.jupiter.api.Test;
import pages.Page_reg_form;

public class RegistrationFormTestsWithPageobjects extends tests.TestBase {

    Page_reg_form page_regform = new Page_reg_form();

    @Test
    void successfulTest() {
        String firstName = "Dart";
        String lastName = "Tester";

        page_regform.openPage()
        .setFirstName(firstName)
        .setLastName(lastName)
        .setEmail("dart@tester.com")
        .setGender("Other")
        .setNumber("81233212112")
        .setDateOfBirth("4","August","1993")
        .setSubject("Maths")
        .setHobbies("Sports")
        .setPicture("pic.png")
        .setAddress("Address1")
        .setState("NCR")
        .setCity("Delhi")
        .clickSubmit()
        .checkFormOpened()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", "dart@tester.com")
                .checkResult("Date of Birth", "4 August,1993")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "pic.png")
                .checkResult("Address", "Address1")
                .checkResult("State and City", "NCR Delhi");
    }
}
