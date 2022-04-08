package pages;

import java.io.File;
import java.time.Duration;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

public class PhotoPage extends Page {

    private static final ElementsCollection ALL_PHOTOS = $$(byXpath("//img[@class='photo-img__tt8r9']"));
    private static final SelenideElement ALBUM_NAME_EDIT_FIELD = $(byXpath("//textarea[@data-l='t,textField-editor']"));
    private static final SelenideElement BACK_TO_ROOT_PHOTO_PAGE_LINK = $(byXpath("//a[@data-l='t,root']"));
    private static final SelenideElement CONFIRM_AVATAR_BUTTON = $(byXpath("//button[contains(@class, 'core')]"));
    private static final SelenideElement CONFIRM_CREATING_ALBUM_BUTTON = $(byXpath("//input[@data-l='t,confirm']"));
    private static final SelenideElement CREATE_ALBUM_BUTTON = $(byXpath("//a[@data-l='t,create-photo-album']"));
    private static final SelenideElement END_OF_UPLOAD_INDICATOR =
            $(byXpath("//up-panel[@endohwcfl]//div[@end-rcs3rf]"));
    private static final SelenideElement INPUT_UPLOAD_PHOTO_FIELD =
            $(byXpath("//span[@data-l='t,upload-new-photo']//input"));
    private static final SelenideElement LAST_PHOTO_LINK = $(byXpath("//div[contains(@class, 'photo-card')]//a"));
    private static final SelenideElement PHOTO_TABS_HEADER = $(byXpath("//div[@class='filter photo-vitrine-tabs']"));
    private static final SelenideElement SET_AS_AVATAR_BUTTON =
            $(byXpath("//button[contains(@class, 'link')]//span[contains(text(), 'профиля')]"));
    private static final SelenideElement TO_EDIT_BUTTON =
            $(byXpath("//a[contains(@class, 'menu-item') and(not(contains(@class, 'primary')))]"));

    public PhotoPage() {
        super("Photo page init error", PHOTO_TABS_HEADER);
    }

    public PhotoPage createAlbum(String albumName) {
        CREATE_ALBUM_BUTTON.shouldBe(visible).click();
        ALBUM_NAME_EDIT_FIELD.shouldBe(visible, Duration.ofSeconds(10)).setValue(albumName);
        CONFIRM_CREATING_ALBUM_BUTTON.shouldBe(visible).click();
        BACK_TO_ROOT_PHOTO_PAGE_LINK.shouldBe(visible).click();
        return this;
    }

    public boolean hasCreatedAlbum(String albumName) {
        return $(byXpath("//div[@class='photo-album-card__cpony']" +
                "//a[@data-l='t,title']" +
                "[contains(text(), '" + albumName + "')]"))
                .shouldBe(visible)
                .isDisplayed();
    }

    public PhotoPage uploadPhoto(String path) {
        INPUT_UPLOAD_PHOTO_FIELD.shouldBe(exist).uploadFile(new File(path));
        END_OF_UPLOAD_INDICATOR.shouldBe(visible);
        refresh(); // Нужен для уверенности в прогрузке нового изображения
        return this;
    }

    public int getAllPhotosSize() {
        return ALL_PHOTOS.size();
    }

    public PhotoPage setAvatar() {
        LAST_PHOTO_LINK.shouldBe(exist).click();
        SET_AS_AVATAR_BUTTON.shouldBe(exist).click();
        CONFIRM_AVATAR_BUTTON.shouldBe(exist).click();
        return this;
    }

    public MainPage goToMain() {
        open("https://ok.ru/");
        return new MainPage();
    }

    public EditAlbumPage goToEditAlbumPage(String albumName) {
        $(byXpath("//a[text() = '"+ albumName +"']//../..//div[@data-l='t,show-action-menu']"))
                .shouldBe(visible).click();
        TO_EDIT_BUTTON.shouldBe(exist).click();
        return new EditAlbumPage();
    }
}
