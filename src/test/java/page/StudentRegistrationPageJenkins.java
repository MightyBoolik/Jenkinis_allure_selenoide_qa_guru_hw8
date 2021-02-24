package page;

import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationPageJenkins {
    @Step("Open student registration form")
    public StudentRegistrationPageJenkins openPage(String url) {
        open(url);
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    @Step("Set first name")
    public StudentRegistrationPageJenkins setFirstName(String firstName) {
        $("#firstName").val(firstName);
        return this;
    }

    @Step("Set last name")
    public StudentRegistrationPageJenkins setLastName(String lastName) {
        $("#lastName").val(lastName);
        return this;
    }

    @Step("Set email")
    public StudentRegistrationPageJenkins setEmail(String email) {
        $("#userEmail").val(email);
        return this;
    }

    @Step("Set gender")
    public StudentRegistrationPageJenkins setGender(String gender) {
        $(byText(gender)).click();
        return this;
    }

    @Step("Set phone number")
    public StudentRegistrationPageJenkins setPhoneNumber(String mobile) {
        $("#userNumber").val(mobile);
        return this;
    }

    @Step("set date of birth")
    public StudentRegistrationPageJenkins setBirthDate(String year, String month, String day) {
        $("#dateOfBirthInput").clear();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day).click();
        return this;
    }

    @Step("Set subjects")
    public StudentRegistrationPageJenkins setSubjects(String subjects) {
        $("#subjectsInput").val(subjects).pressEnter();
        return this;
    }

    @Step("Set hobbies")
    public StudentRegistrationPageJenkins setHobbies(String hobbies) {
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        return this;
    }

    @Step("Upload file")
    public StudentRegistrationPageJenkins uploadFile(String picture) {
        $("#uploadPicture").uploadFile(new File("src/test/resources/upload/" + picture));
        return this;
    }

    @Step("Set address")
    public StudentRegistrationPageJenkins setAddress(String address) {
        $("#currentAddress").val(address);
        return this;
    }

    @Step("Choose state")
    public StudentRegistrationPageJenkins chooseState(String state) {
        $("#state").click();
        $(byText(state)).click();
        return this;
    }

    @Step("Choose city")
    public StudentRegistrationPageJenkins chooseCity(String city) {
        $("#city").click();
        $(byText(city)).click();
        return this;
    }

    @Step("Submit button")
    public StudentRegistrationPageJenkins clickSubmit() {
        $("#submit").click();
        return this;
    }

    @Step("Check fill form")
    public StudentRegistrationPageJenkins checkData(String firstName, String lastName, String email, String gender, String mobile, String subjects, String hobbies, String picture, String address, String state, String city) {
        $(".modal-content").shouldHave
                (text(firstName),
                        text(lastName),
                        text(email),
                        text(gender),
                        text(mobile),
                        text(subjects),
                        text(hobbies),
                        text(picture),
                        text(address),
                        text(city),
                        text(state));
        return this;
    }
}

