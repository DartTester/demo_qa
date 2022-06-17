import org.junit.jupiter.api.Test;
import pages.Page_one;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTestsWithPageobjects extends tests.TestBase {

    Page_one page_one = new Page_one();

    @Test
    void successfulTest() {
        String firstName = "Dart";
        String lastName = "Tester";

        page_one.openPage()
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
        .checkFormOpened("Thanks for submitting the form")
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
