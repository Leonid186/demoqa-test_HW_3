package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
    @BeforeAll
    static void beforeAll(){ //+
        Configuration.browserSize = "1920x1080"; // +
        Configuration.baseUrl = "https://demoqa.com"; // +
        Configuration.pageLoadStrategy = "eager"; // +
        Configuration.holdBrowserOpen = true; // удалить
    }
    @Test
    void practiceFormeTests() {
        open("/automation-practice-form");

        // input Name +
        $("#firstName").setValue("Leonid");

        // input lastName +
        $("#lastName").setValue("Zorin");

        // input Email +
        $("#userEmail").setValue("l.zorin2011@yandex.ru");

        // Gender -
        $(new ByText("Male")).click();

        // mobile +
        $("#userNumber").setValue("9227985359"); // # ввести правильное наименование строки

        //Date of Birth //ХЗ как делать

        //Subjects нужно вводить часть названия и через клик
        $("#subjectsInput").setValue("Eng");
        $$(".subjects-auto-complete__option").findBy(text("English")).click();
        $("#subjectsInput").setValue("Chem");
        $$(".subjects-auto-complete__option").findBy(text("Chemistry")).click();

        //hobbies
        $(new ByText("Sports")).click(); //
        $(new ByText("Reading")).click();
        $(new ByText("Music")).click();

        //Select picture - ХЗ

        //Current Address
        $("#subjectsContainer").setValue("Surgut, Russian Federation"); //# ввести правильное наименование строки

        //State and City - два теста

        // Нажать Submit
        $("#submit").click(); //# ввести правильное наименование строки

        // Проверка правильности заполнения таблицы
        $("#output #name").shouldHave(text("Leonid"));
        $("#output #email").shouldHave(text("l.zorin2011@yandex.ru"));
        $("#output #currentAddress").shouldHave(text("Surgut, Russian Federation"));
        $("#output #permanentAddress").shouldHave(text("Surgut, Russian Federation"));
    }
}

