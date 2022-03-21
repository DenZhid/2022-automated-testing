package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class ParentTest {

    final static String USER_PASSWORD = "";
    final static String USER_LOGIN = "";

    @BeforeAll
    public static void createWebDriver() {
        open("https://ok.ru");
    }

    @AfterAll
    public static void close() {
        closeWebDriver();
    }
}
