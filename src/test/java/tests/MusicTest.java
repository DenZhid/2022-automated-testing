package tests;

import pages.LogPage;
import utils.User;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MusicTest extends ParentTest {
    private static final String FIRST_GROUP_NAME = "Nothing But Thieves";
    private static final String FIRST_SONG_NAME = "Amsterdam";

    private static final String SECOND_GROUP_NAME = "System Of A Down";
    private static final String SECOND_SONG_NAME = "Aerials";

    private static User user;

    @BeforeAll
    public static void createUser() {
        user = new User(USER_LOGIN, USER_PASSWORD);
    }

    // Тест: логинимся -> идем в окно с музыкой -> ищем в поиске песню -> проверяем, что она есть
    @Test
    public void groupHasSoundInPreviewTest() {
        assertTrue(new LogPage()
                .login(user)
                .goToMusic()
                .search(FIRST_GROUP_NAME + " " + FIRST_SONG_NAME)
                .checkHasSong(FIRST_SONG_NAME)
        );
    }

    // Тест: логинимся -> идем в окно с музыкой -> ищем в поиске группу -> переходим к ней -> ищем песню
    @Test
    public void groupHasSoundTest() {
        assertTrue(new LogPage()
                .login(user)
                .goToMusic()
                .search(SECOND_GROUP_NAME)
                .goToBestMatchArtist()
                .checkHasSong(SECOND_SONG_NAME)
        );
    }

    // Тест: логинимся -> идем в окно с музыкой -> своя музыка -> проверяем, что там есть песня
    @Test
    public void myMusicTest() {
        assertTrue(new LogPage()
                .login(user)
                .goToMusic()
                .toMyMusic()
                .checkHasSong(FIRST_SONG_NAME));
    }
}
