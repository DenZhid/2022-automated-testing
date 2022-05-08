package tests.music;

import org.junit.jupiter.api.Timeout;
import pages.LoginPage;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static tests.music.SongConstants.*;

public class MusicSearchTest extends BaseTest {
    // Тест: логинимся -> идем в окно с музыкой -> ищем в поиске песню -> проверяем, что она есть
    @Test
    @Timeout(value = 10)
    @Tag("Music")
    public void groupHasSoundInPreviewTest() {
        assertTrue(new LoginPage()
                .login(user)
                .goToMusic()
                .search(FIRST_GROUP_NAME + " " + FIRST_SONG_NAME)
                .checkHasSong(FIRST_SONG_NAME)
        );
    }

    // Тест: логинимся -> идем в окно с музыкой -> ищем в поиске группу -> переходим к ней -> ищем песню
    @Test
    @Timeout(value = 10)
    @Tag("Music")
    public void groupHasSoundTest() {
        assertTrue(new LoginPage()
                .login(user)
                .goToMusic()
                .search(SECOND_GROUP_NAME)
                .goToBestMatchArtist()
                .checkHasSong(SECOND_SONG_NAME)
        );
    }

}
