package pages;

import org.openqa.selenium.By;

import utils.NotLoggedException;
import utils.PageLoadException;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends Page {

    public MainPage() throws PageLoadException {
        super($(By.xpath("//*[@data-l = 't,userPage']")));
    }

    @Override
    void checkIfPresent() {
        if (!loadableElement.exists()) {
            throw new NotLoggedException("Invalid logging operation");
        }
    }

    public UserGroupsPage goToGroupsPage() {
        $(By.xpath("//*[@data-l = 't,userAltGroup']")).click();
        return new UserGroupsPage();
    }

    public GroupPage goToGroup(String groupId) {
        return new GroupPage("https://ok.ru/group/" + groupId);
    }

    public MusicPage goToMusic() {
        $(By.xpath("//*[@data-l = 't,music']")).click();
        return new MusicPage();
    }
}
