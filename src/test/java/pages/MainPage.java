package pages;

import utils.NotLoggedException;

public class MainPage implements Page {

    public MainPage() throws NotLoggedException {
        //В конструкторе проверяется залогинились ли мы
        if (!isPresent()) {
            throw new NotLoggedException();
        }
    }

    @Override
    public boolean isPresent() {
        //TODO
        return true;
    }

}
