package pages;

import utils.PageLoadException;

abstract class Page {

    public Page() throws PageLoadException {
        checkIfPresent();
    }

    /** Проверка нахождения на нужной странице. */
    abstract void checkIfPresent() throws PageLoadException;

}