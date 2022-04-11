package tests;

import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

public class ParentTest {

    final static String USER_LOGIN = "";
    final static String USER_PASSWORD = "";

    @BeforeEach
    public void createWebDriver() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        Configuration.browser = "chrome";
        open("https://ok.ru");
    }

    @AfterEach
    public void close() {
        closeWindow();
    }

    @AfterAll
    public static void endWebDriver() {
        closeWebDriver();
    }
}
