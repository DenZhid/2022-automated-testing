package tests.photo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import pages.LoginPage;
import pages.photo.PhotoPage;
import tests.BaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThan;

public class AddingPhotoTest extends BaseTest {

    private static final String PERSONAL_ALBUM_NAME = "Личные фотографии";

    // Тест: логинимся -> загружаем фото -> проверяем, что количество фото пользователя увеличилось
    @ParameterizedTest
    @Timeout(value = 10)
    @Tag("Photo")
    @DisplayName("UploadPhotoTest")
    @ValueSource(strings = {"cat.png", "kitty.png"})
    void uploadPhotoTest(String photoName) {
        PhotoPage photoPage = new LoginPage()
                .login(user)
                .goToPhoto();
        int startPhotoSize = photoPage.getAllPhotosSize();
        photoPage.uploadPhoto(PATH_TO_RESOURCES_FOLDER + photoName);
        int endPhotoSize = photoPage.getAllPhotosSize();
        assertThat(endPhotoSize, greaterThan(startPhotoSize));
    }

    // Зачискта после тестов
    @AfterEach
    void cleanup() {
        new PhotoPage()
                .goToEditAlbumPage(PERSONAL_ALBUM_NAME)
                .deletePhotoByNumber(0);
    }
}
