package pages;

import java.util.ArrayList;
import java.util.List;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends Page {

    private static final SelenideElement TO_GROUPS_BUTTON = $(byXpath("//*[@data-l = 't,userAltGroup']"));
    private static final SelenideElement TO_PHOTOS_BUTTON = $(byXpath("//*[@data-l = 't,userPhotos']"));
    private static final SelenideElement TO_USER_PROFILE_BUTTON = $(byXpath("//*[@data-l = 't,userPage']"));
    private static final SelenideElement AVATAR_ICON = $(byXpath("//img[@id='viewImageLinkId']"));

    public MainPage() {
        super("Main page init error", TO_USER_PROFILE_BUTTON);
    }

    public UserGroupsPage goToGroupsPage() {
        TO_GROUPS_BUTTON.should(visible).click();
        return new UserGroupsPage();
    }

    public GroupPage goToGroup(String groupId) {
        return new GroupPage(groupId);
    }

    public MusicPage goToMusic() {
        mainTopToolBar.getToMusicButton().should(visible).click();
        return new MusicPage();
    }

    public PhotoPage goToPhoto() {
        TO_PHOTOS_BUTTON.should(visible).click();
        return new PhotoPage();
    }

    public String getCurrentAvatarRef() {
        return AVATAR_ICON.getAttribute("src");
    }

    public static class mainTopToolBar {
        private static final SelenideElement TO_MESSAGE_BUTTON = $(byId("msg_toolbar_button"));
        private static final SelenideElement TO_DISCUSSION_BUTTON = $(byId("hook_ToolbarIconDiscussions_ToolbarDiscussions"));
        private static final SelenideElement TO_NOTIFICATIONS_BUTTON = $(byId("ntf_toolbar_button"));
        private static final SelenideElement TO_FRIENDS_BUTTON = $(byId("hook_Block_HeaderTopFriendsInToolbar"));
        private static final SelenideElement TO_GUESTS_BUTTON = $(byId("hook_Block_HeaderTopNewEventsInToolbar"));
        private static final SelenideElement TO_TOP_NEWS_FEEDBACK_BUTTON = $(byId("HeaderTopNewFeedbackInToolbar"));
        private static final SelenideElement TO_MUSIC_BUTTON = $(byId("toolbar_nav_i_ic"));

        public static List<SelenideElement> getAllTabs() {
            List<SelenideElement> list = new ArrayList<>();
            list.add(TO_MESSAGE_BUTTON);
            list.add(TO_DISCUSSION_BUTTON);
            list.add(TO_NOTIFICATIONS_BUTTON);
            list.add(TO_FRIENDS_BUTTON);
            list.add(TO_GUESTS_BUTTON);
            list.add(TO_TOP_NEWS_FEEDBACK_BUTTON);
            list.add(TO_MUSIC_BUTTON);
            return list;
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

        public static SelenideElement getToFriendsButton() {
            return TO_FRIENDS_BUTTON;
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
