package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import pages.LogPage;
import utils.User;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhotoTest extends ParentTest {

    private static final String ALBUM_NAME = "Test album";
    private static User user;

    @BeforeAll
    public static void createUser() {
        user = new User(USER_LOGIN, USER_PASSWORD);
    }

    // Тест: логинимся -> заходим в раздел "Фото" -> создаём пустой альбом
    @Test
    public void createEmptyPhotoAlbumTest() {
        assertTrue(new LogPage()
                .login(user)
                .goToPhoto()
                .createAlbum(ALBUM_NAME)
                .hasCreatedAlbum(ALBUM_NAME)
        );
    }

    // Тест: логинимся -> загружаем фото
    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {"cat.png", "kitty.png"})
    public void uploadPhotoTest(String photoName) {

    }

    // Тест: логинимся -> загружаем фото -> ставим фото, как аватар
    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {"cat.png", "kitty.png"})
    public void changeAvatarTest() {

    }
/*
    // Удаляем все созданные альбомы и добавленные фото
    @Disabled
    @AfterAll
    public void cleanupPhotos() {

    }*/
}
