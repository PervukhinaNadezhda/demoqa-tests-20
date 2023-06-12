package com.demoqa.tests;

import com.demoqa.pages.AutomationPracticeFormPage;
import org.junit.jupiter.api.Test;

public class AutomationPracticeFormWithPageObjects extends TestBase {

    AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage();

    @Test
    void formValidation() {
        automationPracticeFormPage
                .openPage()
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setUserEmail("AlexEgorov@mail.ru")
                .setGender("Male")
                .setUserNumber("9991112233")
                .setBirthDay("20", "April", "1994")
                .setSubject("g", "English")
                .setSubject("m", "Maths")
                .setHobby("Sports")
                .uploadPicture("images.jpg")
                .setAddress("Address №1")
                .setState("NCR")
                .setCity("Delhi")
                .pushSubmitButton()

                .verifyResult("Student Name", "Alex Egorov")
                .verifyResult("Student Email", "AlexEgorov@mail.ru")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "9991112233")
                .verifyResult("Date of Birth", "20 April,1994")
                .verifyResult("Subjects", "English, Maths")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "images.jpg")
                .verifyResult("Address", "Address №1")
                .verifyResult("State and City", "NCR Delhi");
    }
}