package pages;

import utils.GroupPageException;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class GroupPage implements Page {

    public GroupPage() throws GroupPageException {
        if (!isPresent()) {
            throw new GroupPageException("Invalid group page initialization");
        }
    }

    @Override
    public boolean isPresent() {
        sleep(500);
        return $(By.id("hook_Block_UserGroupsPanelBlock")).exists();
    }

    public boolean hasGroup(String groupId) {
        return $(By.xpath("//*[@id = 'hook_Block_MyGroupsTopBlock']//*[@data-group-id = '" + groupId + "']")).exists();
    }
}
