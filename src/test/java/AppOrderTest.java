import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppOrderTest {
    @Test
    void ShouldBeSuccess() {
        open("http://0.0.0.0:9999");
        SelenideElement form = $(".form");
        form.$("[data-test-id=name] input").setValue("Кирилл");
        form.$("[data-test-id=phone] input").setValue("+79581732626");
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", $("[data-test-id=order-success]").getText().trim());
    }

}
