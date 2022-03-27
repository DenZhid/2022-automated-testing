package pages;

import org.openqa.selenium.By;

import utils.PageLoadException;
import utils.UserGroupsPageException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class UserGroupsPage extends Page {

    public UserGroupsPage() throws PageLoadException {
        super($(By.id("hook_Block_UserGroupsPanelBlock")));
    }

    @Override
    void checkIfPresent() {
        sleep(500);
        if (!loadableElement.exists()) {
            throw new UserGroupsPageException("Invalid user groups page initialization");
        }
    }

    public boolean hasGroup(String groupId) {
        return $(By.xpath("//*[@id = 'hook_Block_MyGroupsTopBlock']//*[@data-group-id = '" + groupId + "']")).exists();
    }
}
