package tests;

import org.junit.jupiter.api.Timeout;
import pages.LogPage;
import pages.MusicPage;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MusicTest extends BaseTest {
    private static final String FIRST_GROUP_NAME = "Nothing But Thieves";
    private static final String FIRST_SONG_NAME = "Amsterdam";

    private static final String SECOND_GROUP_NAME = "System Of A Down";
    private static final String SECOND_SONG_NAME = "Aerials";

    // Тест: логинимся -> идем в окно с музыкой -> ищем в поиске песню -> проверяем, что она есть
    @Test
    @Timeout(value = 10)
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
    @Timeout(value = 10)
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
    @Timeout(value = 10)
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
