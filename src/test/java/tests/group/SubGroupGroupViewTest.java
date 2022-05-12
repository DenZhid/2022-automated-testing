package tests.group;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import pages.group.GroupPage;
import pages.LoginPage;
import tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubGroupGroupViewTest extends BaseTest {
    private final static String GROUP_ID = "53245288710321"; // ID группы vk edu
    private final static String GROUP_NAME = "Образовательный центр VK в Политехе";


    // Для теста в конфиге должен быть указан еще id пользователя
    // Тест: Логинимся на одноклассниках -> подписаться на группу если не подписан ->
    //       идем в участники -> проверяем что участник есть в группе
    @Test
    @Timeout(value = 10)
    @Tag("Groups")
    public void groupHasUserInMembers() {
        GroupPage page = new LoginPage().login(user).goToGroup(GROUP_ID);

        assertEquals(GROUP_NAME, page.getName());
        assertTrue(page
                .subscribe()
                .goToMembers()
                .hasUser(user)
        );
    }

}
