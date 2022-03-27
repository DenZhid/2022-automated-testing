package pages;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import utils.LogPageException;
import utils.User;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class LogPage extends Page {

    public final SelenideElement loadableElement = $(byName("st.password"));
    public final SelenideElement loginField = $(byName("st.email"));
    public final SelenideElement passwordField = $(byName("st.password"));

    @Override
    void checkIfPresent() {
        if (!loadableElement.exists()) {
            throw new LogPageException("Something went wrong...");
        }
    }

    public MainPage login(User user) {
        loginField.setValue(user.getLogin());
        passwordField.setValue(user.getPassword()).pressEnter();
        return new MainPage();
    }

}
