package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class UserGroupsPage extends BasePage {

    private final static SelenideElement USER_GROUPS_BLOCK = $(byXpath("//*[@id = 'hook_Block_MyGroupsTopBlock']"));

    public UserGroupsPage() {
        super("Can't open user groups", $(byId("hook_Block_UserGroupsPanelBlock")));
    }

    public boolean hasGroup(String groupId) {
        return USER_GROUPS_BLOCK.$("div[data-group-id='" + groupId + "']").isDisplayed();
    }
}
