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
        .setGender("Other");

        $("#userNumber").setValue("1231231230");
        page_one.setDateOfBirth("4","August","1993");
        /*$("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();*/

        $("#subjectsInput").sendKeys("Maths");
        $("#subjectsInput").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("pic.png");

        $("#currentAddress").setValue("Some street 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName), text(lastName),
                text("alex@egorov.com"), text("Some address 1"), text("30 July,2008"));
    }
}
