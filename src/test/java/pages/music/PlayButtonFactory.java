package pages.music;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

class PlayButtonFactory {
    private static final SelenideElement PLAYING_TRACK = $(byXpath("//*[@data-tsid='playing_track']"));
    private static final SelenideElement PLAY_BUTTON_WITH_PLAYING_TRACK = $(byXpath("//*[@class='play __active']"));
    private static final SelenideElement PLAY_BUTTON_WITHOUT_PLAYING_TRACK
            = $(byXpath("//*[@data-tsid='music_player_controls']//*[@data-tsid='play_button']"));

    static SelenideElement getPlayButton() {
        if (PLAYING_TRACK.exists()) {
            return PLAY_BUTTON_WITH_PLAYING_TRACK;
        }

        return PLAY_BUTTON_WITHOUT_PLAYING_TRACK;
    }
}
