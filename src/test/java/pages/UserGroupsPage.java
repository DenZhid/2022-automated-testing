package pages;

import org.openqa.selenium.By;

import utils.UserGroupsPageException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class UserGroupsPage extends Page {

    @Override
    void checkIfPresent() {
        sleep(500);
        if (!$(By.id("hook_Block_UserGroupsPanelBlock")).exists()) {
            throw new UserGroupsPageException("Invalid group page initialization");
        }
    }

    public boolean hasGroup(String groupId) {
        return $(By.xpath("//*[@id = 'hook_Block_MyGroupsTopBlock']//*[@data-group-id = '" + groupId + "']")).exists();
    }
}
