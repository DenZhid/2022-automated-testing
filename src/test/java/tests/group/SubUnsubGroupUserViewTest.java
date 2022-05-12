package tests.group;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import pages.group.GroupPage;
import pages.LoginPage;
import pages.group.UserGroupsPage;
import tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubUnsubGroupUserViewTest extends BaseTest {

    // Тест: Логин -> подписаться на группу если не подписан -> проверить что группа отображается в группах юзера ->
    //       Отписаться от группы -> проверить что группа не отображается в группах юзера
    @ParameterizedTest
    @Tag("Groups")
    @Timeout(value = 15)
    @ValueSource(strings = {"59289969557563", "59293922885670"})
    public void groupSubUnsubTest(String groupId) {
        UserGroupsPage page = new LoginPage()
                .login(user)
                .goToGroup(groupId)
                .subscribe()
                .goToMain()
                .goToGroupsPage();

        assertTrue(page.hasGroup(groupId));

        assertFalse(page
                .openGroup(groupId)
                .unsubscribe()
                .goToMain()
                .goToGroupsPage()
                .hasGroup(groupId)
        );
    }

}
