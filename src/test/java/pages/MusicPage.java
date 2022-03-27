package pages;

import org.openqa.selenium.By;
import utils.MusicPageException;
import utils.PageLoadException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class MusicPage extends Page{

    public MusicPage() throws PageLoadException {
        super($(By.xpath("//*[@class='play __active']")));
    }

    @Override
    void checkIfPresent() {
        sleep(500);
        if (!loadableElement.exists()) {
            throw new MusicPageException("Invalid music page initialization");
        }
    }

    public MusicPage search(String query) {
        $(By.xpath("//input[@placeholder = 'Поиск']")).setValue(query);//.pressEnter();
        sleep(500);
        $(By.xpath("//input[@placeholder = 'Поиск']")).pressEnter();
        sleep(500);
        return this;
    }

    public boolean checkHasSong(String songName) {
        return $(By.linkText(songName)).exists();
    }

    public MusicPage goToBestMatchArtist() {
        $(By.xpath("//a[@slot = 'image-overlay']")).click();
        sleep(500);
        return this;
    }

    public MusicPage toMyMusic() {
        $(By.xpath("//a[@data-l= 't,library']")).click();
        sleep(500);
        return this;
    }
}
