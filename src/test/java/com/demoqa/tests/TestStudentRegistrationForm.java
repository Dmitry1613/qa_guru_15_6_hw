package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestStudentRegistrationForm extends TestData {

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
          .setFirstName(firstName)
          .setLastName(lastName)
          .setEmail(email)
          .setGender(gender)
          .setNumber(number)
          .setBirthDate(day, month, year)
          .setSubjects(subject)
          .setHobbie(hobby)
          .pictureUpload(picture)
          .setCurrentAddress(address)
          .setStateAndCity(state, city)
          .clickSubmit();

        registrationFormPage
          .checkResultsTableVisible()
          .checkResult("Student Name", firstName + " " + lastName)
          .checkResult("Student Email", email)
          .checkResult("Gender", gender)
          .checkResult("Mobile", number)
          .checkResult("Date of Birth", day + " " + month + "," + year )
          .checkResult("Subjects", subject)
          .checkResult("Hobbies", hobby)
          .checkResult("Picture", picture)
          .checkResult("Address", address)
          .checkResult("State and City", state + " " + city);
    }

    @Test
    void fillFormWithMunimumTest() {
        registrationFormPage.openPage()
          .setFirstName(firstName)
          .setLastName(lastName)
          .setEmail(email)
          .setGender(gender)
          .setNumber(number)
          .clickSubmit();

        registrationFormPage.checkResultsTableVisible()
          .checkResult("Student Name", firstName + " " + lastName)
          .checkResult("Student Email", email)
          .checkResult("Gender", gender)
          .checkResult("Mobile", number);
    }
}
