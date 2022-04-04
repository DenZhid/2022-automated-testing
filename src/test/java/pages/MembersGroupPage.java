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
    private final static SelenideElement GROUP_MEMBERS_MENU = $(byId("GroupMembersMenu"));

    public MembersGroupPage() {
        super("Error view members of group", GROUP_MEMBERS_MENU);
    }

    public boolean hasUser(User user) {
        if (user.id == null) {
            throw new InvalidArgumentException("User id is undefined");
        }
        SEARCH_FIELD.should(visible).setValue(user.id.toString()).pressEnter();
        return ($(byXpath("//a[@href = '/profile/" + user.id + "']")).should(visible).isDisplayed());
    }

}
