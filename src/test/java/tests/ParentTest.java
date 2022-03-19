package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.open;

public class ParentTest {
    protected static WebDriver driver;
    /*
        Возможно даже необязательно выставлять какие-то настройки, потому что
        и без них вроде как работало. Не знаю, какой в таком случае используется WebDriver
     */
    @BeforeAll
    public static void createWebDriver() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");

        driver = new ChromeDriver();

        driver.get("https://ok.ru");
        open("https://ok.ru");
    }

    @AfterAll
    public static void close() {
        driver.quit();
    }
}
