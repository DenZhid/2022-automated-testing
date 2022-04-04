package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PhotoPage extends Page {

    private static final SelenideElement PHOTO_TABS_HEADER = $(byXpath("//div[@class='filter photo-vitrine-tabs']"));
    private static final SelenideElement CREATE_ALBUM_BUTTON = $(byXpath("//a[@data-l='t,create-photo-album']"));
    private static final SelenideElement ALBUM_NAME_EDIT_FIELD = $(byXpath("//textarea[@data-l='t,textField-editor']"));
    private static final SelenideElement CONFIRM_CREATING_ALBUM_BUTTON = $(byXpath("//input[@data-l='t,confirm']"));
    private static final SelenideElement BACK_TO_ROOT_PHOTO_PAGE_LINK = $(byXpath("//a[@data-l='t,root']"));
    private static final SelenideElement UPLOAD_PHOTO_BUTTON = $(byXpath("//span[@data-l='t,upload-new-photo']"));
    private static final ElementsCollection ALL_PHOTOS = $$(byXpath("//img[@class='photo-img__tt8r9']"));
    private static final SelenideElement AVATAR = $(byXpath("//img[@id='viewImageLinkId']"));

    public PhotoPage() {
        super("Photo page init error", PHOTO_TABS_HEADER);
    }

    public PhotoPage createAlbum(String albumName) {
        CREATE_ALBUM_BUTTON.click();
        ALBUM_NAME_EDIT_FIELD.should(visible).setValue(albumName);
        CONFIRM_CREATING_ALBUM_BUTTON.should(visible).click();
        BACK_TO_ROOT_PHOTO_PAGE_LINK.should(visible).click();
        return this;
    }

    public boolean hasCreatedAlbum(String albumName) {
        return $(byXpath("//div[@class='photo-album-card__cpony']" +
                "//a[@data-l='t,title']" +
                "[contains(text(), '"+ albumName +"')]"))
                .should(visible)
                .isDisplayed();
    }

    public void deleteAlbum() {

    }

    public void uploadPhoto(String fileName) {

    }

    public boolean hasUploadedPhoto() {
        return false;
    }

    public void deletePhoto() {

    }
}
