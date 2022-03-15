package pages;

import utils.NotLoggedException;
import utils.User;

public class LogPage implements Page {

    @Override
    public boolean isPresent() {
        //TODO
        return true;
    }

    public MainPage login(User user) throws NotLoggedException {
        //TODO
        return new MainPage();
    }

}
