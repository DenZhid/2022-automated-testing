package pages;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import utils.NotLoggedException;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends Page {

    public final SelenideElement loadableElement = $(By.xpath("//*[@data-l = 't,userPage']"));

    @Override
    void checkIfPresent() {
        if (!loadableElement.exists()) {
            throw new NotLoggedException("Invalid logging operation");
        }
    }

    public UserGroupsPage goToGroups() {
        $(By.xpath("//*[@data-l = 't,userAltGroup']")).click();
        return new UserGroupsPage();
    }

}
