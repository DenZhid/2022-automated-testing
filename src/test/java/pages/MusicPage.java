package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MusicPage extends Page {
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

    private static class MusicToolbar {
        private static final SelenideElement SEARCH_INPUT = $(byXpath("//input[@placeholder = 'Поиск']"));
        private static final SelenideElement SEARCH_SUBMIT_BUTTON
                = $(byXpath("//*[@data-l='t,suggests']/*[@data-l='t,submit']"));

        private static SelenideElement getPlayButton() {
            return PlayButtonFactory.getPlayButton();
        }

        private static void search(String query) {
            SEARCH_INPUT.should(visible).setValue(query);
            SEARCH_SUBMIT_BUTTON.should(visible).click();
        }

        private static class PlayButtonFactory {
            private static final SelenideElement PLAYING_TRACK = $(byXpath("//*[@data-tsid='playing_track']"));
            private static final SelenideElement PLAY_BUTTON_WITH_PLAYING_TRACK = $(byXpath("//*[@class='play __active']"));
            private static final SelenideElement PLAY_BUTTON_WITHOUT_PLAYING_TRACK
                    = $(byXpath("//*[@data-tsid='music_player_controls']//*[@data-tsid='play_button']"));

            private static SelenideElement getPlayButton() {
                if (PLAYING_TRACK.exists()) {
                    return PLAY_BUTTON_WITH_PLAYING_TRACK;
                }

                return PLAY_BUTTON_WITHOUT_PLAYING_TRACK;
            }
        }
    }
}
