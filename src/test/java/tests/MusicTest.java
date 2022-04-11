package tests;

import pages.LogPage;
import pages.MusicPage;
import utils.User;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
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
    @Tag("Music")
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
    @Tag("Music")
    public void groupHasSoundTest() {
        assertTrue(new LogPage()
                .login(user)
                .goToMusic()
                .search(SECOND_GROUP_NAME)
                .goToBestMatchArtist()
                .checkHasSong(SECOND_SONG_NAME)
        );
    }

    // Тест: логинимся -> идем в окно с музыкой -> ищем песню -> добавляем ->
    // -> своя музыка -> проверяем, что там есть песня -> удаляем
    @Test
    @Tag("Music")
    public void myMusicTest() {
        MusicPage init = new LogPage()
                .login(user)
                .goToMusic();

        MusicPage myMusic = init
                .search(FIRST_GROUP_NAME + " " + FIRST_SONG_NAME)
                .addMusic(FIRST_SONG_NAME)
                .toMyMusic();

        assertTrue(myMusic.checkHasSong(FIRST_SONG_NAME));
        myMusic.deleteSong(FIRST_SONG_NAME);
    }
}
