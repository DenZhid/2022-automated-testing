package pages;

import org.openqa.selenium.By;

import utils.GroupPageException;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class GroupPage implements Page {

    public GroupPage() throws GroupPageException {
        if (!isPresent()) {
            throw new GroupPageException("Invalid group page initialization");
        }
    }

    @Override
    public boolean isPresent() {
        return $(By.id("hook_Block_UserGroupsPanelBlock")).should(exist).exists();
    }

    public boolean hasGroup(String groupId) {
        return $(By.xpath("//*[@id = 'hook_Block_MyGroupsTopBlock']//*[@data-group-id = '" + groupId + "']")).exists();
    }
}
