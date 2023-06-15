package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            gender = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            birthDayInput = $("#dateOfBirth-wrapper").$("#dateOfBirthInput"),
            subjectValueInput = $("#subjectsInput"),
            subjectChosen = $("#subjectsWrapper"),
            hobbyInput = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            stateChosen = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            cityChosen = $("#stateCity-wrapper"),
            submitButton = $("#submit"),
            resultTable = $(".table-responsive");

    public AutomationPracticeFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }


    public AutomationPracticeFormPage removeBanner(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public AutomationPracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setGender(String value) {
        gender.$(byText(value)).click();
        return this;
    }

    public AutomationPracticeFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setBirthDay(String day, String month, String year) {
        birthDayInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public AutomationPracticeFormPage setSubject(String value, String subject) {
        subjectValueInput.setValue(value);
        subjectChosen.$(byText(subject)).click();
        return this;
    }

    public AutomationPracticeFormPage setHobby(String value) {
        hobbyInput.$(byText(value)).click();
        return this;
    }

    public AutomationPracticeFormPage uploadPicture(String value) {
        uploadPictureInput.uploadFromClasspath(value);
        return this;
    }

    public AutomationPracticeFormPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setState(String value) {
        stateInput.click();
        stateChosen.$(byText(value)).click();
        return this;
    }

    public AutomationPracticeFormPage setCity(String value) {
        cityInput.click();
        cityChosen.$(byText(value)).click();
        return this;
    }

    public AutomationPracticeFormPage pushSubmitButton() {
        submitButton.click();
        return this;
    }

    public AutomationPracticeFormPage verifyResult(String key, String value) {
        resultTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}
