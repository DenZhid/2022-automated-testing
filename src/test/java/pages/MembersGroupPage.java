package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;

import utils.GroupPageException;
import utils.User;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class MembersGroupPage extends Page {

    public MembersGroupPage() {
        super($(By.id("GroupMembersMenu")));
    }

    @Override
    void checkIfPresent() {
        sleep(500);
        if (!loadableElement.exists()) {
            throw new GroupPageException("Members group page init fail");
        }
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
