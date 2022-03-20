package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class ParentTest {
    /*
        Возможно даже необязательно выставлять какие-то настройки, потому что
        и без них вроде как работало. Не знаю, какой в таком случае используется WebDriver
     */
    @BeforeAll
    public static void createWebDriver() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");

        open("https://ok.ru");
    }

    @AfterAll
    public static void close() {
        closeWebDriver();
    }
}
