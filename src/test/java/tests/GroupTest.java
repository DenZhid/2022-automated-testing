package tests;

import org.junit.jupiter.api.Timeout;
import pages.GroupPage;
import pages.LogPage;
import utils.User;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
    @Timeout(value = 10)
    @Tag("Groups")
    public void userHasGroupInGroupsTest() {
        assertTrue(new LogPage()
                .login(user)
                .goToGroupsPage()
                .hasGroup(GROUP_ID)
        );
    }

    // Тест: Заходим в группу по ссылке -> проверяем, имя группы
    @Test
    @Timeout(value = 10)
    @Tag("Groups")
    public void groupNameTest() {
        assertEquals(GROUP_NAME, new GroupPage(GROUP_ID).getName());
    }

    // Тест: Логинимся на одноклассниках -> заходим в группу -> идем в участники -> проверяем что участник есть в группе
    @Test
    @Timeout(value = 10)
    @Tag("Groups")
    public void groupHasUserInMembers() {
        assertTrue(new LogPage()
                .login(user)
                .goToGroup(GROUP_ID)
                .goToMembers()
                .hasUser(someUser)
        );
    }

    // Тест: Логин -> подписаться на группу если не подписан -> проверить что группа отображается в группах юзера ->
    //       Отписаться от группы -> проверить что группа не отображается в группах юзера
    @ParameterizedTest
    @Tag("Groups")
    @Timeout(value = 10)
    @ValueSource(strings = {"59289969557563", "59293922885670"})
    public void groupSubUnsubTest(String groupId) {
        assertTrue(new LogPage()
                .login(user)
                .goToGroup(groupId)
                .subscribe()
                .goToMain()
                .goToGroupsPage()
                .hasGroup(groupId)
        );

        assertFalse(new GroupPage(groupId)
                .unsubscribe()
                .goToMain()
                .goToGroupsPage()
                .hasGroup(groupId)
        );
    }

}
