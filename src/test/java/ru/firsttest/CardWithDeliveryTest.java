//использование Selenide
package ru.firsttest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.WebDriverRunner.*;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class CardWithDeliveryTest {

    @Test
    void Delivery(){
        Configuration.holdBrowserOpen = true; //браузер не будет автоматически закрываться
        //Configuration.browserSize = "300x200"; чтобы сайт открылся в нужном размере, для тестирования адаптивной верстки
        open("http://localhost:9999/");
        $("[placeholder=\"Город\"]").setValue("Москва");
        $("[name=\"name\"]").setValue("Ар Со");
        $("[name=\"phone\"]").setValue("+79999999999");
        $("[data-test-id=\"agreement\"]").click();
        $x("//*[contains(text(), 'Забронировать')]").click();
        $x("//div[contains(text(), 'Успешно!')]").should(appear, Duration.ofSeconds(15));
    }
}
