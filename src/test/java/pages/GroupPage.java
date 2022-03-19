package pages;

import org.openqa.selenium.WebDriver;

public class GroupPage implements Page {
    private final WebDriver driver;

    public GroupPage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public boolean isPresent() {
        //TODO
        return true;
    }

    public boolean hasGroup(String groupName) {
        //TODO
        return false;
    }
}
