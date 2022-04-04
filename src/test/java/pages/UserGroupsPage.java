package pages;

import utils.PageNotLoadedException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class UserGroupsPage extends Page {

    public UserGroupsPage() {
        super($(byId("hook_Block_UserGroupsPanelBlock")));
    }

    @Override
    void check() {
        if (!loadableElement.shouldBe(visible).isDisplayed()) {
            throw new PageNotLoadedException("Invalid user groups page initialization");
        }
    }

    public boolean hasGroup(String groupId) {
        return $(byXpath("//*[@id = 'hook_Block_MyGroupsTopBlock']//*[@data-group-id = '" + groupId + "']")).exists();
    }
}
