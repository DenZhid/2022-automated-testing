package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.NotLoggedException;
import utils.User;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LogPage implements Page {
    private final WebDriver driver;

    public LogPage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public boolean isPresent() {
        //TODO
        return true;
    }

    public MainPage login(User user) throws NotLoggedException {
        $(byName("st.email")).setValue(user.getLogin());
        $(byName("st.password")).setValue(user.getPassword()).pressEnter();
        return new MainPage(driver);
    }

}
