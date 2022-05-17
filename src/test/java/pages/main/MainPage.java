package pages.main;

import com.codeborne.selenide.SelenideElement;

import pages.BasePage;
import pages.group.GroupPage;
import pages.group.UserGroupsPage;
import pages.music.MusicPage;
import pages.photo.PhotoPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {

    private static final SelenideElement TO_GROUPS_BUTTON = $(byXpath("//*[@data-l = 't,userAltGroup']"));
    private static final SelenideElement TO_PHOTOS_BUTTON = $(byXpath("//*[@data-l = 't,userPhotos']"));
    private static final SelenideElement TO_USER_PROFILE_BUTTON = $(byXpath("//*[@data-l = 't,userPage']"));
    private static final SelenideElement AVATAR_ICON = $(byXpath("//img[@id='viewImageLinkId']"));

    public MainPage() {
        super("Main page init error", MainTopToolBar.getAllTabs());
    }

    public UserGroupsPage goToGroupsPage() {
        TO_GROUPS_BUTTON.should(visible).click();
        return new UserGroupsPage();
    }

    public GroupPage goToGroup(String groupId) {
        TO_GROUPS_BUTTON.should(visible).click();
        return new UserGroupsPage().openGroup(groupId);
    }

    public MusicPage goToMusic() {
        MainTopToolBar.getToMusicButton().should(visible).click();
        return new MusicPage();
    }

    public PhotoPage goToPhoto() {
        TO_PHOTOS_BUTTON.should(visible).click();
        return new PhotoPage();
    }

    public String getCurrentAvatarRef() {
        return AVATAR_ICON.getAttribute("src");
    }

}
