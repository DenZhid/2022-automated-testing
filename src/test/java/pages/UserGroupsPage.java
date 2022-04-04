package pages;

import org.openqa.selenium.By;

import utils.PageLoadException;

import static com.codeborne.selenide.Selenide.$;

public class UserGroupsPage extends Page {

    public UserGroupsPage() throws PageLoadException {
        super("Can't open user groups",$(By.id("hook_Block_UserGroupsPanelBlock")));
    }

    public boolean hasGroup(String groupId) {
        return $(By.xpath("//*[@id = 'hook_Block_MyGroupsTopBlock']//*[@data-group-id = '" + groupId + "']")).exists();
    }
}
