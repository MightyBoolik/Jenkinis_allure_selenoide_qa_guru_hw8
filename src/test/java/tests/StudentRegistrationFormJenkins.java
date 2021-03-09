package tests;

import com.github.javafaker.Faker;
import config.TestBase;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import page.StudentRegistrationPageJenkins;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class StudentRegistrationFormJenkins extends TestBase {
    StudentRegistrationPageJenkins studentRegistrationPage = new StudentRegistrationPageJenkins();

    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Male",
            mobile = faker.phoneNumber().subscriberNumber(10),
            day = "12",
            month = "April",
            year = "1994",
            subjects = "Maths",
            hobbies = "Reading",
            picture = "RABOTAY.png",
            address = faker.address().fullAddress(),
            state = "Rajasthan",
            city = "Jaipur",
            url = "https://demoqa.com/automation-practice-form";

    @Test
    @DisplayName("Отправка данных с заполненной формой")
    @Owner("MightyBoolik")
    public void successfulFillFormTest() {

        studentRegistrationPage.openPage(url)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(mobile)
                .setBirthDate(year, month, day)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .uploadFile(picture)
                .setAddress(address)
                .chooseState(state)
                .chooseCity(city)
                .clickSubmit()
                .checkData(firstName, lastName, email, gender, mobile, year, month, day, subjects, hobbies, picture);
    }

    @Test
    @Tag("negative")
    @DisplayName("Отправка формы без заполнения полей")
    @Owner("MightyBoolik")
    public void negativeFillFormTest() {
        step("Open registration form", () -> {
            open("https://demoqa.com/automation-practice-form");
        });
        step("Open registration form", () -> {
            $("#submit").click();
        });
        step("Open registration form", () -> {
            $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        });
    }
}


