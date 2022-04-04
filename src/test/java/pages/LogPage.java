package pages;

import utils.PageNotLoadedException;
import utils.User;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LogPage extends Page {

    public static final SelenideElement LOGIN_FIELD = $(byXpath("//input[@name='st.email']"));
    public static final SelenideElement PASSWORD_FIELD = $(byXpath("//input[@name='st.password']"));

    public LogPage() {
        super($(byXpath("//input[@name='st.password']")));
    }

    @Override
    void check() throws PageNotLoadedException {
        if (!loadableElement.shouldBe(visible).isDisplayed()) {
            throw new PageNotLoadedException("Invalid log page initialization");
        }
    }

    public MainPage login(User user) {
        LOGIN_FIELD.setValue(user.getLogin());
        PASSWORD_FIELD.setValue(user.getPassword()).pressEnter();
        return new MainPage();
    }

}
