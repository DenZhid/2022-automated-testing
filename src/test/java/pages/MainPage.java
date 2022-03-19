package pages;

import org.openqa.selenium.WebDriver;
import utils.NotLoggedException;

public class MainPage implements Page {
    private final WebDriver driver;

    public MainPage(WebDriver driver) throws NotLoggedException {
        //В конструкторе проверяется залогинились ли мы
        if (!isPresent()) {
            throw new NotLoggedException();
        }
        this.driver = driver;
    }

    @Override
    public boolean isPresent() {
        //TODO
        return true;
    }

    public GroupPage goToGroups() {
        //TODO
        return new GroupPage(driver);
    }
}
