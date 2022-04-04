package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MusicPage extends Page {
    private final static SelenideElement ARTIST_IMAGE_OVERLAY = $(byXpath("//a[@slot = 'image-overlay']"));
    private final static SelenideElement SEARCH_INPUT = $(byXpath("//input[@placeholder = 'Поиск']"));
    private final static SelenideElement MY_MUSIC_BUTTON = $(byXpath("//a[@data-l= 't,library']"));
    private static final SelenideElement PLAY_BUTTON = $(byXpath("//*[@class='play __active']"));

    public MusicPage() {
        super("Music page init error", PLAY_BUTTON);
    }

    public MusicPage search(String query) {
        SEARCH_INPUT.should(visible).setValue(query).pressEnter();
        return this;
    }

    public boolean checkHasSong(String songName) {
        return $(byLinkText(songName)).exists();
    }

    public MusicPage goToBestMatchArtist() {
        ARTIST_IMAGE_OVERLAY.should(visible).click();
        return this;
    }

    public MusicPage toMyMusic() {
        MY_MUSIC_BUTTON.should(visible).click();
        return this;
    }
}
