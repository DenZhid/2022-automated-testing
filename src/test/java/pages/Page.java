package pages;

import com.codeborne.selenide.SelenideElement;

import utils.PageLoadException;

import static com.codeborne.selenide.Selenide.open;

public abstract class Page {

    final SelenideElement loadableElement;

    public Page(SelenideElement loadableElement) {
        this.loadableElement = loadableElement;
        check();
    }

    public Page(String url, SelenideElement loadableElement) {
        open(url);
        this.loadableElement = loadableElement;
        check();
    }

    /**
     * Проверка нахождения на нужной странице.
     */
    abstract void check() throws PageLoadException;

}