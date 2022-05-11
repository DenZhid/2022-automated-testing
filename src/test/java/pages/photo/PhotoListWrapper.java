package pages.photo;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;

public class PhotoListWrapper {

    private static final ElementsCollection DELETE_PHOTO_BUTTONS_LIST =
            $$(byXpath("//div[@data-l='t,photo-card']//a[@data-l='t,remove-photo']"));

    public SelenideElement getRemoveButtonByNumber(int index) {
        return DELETE_PHOTO_BUTTONS_LIST.get(index).shouldBe(visible);
    }
}
