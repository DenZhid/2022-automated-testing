package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.LogPage;
import utils.User;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroupTest extends ParentTest {
    private static User user;
    private final static String GROUP_ID = "53245288710321"; // ID группы vk ude

    @BeforeAll
    public static void createUser() {
        user = new User(USER_LOGIN, USER_PASSWORD);
    }

    // Тест: Логинимся на одноклассниках -> заходим в группу -> проверяем, что есть группа Технополиса
    @Test
    public void hasVKInPolyGroup() {
        assertTrue(new LogPage()
                .login(user)
                .goToGroups()
                .hasGroup(GROUP_ID)
        );
    }
}
