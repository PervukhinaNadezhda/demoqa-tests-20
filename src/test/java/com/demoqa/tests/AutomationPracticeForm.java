package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void formValidation(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Egorov");
        $("#userEmail").setValue("AlexEgorov@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9991112233");

        $("#dateOfBirth-wrapper").$("#dateOfBirthInput").click();
        $("#dateOfBirth-wrapper").$(".react-datepicker__month-select").click();
        $("#dateOfBirth-wrapper").$(byText("April")).click();
        $("#dateOfBirth-wrapper").$(".react-datepicker__year-select").click();
        $("#dateOfBirth-wrapper").$(byText("1994")).click();
        $(".react-datepicker__day--020").click();

        $("#subjectsInput").setValue("g");
        $(byText("English")).click();

        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("images.jpg");
        $("#currentAddress").setValue("Address");

        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();


        $(".modal-body tr:nth-child(1) td:nth-child(2)").shouldHave(text("Alex Egorov"));
        $(".modal-body tr:nth-child(2) td:nth-child(2)").shouldHave(text("AlexEgorov@mail.ru"));
        $(".modal-body tr:nth-child(3) td:nth-child(2)").shouldHave(text("Male"));
        $(".modal-body tr:nth-child(4) td:nth-child(2)").shouldHave(text("9991112233"));
        $(".modal-body tr:nth-child(5) td:nth-child(2)").shouldHave(text("20 April,1994"));
        $(".modal-body tr:nth-child(6) td:nth-child(2)").shouldHave(text("English"));
        $(".modal-body tr:nth-child(7) td:nth-child(2)").shouldHave(text("Sports"));
        $(".modal-body tr:nth-child(8) td:nth-child(2)").shouldHave(text("images.jpg"));
        $(".modal-body tr:nth-child(9) td:nth-child(2)").shouldHave(text("Address"));
        $(".modal-body tr:nth-child(10) td:nth-child(2)").shouldHave(text("NCR Delhi"));
    }
}












