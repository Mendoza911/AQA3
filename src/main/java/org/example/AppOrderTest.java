package org.example;

import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AppOrderTest {

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    void ShouldBeSuccess() {
        open("http://0.0.0.0:9999");
        SelenideElement form = $(".form");
        form.$("[data-test-id=name] input").setValue("Kirill");
        form.$("[data-test-id=phone] input").setValue("+79581732626");
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        $("[data-test-id=order-success]");
    }

}
