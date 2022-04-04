package pages;

import org.openqa.selenium.InvalidArgumentException;

import com.codeborne.selenide.SelenideElement;

import utils.User;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MembersGroupPage extends Page {

    private final static SelenideElement SEARCH_FIELD = $(byId("search"));

    public MembersGroupPage() {
        super("Error view members of group", $(byId("GroupMembersMenu")));
    }

    public boolean hasUser(User user) {
        if (user.id == null) {
            throw new InvalidArgumentException("User id is undefined");
        }
        SEARCH_FIELD.setValue(user.id.toString()).pressEnter();
        return ($(byXpath("//a[@href = '/profile/" + user.id + "']")).should(visible).isDisplayed());
    }

}
