package pages;

import utils.PageNotLoadedException;
import utils.User;

import org.openqa.selenium.InvalidArgumentException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class MembersGroupPage extends Page {

    public MembersGroupPage() {
        super($(byId("GroupMembersMenu")));
    }

    @Override
    void check() {
        if (!loadableElement.should(visible).isDisplayed()) {
            throw new PageNotLoadedException("Invalid members group page initialization");
        }
    }

    public boolean hasUser(User user) {
        if (user.id == null) {
            throw new InvalidArgumentException("User id is undefined");
        }
        $(byId("search")).setValue(user.id.toString()).pressEnter();
        sleep(500);
        return ($(byXpath("//a[@href = '/profile/" + user.id + "']")).exists());
    }

}
