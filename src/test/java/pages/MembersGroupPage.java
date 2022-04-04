package pages;

import org.openqa.selenium.InvalidArgumentException;

import utils.User;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class MembersGroupPage extends Page {

    public MembersGroupPage() {
        super("Error view members of group", $(byId("GroupMembersMenu")));
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
