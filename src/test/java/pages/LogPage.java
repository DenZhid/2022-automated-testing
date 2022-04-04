package pages;

import utils.User;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LogPage extends Page {

    private static final SelenideElement LOGIN_FIELD = $(byXpath("//input[@name='st.email']"));
    private static final SelenideElement PASSWORD_FIELD = $(byXpath("//input[@name='st.password']"));

    public LogPage() {
        super("Log page init error", LOGIN_FIELD, PASSWORD_FIELD);
    }

    public MainPage login(User user) {
        LOGIN_FIELD.setValue(user.getLogin());
        PASSWORD_FIELD.setValue(user.getPassword()).pressEnter();
        return new MainPage();
    }

}
