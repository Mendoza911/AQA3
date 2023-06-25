package org.example;

import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AppOrderTest {
    private WebDriver driver = new ChromeDriver();

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
    }

    @BeforeEach
    void tearDown() {
        driver.quit();
        driver = null;
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
