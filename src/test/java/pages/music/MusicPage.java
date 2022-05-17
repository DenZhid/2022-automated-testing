package pages.music;

import com.codeborne.selenide.SelenideElement;

import pages.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MusicPage extends BasePage {
    private static final SelenideElement ARTIST_IMAGE_OVERLAY = $(byXpath("//a[@slot = 'image-overlay']"));
    private static final SelenideElement MY_MUSIC_BUTTON = $(byXpath("//a[@data-l= 't,library']"));
    private static final SelenideElement ADD_BUTTON
            = $(byXpath("//*[@name='controls']//*[@title='Добавить в мою музыку']"));
    private static final SelenideElement DELETE_BUTTON
            = $(byXpath("//*[@name='controls']//*[@data-tsid='remove_track']"));

    public MusicPage() {
        super("Music page init error", MusicToolbar.getPlayButton());
    }

    public MusicPage search(String query) {
        MusicToolbar.search(query);
        return this;
    }

    public boolean checkHasSong(String songName) {
        return $(byLinkText(songName)).should(visible).exists();
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
        $(byLinkText(songName)).should(visible).hover();
        ADD_BUTTON.should(visible).click();
        return this;
    }

    public void deleteSong(String songName) {
        $(byLinkText(songName)).should(visible).hover();
        DELETE_BUTTON.should(visible).click();
    }

}
