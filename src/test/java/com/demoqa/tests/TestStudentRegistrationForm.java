package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestStudentRegistrationForm {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
          .setFirstName("Ivan")
          .setLastName("Ivanov")
          .setEmail("Ivan@gmail.com")
          .setGender("Male")
          .setNumber("1478521478")
          .setBirthDate("21", "July", "1994")
          .setSubjects("Maths")
          .setHobbie("Sports")
          .pictureUpload("image.jpg")
          .setCurrentAddress("Kaliningrad")
          .setStateAndCity("Haryana", "Panipat")
          .clickSubmit();

        registrationFormPage
          .checkResultsTableVisible()
          .checkResult("Student Email", "Ivan@gmail.com")
          .checkResult("Gender", "Male")
          .checkResult("Mobile", "1478521478")
          .checkResult("Date of Birth", "21 July,1994")
          .checkResult("Subjects", "Maths")
          .checkResult("Hobbies", "Sports")
          .checkResult("Picture", "image.jpg")
          .checkResult("Address", "Kaliningrad")
          .checkResult("State and City", "Haryana Panipat");
    }
}
