package tests;

import org.junit.jupiter.api.BeforeAll;

public class ParentTest {

    /*
        Возможно даже необязательно выставлять какие-то настройки, потому что
        и без них вроде как работало. Не знаю, какой в таком случае используется WebDriver
     */
    @BeforeAll
    static void createWebDriver() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
    }
}
