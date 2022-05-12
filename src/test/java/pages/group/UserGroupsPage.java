package pages.group;

import com.codeborne.selenide.SelenideElement;

import pages.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class UserGroupsPage extends BasePage {

    private final static SelenideElement USER_GROUPS_BLOCK = $(byXpath("//*[@id='hook_Block_UserGroupsPanelBlock']"));
    private final static SelenideElement GROUP_SEARCH_INPUT = $(byXpath("//*[@id='hook_Block_UserGroupsCatalogHeaderBlock']//input"));

    private final static SelenideElement GROUP_SEARCH_SUBMIT_BUTTON = $(byXpath("//*[@id='hook_Block_UserGroupsCatalogHeaderBlock']//*[@data-icon-name='ico_search_16']"));

    public UserGroupsPage() {
        super("Can't open user groups", $(byId("hook_Block_UserGroupsPanelBlock")));
    }

    public GroupPage openGroup(String groupId) {
        // Не работает ни пресс ентер ни клик на лупу что то из этого удалить
        GROUP_SEARCH_INPUT.should(visible).setValue(groupId).pressEnter();// пресс ентер
//        GROUP_SEARCH_SUBMIT_BUTTON.should(visible).click();// клик на лупу
        USER_GROUPS_BLOCK.$(byXpath("a[contains (@hrefattrs,'" + groupId + "')]")).should(visible).click();
        return new GroupPage();
    }

    public boolean hasGroup(String groupId) {
        return USER_GROUPS_BLOCK.$("div[data-group-id='" + groupId + "']").isDisplayed();
    }


}
