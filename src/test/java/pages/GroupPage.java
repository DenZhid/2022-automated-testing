package pages;

import org.openqa.selenium.By;

import utils.GroupPageException;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class GroupPage extends Page {

    public GroupPage(String url) {
        super(url, $(byId("hook_Block_AltGroupInfo")));
    }

    @Override
    void checkIfPresent() {
        if (!loadableElement.exists()) {
            throw new GroupPageException("Invalid group page initialization");
        }
    }

    public String getName() {
        return $(By.xpath("//*[@id='hook_Block_AltGroupInfo']//h1")).text();
    }

}
