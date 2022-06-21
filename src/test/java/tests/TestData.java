package tests;

import com.github.javafaker.Faker;
import utils.RandomDataGenerator;

import java.util.Locale;

public class TestData {
    Faker fakerRussian = new Faker(new Locale("ru"));
    Faker fakerEnglish = new Faker(new Locale("en"));


    String firstName = fakerRussian.address().firstName(),
            lastName = fakerRussian.address().lastName(),
            email = fakerEnglish.internet().emailAddress(),
            gender = RandomDataGenerator.randomGender(),
            mobileNum = String.valueOf(fakerEnglish.number().randomNumber(10, true)),
            day = String.valueOf(fakerEnglish.number().numberBetween(1, 28)),
            month = RandomDataGenerator.randomMonth(),
            year = String.valueOf(fakerEnglish.number().numberBetween(1970, 2022)),
            subject = RandomDataGenerator.randomSubjects(),
            hobby = RandomDataGenerator.randomHobbies(),
            picture = "pic.png",
            address = fakerRussian.address().fullAddress(),
            state = "NCR",
            city = "Delhi";

}
