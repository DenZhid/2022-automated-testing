package pages;

import com.codeborne.selenide.SelenideElement;

import utils.PageNotLoadedException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public abstract class BasePage {

    protected final SelenideElement[] loadableElements;
    private final String errorMessage;

    public BasePage(String errorMessage, SelenideElement... loadableElement) {
        this.errorMessage = errorMessage;
        this.loadableElements = loadableElement;
        check();
    }

    public BasePage(String errorMessage, String url, SelenideElement... loadableElement) {
        open(url);
        this.errorMessage = errorMessage;
        this.loadableElements = loadableElement;
        check();
    }

    /**
     * Проверка нахождения на нужной странице.
     */
    void check() throws PageNotLoadedException {
        for (SelenideElement loadableElement : loadableElements) {
            if (!loadableElement.should(visible).isDisplayed()) {
                throw new PageNotLoadedException(errorMessage, loadableElement);
            }
        }
    }

}