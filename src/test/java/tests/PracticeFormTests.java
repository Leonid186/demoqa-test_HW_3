package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
    @BeforeAll
    static void beforeAll() { 
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com"; 
        Configuration.pageLoadStrategy = "eager"; 
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; //default 4000
    }

    @Test
    void practiceFormeTests() {
        open("/automation-practice-form");

        // input Name
        $("#firstName").setValue("Leonid");

        // input lastName 
        $("#lastName").setValue("Zorin");

        // input Email 
        $("#userEmail").setValue("l.zorin2011@yandex.ru");

        // Gender
        $(new ByText("Male")).click();

        // mobile +
        $("#userNumber").setValue("9227985359");

        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1984");
        $(".react-datepicker__day--011").click();

        //Subjects
        $("#subjectsInput").setValue("Eng");
        $$(".subjects-auto-complete__option").findBy(text("English")).click();
        $("#subjectsInput").setValue("Chem");
        $$(".subjects-auto-complete__option").findBy(text("Chemistry")).click();

        //hobbies
        $(new ByText("Sports")).click();
        $(new ByText("Reading")).click();
        $(new ByText("Music")).click();

        //Select picture
        // $("#uploadPicture").uploadFromClasspath("1.jpg");

        //Current Address
        $("#currentAddress").setValue("Surgut, Russian Federation");

        //State and City
        $("#state").click();
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Agra").pressEnter();

        // Нажать Submit
        $("#submit").click();

        // Проверка правильности заполнения таблицы (результат)
        $(".table-responsive").shouldHave(text("Student Name Leonid Zorin"));
        $(".table-responsive").shouldHave(text("Student Email l.zorin2011@yandex.ru"));
        $(".table-responsive").shouldHave(text("Gender Male"));
        $(".table-responsive").shouldHave(text("Mobile 9227985359"));
        $(".table-responsive").shouldHave(text("Date of Birth 11 August,1984"));
        $(".table-responsive").shouldHave(text("Subjects English, Chemistry"));
        $(".table-responsive").shouldHave(text("Hobbies Sports, Reading, Music"));
        //$(".table-responsive").shouldHave(text("Picture 1.jpg")); //!не понял как сделать!
        $(".table-responsive").shouldHave(text("Address Surgut, Russian Federation"));
        $(".table-responsive").shouldHave(text("State and City Uttar Pradesh Agra"));
    }
}

