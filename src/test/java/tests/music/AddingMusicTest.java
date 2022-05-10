package tests.music;

import org.junit.jupiter.api.*;
import pages.LoginPage;
import pages.music.MusicPage;
import tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static tests.music.SongConstants.*;

public class AddingMusicTest extends BaseTest {
    // Тест: логинимся -> идем в окно с музыкой -> ищем песню -> добавляем ->
    // -> своя музыка -> проверяем, что там есть песня -> удаляем
    @Test
    @Timeout(value = 10)
    @Tag("Music")
    public void myMusicTest() {
        MusicPage init = new LoginPage()
                .login(user)
                .goToMusic();

        MusicPage myMusic = init
                .search(FIRST_GROUP_NAME + " " + FIRST_SONG_NAME)
                .addMusic(FIRST_SONG_NAME)
                .toMyMusic();

        assertTrue(myMusic.checkHasSong(FIRST_SONG_NAME), "Music collection does not contains just now added song");
    }

    @AfterEach
    @Tag("Music")
    public void deleteAddedSong() {
        new MusicPage().toMyMusic().deleteSong(FIRST_SONG_NAME);
    }
}
