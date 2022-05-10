package tests.photo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import pages.LoginPage;
import pages.photo.PhotoPage;
import tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreatingAlbumTest extends BaseTest {

    private static final String ALBUM_NAME = "Test album";

    // Тест: логинимся -> заходим в раздел "Фото" -> создаём пустой альбом -> проверяем, что альбом создан
    @Test
    //@Timeout(value = 10)
    @Tag("Photo")
    void createEmptyPhotoAlbumTest() {
        assertTrue(new LoginPage()
                .login(user)
                .goToPhoto()
                .createAlbum(ALBUM_NAME)
                .hasCreatedAlbum(ALBUM_NAME)
        );
    }

    // Зачискта после теста
    @AfterEach
    void cleanup() {
        new PhotoPage()
                .goToEditAlbumPage(ALBUM_NAME)
                .deleteAlbum();
    }
}
