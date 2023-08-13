import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;

public class DeliveryCardTask1Tests {
    @Test
    public void SuccessTest()
    {
        var user = UserInfoUtils.GenerateUser(new Locale("ru"));

        open("http://localhost:9999");
        var form = $(".form");
        form.$("[data-test-id=city] input").setValue(user.getCity());
        String firstAppointment = generateDate(3, "dd.MM.yyyy");

        form.$("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        form.$("[data-test-id=date] input").setValue(firstAppointment);
        form.$("[data-test-id=name] input").setValue(user.getName());
        form.$("[data-test-id=phone] input").setValue(user.getPhone());
        form.$("[data-test-id=agreement]").click();
        form.$(".form-field>button").click();

        $("[data-test-id='success-notification'] > .notification__content")
                .shouldHave(Condition.text("Встреча успешно запланирована на " + firstAppointment), Duration.ofSeconds(10))
                .shouldBe(Condition.visible);

        String secondAppointment = generateDate(6, "dd.MM.yyyy");
        form.$("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        form.$("[data-test-id=date] input").setValue(secondAppointment);
        form.$(".form-field>button").click();

        $("[data-test-id='replan-notification'] .notification__content")
                .shouldHave(Condition.text("У вас уже запланирована встреча на другую дату. Перепланировать?"))
                .shouldBe(Condition.visible);
        $("[data-test-id='replan-notification'] > .notification__content > button").click();

        $("[data-test-id='success-notification'] > .notification__content")
                .shouldHave(Condition.text("Встреча успешно запланирована на " + secondAppointment), Duration.ofSeconds(10))
                .shouldBe(Condition.visible);
    }

    private String generateDate(int addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }
}
