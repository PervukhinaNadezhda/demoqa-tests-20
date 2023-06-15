package com.demoqa.tests;

import com.demoqa.pages.AutomationPracticeFormPage;
import org.junit.jupiter.api.Test;

import static com.demoqa.utils.RandomUtils.*;

public class AutomationPracticeFormWithRandomUtilsTests extends TestBase {
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String gender = getRandomGender();
    String userNumber = faker.phoneNumber().subscriberNumber(10);
    String birthDay = String.valueOf(getRandomInt(10, 28));
    String birthMonth = getRandomMonth();
    String birthYear = String.valueOf(getRandomInt(1900, 2023));
    String subjectValueOne = "g";
    String subjectOne = "English";
    String subjectValueTwo = "m";
    String subjectTwo = "Maths";
    String hobby = getRandomHobbies();
    String picture = "images.jpg";
    String address = faker.address().fullAddress();
    String state = "NCR";
    String city = "Delhi";


    AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage();

    @Test
    void formValidation() {
        automationPracticeFormPage
                .openPage()
                .RemoveBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDay(birthDay, birthMonth, birthYear)
                .setSubject(subjectValueOne, subjectOne)
                .setSubject(subjectValueTwo, subjectTwo)
                .setHobby(hobby)
                .uploadPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .pushSubmitButton()

                .verifyResult("Student Name", (firstName + " " + lastName))
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", (birthDay + " " + birthMonth + "," + birthYear))
                .verifyResult("Subjects", (subjectOne + ", " + subjectTwo))
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", picture)
                .verifyResult("Address", address)
                .verifyResult("State and City", (state + " " + city));
    }
}