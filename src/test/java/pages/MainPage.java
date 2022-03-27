package pages;

import org.openqa.selenium.By;

import utils.NotLoggedException;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends Page {

    @Override
    void checkIfPresent() {
        if (!$(By.xpath("//*[@data-l = 't,userPage']")).exists()) {
            throw new NotLoggedException("Invalid logging operation");
        }
    }

    public GroupPage goToGroups() {
        $(By.xpath("//*[@data-l = 't,userAltGroup']")).click();
        return new GroupPage();
    }

}
