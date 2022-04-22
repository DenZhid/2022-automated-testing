package tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import com.codeborne.selenide.Configuration;

import utils.User;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;
import static java.io.File.separator;

abstract class BaseTest {

    static User user;
    static final String PATH_TO_RESOURCES_FOLDER = "src" + separator + "test" + separator + "resources" + separator;

    @BeforeAll
    static void createUser() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(PATH_TO_RESOURCES_FOLDER + "userData.txt"));
        user =  new User(reader.readLine(), reader.readLine());
    }

    @BeforeEach
    void openSite() {
        Configuration.pageLoadTimeout = 60000;
        open("https://ok.ru");
    }

    @AfterEach
    void close() {
        closeWindow();
    }

    @AfterAll
    static void endWebDriver() {
        closeWebDriver();
    }
}
