package pages;

import utils.PageNotLoadedException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class MusicPage extends Page{

    public MusicPage() {
        super($(byXpath("//*[@class='play __active']")));
    }

    @Override
    void check() {
        if (!loadableElement.shouldBe(visible).isDisplayed()) {
            throw new PageNotLoadedException("Invalid music page initialization");
        }
    }

    public MusicPage search(String query) {
        $(byXpath("//input[@placeholder = 'Поиск']")).setValue(query);//.pressEnter();
        sleep(500);
        $(byXpath("//input[@placeholder = 'Поиск']")).pressEnter();
        sleep(500);
        return this;
    }

    public boolean checkHasSong(String songName) {
        return $(byLinkText(songName)).exists();
    }

    public MusicPage goToBestMatchArtist() {
        $(byXpath("//a[@slot = 'image-overlay']")).click();
        sleep(500);
        return this;
    }

    public MusicPage toMyMusic() {
        $(byXpath("//a[@data-l= 't,library']")).click();
        sleep(500);
        return this;
    }
}
