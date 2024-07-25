package ru.firsttest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CallbackTest {

    private WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        // Укажите путь к WebDriver, если он не находится в PATH
        System.setProperty("webdriver.chrome.driver", "./driver/windows/chromedriver.exe");
    }

    @BeforeEach
    public void setupTest() {
        // Создайте экземпляр драйвера
        driver = new ChromeDriver();
    }

    @Test
    public void testExample() {
        // Откройте страницу
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Артем");
        driver.findElement(By.cssSelector("input[type='tel']")).sendKeys("+79999999999");
        /*
        альтернатива 33 и 34 строкам, но это хуже:
        List<WebElement> elements = driver.findElements(By.tagName("input"));
        elements.get(0).sendKeys("Артем");
        elements.get(1).sendKeys("+79138010585");
         */
        driver.findElement(By.cssSelector("label[data-test-id='agreement']")).click();
        driver.findElement(By.className("button")).click();
        String expected = "  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("p[data-test-id='order-success']")).getText();
        assertEquals(expected, actual);
        // Можно добавить дополнительные проверки здесь
    }

    @AfterEach
    public void teardown() {
        // Закройте браузер
        if (driver != null) {
            driver.quit();
        }
    }
}