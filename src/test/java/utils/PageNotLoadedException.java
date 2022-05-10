package utils;

import com.codeborne.selenide.SelenideElement;

public class PageNotLoadedException extends RuntimeException {

    public PageNotLoadedException(String message, SelenideElement loadableElement) {
        super(message + " (cannot find loadable element " + loadableElement.toString() + ")");
    }

}

