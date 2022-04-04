package pages;

import utils.PageLoadException;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends Page {

    private static final SelenideElement TO_GROUPS_BUTTON = $(byXpath("//*[@data-l = 't,userAltGroup']"));
    private static final SelenideElement TO_MUSIC_BUTTON = $(byXpath("//*[@data-l = 't,music']"));
    private static final SelenideElement TO_PHOTOS_BUTTON = $(byXpath("//*[@data-l = 't,userPhotos']"));
    private static final SelenideElement TO_USER_PROFILE_BUTTON = $(byXpath("//*[@data-l = 't,userPage']"));

    public MainPage() throws PageLoadException {
        super("Main page init error",TO_USER_PROFILE_BUTTON);
    }

    public UserGroupsPage goToGroupsPage() {
        TO_GROUPS_BUTTON.click();
        return new UserGroupsPage();
    }

    public GroupPage goToGroup(String groupId) {
        return new GroupPage("https://ok.ru/group/" + groupId);
    }

    public MusicPage goToMusic() {
        TO_MUSIC_BUTTON.click();
        return new MusicPage();
    }

    public PhotoPage goToPhoto() {
        TO_PHOTOS_BUTTON.click();
        return new PhotoPage();
    }
}
