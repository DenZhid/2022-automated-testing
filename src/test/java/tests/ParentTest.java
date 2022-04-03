package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class ParentTest {

    final static String USER_LOGIN = "";
    final static String USER_PASSWORD = "";

    @BeforeEach
    public void createWebDriver() {
        open("https://ok.ru");
    }

    @AfterEach
    public void close() {
        closeWebDriver();
    }
}
