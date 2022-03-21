package tests;

import pages.LogPage;
import utils.User;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLogPage extends ParentTest {
    private static User user;
    private final static String GROUP_ID = "53245288710321"; // ID группы vk ude

    @BeforeAll
    public static void createUser() {
        user = new User(USER_LOGIN, USER_PASSWORD);
    }

    @Test
    public void hasVKInPolyGroup() throws Exception {
        assertTrue(new LogPage()
                .login(user)
                .goToGroups()
                .hasGroup(GROUP_ID)
        );
    }
}
