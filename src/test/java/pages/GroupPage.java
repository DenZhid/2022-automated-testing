package pages;

import utils.PageNotLoadedException;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;

public class GroupPage extends Page {

    public final SelenideElement toMembers = $(byXpath("//*[@data-l='outlandermenu,altGroupMembers']"));

    public GroupPage(String url) {
        super(url, $(byId("hook_Block_AltGroupInfo")));
    }

    @Override
    void check() throws PageNotLoadedException {
        if (!loadableElement.shouldBe(visible).isDisplayed()) {
            throw new PageNotLoadedException("Invalid group page initialization");
        }
    }

    public String getName() {
        return $(byXpath("//*[@id='hook_Block_AltGroupInfo']//h1")).text();
    }

    public MembersGroupPage goToMembers() {
        toMembers.click();
        return new MembersGroupPage();
    }

    public GroupPage subscribe() {
        SelenideElement subBtn = $(byXpath("//*[@class='button-pro __wide']"));
        if (subBtn.exists()) {
            subBtn.click();
        }
        return this;
    }

    public GroupPage unsubscribe() {
        SelenideElement unsubBtn = $(byXpath("//*[@class='dropdown __wide h-mod']"));
        if (unsubBtn.exists()) {
            unsubBtn.click();
            $(byXpath("//*[@class='dropdown_cnt __wide __show']")).click();
        }
        return this;
    }

    public MainPage goToMain() {
        open("https://ok.ru/");
        return new MainPage();
    }

}
