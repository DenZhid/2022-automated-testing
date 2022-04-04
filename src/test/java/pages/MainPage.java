package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends Page {

    private static final SelenideElement TO_GROUPS_BUTTON = $(byXpath("//*[@data-l = 't,userAltGroup']"));
    private static final SelenideElement TO_MUSIC_BUTTON = $(byXpath("//*[@data-l = 't,music']"));
    private static final SelenideElement TO_PHOTOS_BUTTON = $(byXpath("//*[@data-l = 't,userPhotos']"));
    private static final SelenideElement TO_USER_PROFILE_BUTTON = $(byXpath("//*[@data-l = 't,userPage']"));

    public MainPage() {
        super("Main page init error",TO_USER_PROFILE_BUTTON);
    }

    public UserGroupsPage goToGroupsPage() {
        TO_GROUPS_BUTTON.should(visible).click();
        return new UserGroupsPage();
    }

    public GroupPage goToGroup(String groupId) {
        return new GroupPage(groupId);
    }

    public MusicPage goToMusic() {
        TO_MUSIC_BUTTON.should(visible).click();
        return new MusicPage();
    }

    public PhotoPage goToPhoto() {
        TO_PHOTOS_BUTTON.should(visible).click();
        return new PhotoPage();
    }
}
