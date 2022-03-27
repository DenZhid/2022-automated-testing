package pages;

import utils.LogPageException;
import utils.User;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class LogPage extends Page {

    @Override
    void checkIfPresent() {
        if (!$(byName("st.password")).exists()) {
            throw new LogPageException("Something went wrong...");
        }
    }

    public MainPage login(User user) {
        $(byName("st.email")).setValue(user.getLogin());
        $(byName("st.password")).setValue(user.getPassword()).pressEnter();
        return new MainPage();
    }

}
