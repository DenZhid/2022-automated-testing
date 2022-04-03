package pages;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import utils.GroupPageException;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GroupPage extends Page {

    public final SelenideElement toMembers = $(By.xpath("//*[@data-l='outlandermenu,altGroupMembers']"));

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

    public MembersGroupPage goToMembers() {
        toMembers.click();
        return new MembersGroupPage();
    }

    public GroupPage subscribe() {
        SelenideElement subBtn = $(By.xpath("//*[@class='button-pro __wide']"));
        if (subBtn.exists()) {
            subBtn.click();
        }
        return this;
    }

    public GroupPage unsubscribe() {
        SelenideElement unsubBtn = $(By.xpath("//*[@class='dropdown __wide h-mod']"));
        if (unsubBtn.exists()) {
            unsubBtn.click();
            $(By.xpath("//*[@class='dropdown_cnt __wide __show']")).click();
        }
        return this;
    }

    public MainPage goToMain() {
        open("https://ok.ru/");
        return new MainPage();
    }

}
