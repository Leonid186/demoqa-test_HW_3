package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; //default 4000
    }
        @Test
        void fillFormTest() {
            open("/text-box");
            $("#userName").setValue("Leonid");
            $("#userEmail").setValue("l.zorin2011@yandex.ru");
            $("#currentAddress").setValue("Surgut, Russian Federation");
            $("#permanentAddress").setValue("Surgut, Russian Federation");
            $("#submit").click();


            $("#output #name").shouldHave(text("Leonid"));
            $("#output #email").shouldHave(text("l.zorin2011@yandex.ru"));
            $("#output #currentAddress").shouldHave(text("Surgut, Russian Federation"));
            $("#output #permanentAddress").shouldHave(text("Surgut, Russian Federation"));
        }
}
