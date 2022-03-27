package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pages.GroupPage;
import pages.LogPage;
import utils.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroupTest extends ParentTest {
    private static User user;
    private static final User someUser = new User(563756113404L);
    private final static String GROUP_ID = "53245288710321"; // ID группы vk edu
    private final static String GROUP_NAME = "Образовательный центр VK в Политехе";

    @BeforeAll
    public static void createUser() {
        user = new User(USER_LOGIN, USER_PASSWORD);
    }

    // Тест: Логинимся на одноклассниках -> заходим на страницу групп юзера -> проверяем, что есть группа Технополиса
    @Test
    public void userHasGroupInGroupsTest() {
        assertTrue(new LogPage()
                .login(user)
                .goToGroupsPage()
                .hasGroup(GROUP_ID)
        );
    }

    // Тест: Заходим в группу по ссылке -> проверяем, имя группы
    @Test
    public void groupNameTest() {
        assertEquals(GROUP_NAME, new GroupPage("https://ok.ru/group/" + GROUP_ID).getName());
    }

    // Тест: Логинимся на одноклассниках -> заходим в группу -> идем в участники -> проверяем что участник есть в группе
    @Test
    public void groupHasUserInMembers() {
        assertTrue(new LogPage()
                .login(user)
                .goToGroup(GROUP_ID)
                .goToMembers()
                .hasUser(someUser)
        );
    }


}
