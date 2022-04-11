package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.refresh;

public class EditAlbumPage extends Page {

    private static final SelenideElement ADD_MORE_PHOTO_BUTTON = $(byXpath("//div[@class='portlet_controls']"));
    private static final SelenideElement BACK_TO_EDIT_ALBUM = $(byXpath("//a[@data-l='t,back']"));
    private static final SelenideElement DELETE_ALBUM_LINK =
            $(byXpath("//a[@class='lp' and(text()='Удалить альбом')]"));
    private static final SelenideElement DELETE_ALBUM_BUTTON = $(byXpath("//input[@data-l='t,confirm']"));
    private static final SelenideElement EDIT_BUTTON = $(byXpath("//a[@data-l='t,editAlbum']"));
    private static final ElementsCollection DELETE_PHOTO_BUTTONS_LIST =
            $$(byXpath("//div[@data-l='t,photo-card']//a[@data-l='t,remove-photo']"));

    public EditAlbumPage() {
        super("Edit Album page init error", ADD_MORE_PHOTO_BUTTON);
    }

    public PhotoPage deleteAlbum() {
        EDIT_BUTTON.shouldBe(visible).click();
        DELETE_ALBUM_LINK.shouldBe(visible).click();
        DELETE_ALBUM_BUTTON.shouldBe(visible).click();
        return new PhotoPage();
    }

    public EditAlbumPage deletePhotoByNumber(int numberOfPhoto) {
        EDIT_BUTTON.shouldBe(visible).click();
        DELETE_PHOTO_BUTTONS_LIST.get(numberOfPhoto).shouldBe(visible).click();
        BACK_TO_EDIT_ALBUM.shouldBe(visible).click();
        return this;
    }
}
