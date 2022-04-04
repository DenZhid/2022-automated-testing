package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;

import utils.User;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class MembersGroupPage extends Page {

    public MembersGroupPage() {
        super("Error view members of group", $(By.id("GroupMembersMenu")));
    }

    public boolean hasUser(User user) {
        if (user.id == null) {
            throw new InvalidArgumentException("User id is undefined");
        }
        $(By.id("search")).setValue(user.id.toString()).pressEnter();
        sleep(500);
        return ($(By.xpath("//a[@href = '/profile/" + user.id + "']")).exists());
    }

}
