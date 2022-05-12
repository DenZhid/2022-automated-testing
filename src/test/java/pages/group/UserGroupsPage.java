package pages.group;

import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import pages.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class UserGroupsPage extends BasePage {

    private final static SelenideElement USER_GROUPS_BLOCK = $(byXpath("//*[@id = 'hook_Block_MyGroupsTopBlock']"));
    private final static SelenideElement GROUP_SEARCH_INPUT = $(byXpath("//*[@id='hook_Block_UserGroupsCatalogHeaderBlock']//input"));

    public UserGroupsPage() {
        super("Can't open user groups", $(byId("hook_Block_UserGroupsPanelBlock")));
    }

    public GroupPage openGroup(String groupId) {
        GROUP_SEARCH_INPUT.should(visible).setValue(groupId).pressEnter();
        USER_GROUPS_BLOCK.$("div[data-group-id='" + groupId + "']").should(visible).click();
        return new GroupPage();
    }

    public boolean hasGroup(String groupId) {
        return USER_GROUPS_BLOCK.$("div[data-group-id='" + groupId + "']").isDisplayed();
    }


}
