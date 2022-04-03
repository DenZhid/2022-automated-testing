package pages;

import utils.NotLoggedException;
import utils.PageLoadException;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends Page {

    private static final SelenideElement TO_GROUPS_BUTTON = $(byXpath("//*[@data-l = 't,userAltGroup']"));
    private static final SelenideElement TO_MUSIC_BUTTON = $(byXpath("//*[@data-l = 't,music']"));
    private static final SelenideElement TO_PHOTOS_BUTTON = $(byXpath("//a[@data-l = 't,userPhotos']"));

    public MainPage() throws PageLoadException {
        super($(byXpath("//*[@data-l = 't,userPage']")));
    }

    @Override
    void checkIfPresent() {
        if (!loadableElement.exists()) {
            throw new NotLoggedException("Invalid logging operation");
        }
    }

    public UserGroupsPage goToGroupsPage() {
        TO_GROUPS_BUTTON.click();
        return new UserGroupsPage();
    }

    public GroupPage goToGroup(String groupId) {
        return new GroupPage("https://ok.ru/group/" + groupId);
    }

    public MusicPage goToMusic() {
        TO_MUSIC_BUTTON.click();
        return new MusicPage();
    }

    public PhotoPage goToPhoto() {
        TO_PHOTOS_BUTTON.click();
        return new PhotoPage();
    }
}
