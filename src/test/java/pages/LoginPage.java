package pages;

import utils.User;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    private static final SelenideElement LOGIN_FIELD = $(byXpath("//input[@name='st.email']"));
    private static final SelenideElement PASSWORD_FIELD = $(byXpath("//input[@name='st.password']"));
    private static final SelenideElement LOGIN_BUTTON = $(byXpath("//input[@data-l='t,sign_in']"));

    public LoginPage() {
        super("Log page init error", LOGIN_FIELD, PASSWORD_FIELD, LOGIN_BUTTON);
    }

    public MainPage login(User user) {
        LOGIN_FIELD.setValue(user.getLogin());
        PASSWORD_FIELD.setValue(user.getPassword());
        LOGIN_BUTTON.pressEnter();
        return new MainPage();
    }

}
