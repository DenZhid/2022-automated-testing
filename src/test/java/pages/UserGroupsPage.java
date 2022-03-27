package pages;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import utils.UserGroupsPageException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class UserGroupsPage extends Page {

    public final SelenideElement loadableElement = $(By.id("hook_Block_UserGroupsPanelBlock"));

    @Override
    void checkIfPresent() {
        sleep(500);
        if (!loadableElement.exists()) {
            throw new UserGroupsPageException("Invalid group page initialization");
        }
    }

    public boolean hasGroup(String groupId) {
        return $(By.xpath("//*[@id = 'hook_Block_MyGroupsTopBlock']//*[@data-group-id = '" + groupId + "']")).exists();
    }
}
