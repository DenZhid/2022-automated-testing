package pages.main;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainTopToolBar {
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