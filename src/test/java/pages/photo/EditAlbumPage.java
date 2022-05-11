package pages.photo;

import pages.BasePage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class EditAlbumPage extends BasePage {

    private static final SelenideElement ADD_MORE_PHOTO_BUTTON = $(byXpath("//div[@class='portlet_controls']"));
    private static final SelenideElement BACK_TO_EDIT_ALBUM = $(byXpath("//a[@data-l='t,back']"));
    private static final SelenideElement DELETE_ALBUM_LINK =
            $(byXpath("//a[@class='lp' and(text()='Удалить альбом')]"));
    private static final SelenideElement DELETE_ALBUM_BUTTON = $(byXpath("//input[@data-l='t,confirm']"));
    private static final SelenideElement EDIT_BUTTON = $(byXpath("//a[@data-l='t,editAlbum']"));


    public EditAlbumPage() {
        super("Edit Album page init error", ADD_MORE_PHOTO_BUTTON);
    }

    public void deleteAlbum() {
        EDIT_BUTTON.shouldBe(visible).click();
        DELETE_ALBUM_LINK.shouldBe(visible).click();
        DELETE_ALBUM_BUTTON.shouldBe(visible).click();
    }

    public void deletePhotoByNumber(int numberOfPhoto) {
        EDIT_BUTTON.shouldBe(visible).click();
        PhotoListWrapper listOfPhotos = new PhotoListWrapper();
        listOfPhotos.getRemoveButtonByNumber(numberOfPhoto).click();
        BACK_TO_EDIT_ALBUM.shouldBe(visible).click();
    }
}
