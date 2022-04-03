package pages;

import com.codeborne.selenide.SelenideElement;

import utils.PageLoadException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PhotoPage extends Page {

    private static final SelenideElement CREATE_ALBUM_BUTTON = $(byXpath("//a[@data-l='t,create-photo-album']"));
    private static final SelenideElement ALBUM_NAME_EDIT_FIELD = $(byXpath("//textarea[@data-l='t,textField-editor']"));
    private static final SelenideElement CONFIRM_CREATING_ALBUM_BUTTON = $(byXpath("//input[@data-l='t,confirm']"));
    private static final SelenideElement BACK_TO_ROOT_PHOTO_PAGE_LINK = $(byXpath("//a[@data-l='t,root']"));
    private static final SelenideElement ALBUM_TITLE =
            $(byXpath("//div[@class='photo-album-card__cpony']//a[@data-l='t,title'][contains(text(), 'TestAlbum')]"));
    private static final SelenideElement UPLOAD_PHOTO_BUTTON = $(byXpath("//span[@data-l='t,upload-new-photo']"));

    public PhotoPage() {
        super($(byXpath("//div[@class='filter photo-vitrine-tabs']")));
    }

    @Override
    void checkIfPresent() throws PageLoadException {
        if (!loadableElement.isDisplayed()) {
            throw new PageLoadException("Photo page hasn't been displayed");
        }
    }

    public PhotoPage createAlbum(String albumName) {
        CREATE_ALBUM_BUTTON.should(visible).click();
        ALBUM_NAME_EDIT_FIELD.should(visible).setValue(albumName);
        CONFIRM_CREATING_ALBUM_BUTTON.should(visible).click();
        BACK_TO_ROOT_PHOTO_PAGE_LINK.should(visible).click();
        return this;
    }

    public boolean hasCreatedAlbum(String albumName) {
        return ALBUM_TITLE.isDisplayed();
    }

    public void deleteAlbum() {

    }

    public void uploadPhoto() {

    }
}
