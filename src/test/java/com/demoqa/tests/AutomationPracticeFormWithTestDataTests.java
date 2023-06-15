package com.demoqa.tests;

import com.demoqa.pages.AutomationPracticeFormPage;
import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestData.*;

public class AutomationPracticeFormWithTestDataTests extends TestBase {
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