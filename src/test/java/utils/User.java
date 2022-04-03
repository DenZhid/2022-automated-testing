package utils;

public class User {
    private String password;
    private String login;
    public Long id;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(Long id) {
        this.id = id;
    }

    public User(String login, String password, Long id) {
        this.login = login;
        this.password = password;
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }
}
