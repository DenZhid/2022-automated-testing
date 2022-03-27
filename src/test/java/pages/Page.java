package pages;

import com.codeborne.selenide.SelenideElement;

import utils.PageLoadException;

import static com.codeborne.selenide.Selenide.open;

abstract class Page {

    public final SelenideElement loadableElement;

    public Page(SelenideElement loadableElement) throws PageLoadException {
        this.loadableElement = loadableElement;
        checkIfPresent();
    }

    public Page(String url, SelenideElement loadableElement) throws PageLoadException {
        open(url);
        this.loadableElement = loadableElement;
        checkIfPresent();
    }

    /**
     * Проверка нахождения на нужной странице.
     */
    abstract void checkIfPresent() throws PageLoadException;

}