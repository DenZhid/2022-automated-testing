package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class MusicPage extends Page {
    private static final SelenideElement ARTIST_IMAGE_OVERLAY = $(byXpath("//a[@slot = 'image-overlay']"));
    private static final SelenideElement SEARCH_INPUT = $(byXpath("//input[@placeholder = 'Поиск']"));
    private static final SelenideElement MY_MUSIC_BUTTON = $(byXpath("//a[@data-l= 't,library']"));
    private static final SelenideElement PLAY_BUTTON = $(byXpath("//*[@class='play __active']"));
    private static final SelenideElement ADD_BUTTON = $(byXpath("//*[@name='controls']//*[@title='Добавить в мою музыку']"));
    private static final SelenideElement DELETE_BUTTON = $(byXpath("//*[@name='controls']//*[@data-tsid='remove_track']"));

    public MusicPage() {
        super("Music page init error", PLAY_BUTTON);
    }

    public MusicPage search(String query) {
        SEARCH_INPUT.should(visible).setValue(query);
        sleep(100);
        SEARCH_INPUT.pressEnter();
        return this;
    }

    public boolean checkHasSong(String songName) {
        return $(byLinkText(songName)).shouldBe(visible).exists();
    }

    public MusicPage goToBestMatchArtist() {
        ARTIST_IMAGE_OVERLAY.should(visible).click();
        return this;
    }

    public MusicPage toMyMusic() {
        MY_MUSIC_BUTTON.should(visible).click();
        return this;
    }

    public MusicPage addMusic(String songName) {
        $(byLinkText(songName)).shouldBe(visible).hover();
        ADD_BUTTON.should(visible).click();
        return this;
    }

    public void deleteSong(String songName) {
        $(byLinkText(songName)).shouldBe(visible).hover();
        DELETE_BUTTON.should(visible).click();
    }
}