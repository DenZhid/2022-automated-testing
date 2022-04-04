package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GroupPage extends Page {

    private final static SelenideElement TO_MEMBERS_BUTTON = $(byXpath("//*[@data-l='outlandermenu,altGroupMembers']"));
    private final static SelenideElement GROUP_SUBSCRIBE_BUTTON = $(byXpath("//*[@class='button-pro __wide']"));
    private final static SelenideElement IN_THE_GROUP_ACTION_BUTTON = $(byXpath("//*[@class='dropdown __wide h-mod']"));
    private final static SelenideElement GROUP_UNSUB_BUTTON = $(byXpath("//*[@class='dropdown_cnt __wide __show']"));
    private final static SelenideElement GROUP_NAME = $(byXpath("//*[@id='hook_Block_AltGroupInfo']//h1"));

    public GroupPage() {
        super("Group page init error", $(byId("hook_Block_AltGroupInfo")));
    }

    public GroupPage(String url) {
        super("Can't load group with url: " + url, url, $(byId("hook_Block_AltGroupInfo")));
    }

    public String getName() {
        return GROUP_NAME.text();
    }

    public MembersGroupPage goToMembers() {
        TO_MEMBERS_BUTTON.click();
        return new MembersGroupPage();
    }

    public GroupPage subscribe() {
        if (GROUP_SUBSCRIBE_BUTTON.exists()) {
            GROUP_SUBSCRIBE_BUTTON.click();
        }
        return this;
    }

    public GroupPage unsubscribe() {
        if (IN_THE_GROUP_ACTION_BUTTON.exists()) {
            IN_THE_GROUP_ACTION_BUTTON.click();
            GROUP_UNSUB_BUTTON.click();
        }
        return this;
    }

    public MainPage goToMain() {
        open("https://ok.ru/");
        return new MainPage();
    }

}
