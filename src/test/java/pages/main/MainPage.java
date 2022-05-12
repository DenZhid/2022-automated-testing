package pages.main;

import com.codeborne.selenide.SelenideElement;

import pages.BasePage;
import pages.group.GroupPage;
import pages.group.UserGroupsPage;
import pages.music.MusicPage;
import pages.photo.PhotoPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {

    private static final SelenideElement TO_GROUPS_BUTTON = $(byXpath("//*[@data-l = 't,userAltGroup']"));
    private static final SelenideElement TO_PHOTOS_BUTTON = $(byXpath("//*[@data-l = 't,userPhotos']"));
    private static final SelenideElement TO_USER_PROFILE_BUTTON = $(byXpath("//*[@data-l = 't,userPage']"));
    private static final SelenideElement AVATAR_ICON = $(byXpath("//img[@id='viewImageLinkId']"));

    public MainPage() {
        super("Main page init error", TopToolBar.getAllTabs());
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
        MainPage.TopToolBar.getToMusicButton().should(visible).click();
        return new MusicPage();
    }

    public PhotoPage goToPhoto() {
        TO_PHOTOS_BUTTON.should(visible).click();
        return new PhotoPage();
    }

    public String getCurrentAvatarRef() {
        return AVATAR_ICON.getAttribute("src");
    }


    public static class TopToolBar {
        private static final SelenideElement TO_MAIN_BUTTON = $(byId("topPanelLeftCorner"));
        private static final SelenideElement TO_MESSAGE_BUTTON = $(byId("msg_toolbar_button"));
        private static final SelenideElement TO_DISCUSSION_BUTTON = $(byId("hook_ToolbarIconDiscussions_ToolbarDiscussions"));
        private static final SelenideElement TO_NOTIFICATIONS_BUTTON = $(byId("ntf_toolbar_button"));
        private static final SelenideElement TO_GUESTS_BUTTON = $(byId("hook_Block_HeaderTopNewEventsInToolbar"));
        private static final SelenideElement TO_TOP_NEWS_FEEDBACK_BUTTON = $(byId("HeaderTopNewFeedbackInToolbar"));
        private static final SelenideElement TO_MUSIC_BUTTON = $(byXpath("//*[@data-l = 't,music']"));

        public static SelenideElement[] getAllTabs() {
            SelenideElement[] array = new SelenideElement[7];
            array[0] = TO_MAIN_BUTTON;
            array[1] = TO_MESSAGE_BUTTON;
            array[2] = TO_DISCUSSION_BUTTON;
            array[3] = TO_NOTIFICATIONS_BUTTON;
            array[4] = TO_GUESTS_BUTTON;
            array[5] = TO_TOP_NEWS_FEEDBACK_BUTTON;
            array[6] = TO_MUSIC_BUTTON;
            return array;
        }

        public static SelenideElement getToMainButton() {
            return TO_MAIN_BUTTON;
        }

        public static SelenideElement getToMessageButton() {
            return TO_MESSAGE_BUTTON;
        }

        public static SelenideElement getToDiscussionButton() {
            return TO_DISCUSSION_BUTTON;
        }

        public static SelenideElement getToNotificationsButton() {
            return TO_NOTIFICATIONS_BUTTON;
        }

        public static SelenideElement getToGuestsButton() {
            return TO_GUESTS_BUTTON;
        }

        public static SelenideElement getToTopNewsFeedbackButton() {
            return TO_TOP_NEWS_FEEDBACK_BUTTON;
        }

        public static SelenideElement getToMusicButton() {
            return TO_MUSIC_BUTTON;
        }
    }

}
