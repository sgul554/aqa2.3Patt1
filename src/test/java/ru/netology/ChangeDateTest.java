package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.withText;


class ChangeDateTest {
    @Test
    void shouldChangeDateForDelivery() {
        open("http://localhost:9999/");

        String FirstDate = DataGenerator.generateDate(3);
        String SecondDate = DataGenerator.generateDate(6);

        $("[data-test-id=city] input").setValue(DataGenerator.generateCity());
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.DELETE);
        $("[data-test-id=date] input").setValue(FirstDate);
        $("[data-test-id=name] input").setValue(DataGenerator.generateName());
        $("[data-test-id=phone] input").setValue(DataGenerator.generatePhone());
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно запланирована на " + FirstDate));

        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.DELETE);
        $("[data-test-id=date] input").setValue(SecondDate);
        $(".button").click();
        $(withText("У вас уже запланирована встреча на другую дату."))
                .shouldBe(Condition.visible, Duration.ofSeconds(15));
        $(withText("Перепланировать")).click();
        $("[data-test-id=success-notification] .notification__content")
                .shouldBe(Condition.visible)
                .shouldHave(Condition.exactText("Встреча успешно запланирована на " + SecondDate));


    }


}