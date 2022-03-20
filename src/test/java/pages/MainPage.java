package pages;

import org.openqa.selenium.By;

import utils.GroupPageException;
import utils.NotLoggedException;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class MainPage implements Page {

    public MainPage() throws NotLoggedException {
        //В конструкторе проверяется залогинились ли мы
        if (!isPresent()) {
            throw new NotLoggedException("Invalid logging operation");
        }
    }

    @Override
    public boolean isPresent() {
        return $(By.xpath("//*[@data-l = 't,userPage']")).should(exist).exists();
    }

    public GroupPage goToGroups() throws GroupPageException {
        $(By.xpath("//*[@data-l = 't,userAltGroup']")).click();
        return new GroupPage();
    }
}
