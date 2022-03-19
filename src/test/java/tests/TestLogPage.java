package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.LogPage;
import utils.NotLoggedException;
import utils.User;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLogPage extends ParentTest {
    private static User user;
    private final static String VK_EDU_GROUP_NAME = "Образовательный центр VK в Политехе";
    private final static String USER_PASSWORD = ""; // Не скажу, вставляейте свое
    private final static String USER_LOGIN = "89214538234"; // Ну номер ладно, оставлю

    @BeforeAll
    public static void createUser() {
        user = new User(USER_LOGIN, USER_PASSWORD);
    }

    // Тест: Логинимся на одноклассниках -> заходим в группу -> проверяем, что есть группа Технополиса
    @Test
    public void hasVKInPolyGroup() throws NotLoggedException {
        assertTrue(new LogPage(driver)
                .login(user)
                .goToGroups()
                .hasGroup(VK_EDU_GROUP_NAME)
        );
    }
}
