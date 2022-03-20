package pages;

import com.codeborne.selenide.Condition;

import utils.LogPageException;
import utils.NotLoggedException;
import utils.User;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class LogPage implements Page {

    public LogPage() throws LogPageException {
        if (!isPresent()) {
            throw new LogPageException("Something went wrong...");
        }
    }

    @Override
    public boolean isPresent() {
        return $(byName("st.password")).should(Condition.exist).exists();
    }

    public MainPage login(User user) throws NotLoggedException {
        $(byName("st.email")).setValue(user.getLogin());
        $(byName("st.password")).setValue(user.getPassword()).pressEnter();
        return new MainPage();
    }

}
