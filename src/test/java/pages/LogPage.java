package pages;

import utils.LogPageException;
import utils.PageLoadException;
import utils.User;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LogPage extends Page {

    public static final SelenideElement LOGIN_FIELD = $(byXpath("//input[@name='st.email']"));
    public static final SelenideElement PASSWORD_FIELD = $(byXpath("//input[@name='st.password']"));

    public LogPage() throws PageLoadException {
        super($(byXpath("//input[@name='st.password']")));
    }

    @Override
    void check() {
        if (!loadableElement.should(visible).isDisplayed()) {
            throw new LogPageException("Something went wrong...");
        }
    }

    public MainPage login(User user) {
        LOGIN_FIELD.setValue(user.getLogin());
        PASSWORD_FIELD.setValue(user.getPassword()).pressEnter();
        return new MainPage();
    }

}
