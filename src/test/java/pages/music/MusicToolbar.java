package pages.music;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

class MusicToolbar {
    private static final SelenideElement SEARCH_INPUT = $(byXpath("//input[@placeholder = 'Поиск']"));
    private static final SelenideElement SEARCH_SUBMIT_BUTTON
            = $(byXpath("//*[@data-l='t,suggests']/*[@data-l='t,submit']"));

    static SelenideElement getPlayButton() {
        return PlayButtonFactory.getPlayButton();
    }

    static void search(String query) {
        SEARCH_INPUT.should(visible).setValue(query);
        SEARCH_SUBMIT_BUTTON.should(visible).click();
    }

}
