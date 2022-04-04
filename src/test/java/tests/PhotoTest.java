package tests;

import pages.LogPage;
import pages.MainPage;
import pages.PhotoPage;
import utils.User;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static java.io.File.separator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhotoTest extends ParentTest {

    private static final String ALBUM_NAME = "Test album";
    private static final String PATH_TO_RESOURCES_FOLDER =
            "src" + separator + "test" + separator + "resources" + separator;
    private static User user;

    @BeforeAll
    public static void createUser() {
        user = new User(USER_LOGIN, USER_PASSWORD);
    }

    // Тест: логинимся -> заходим в раздел "Фото" -> создаём пустой альбом -> проверяем, что альбом создан
    @Test
    public void createEmptyPhotoAlbumTest() {
        assertTrue(new LogPage()
                .login(user)
                .goToPhoto()
                .createAlbum(ALBUM_NAME)
                .hasCreatedAlbum(ALBUM_NAME)
        );
    }

    // Тест: логинимся -> загружаем фото -> проверяем, что количество фото пользователя увеличилось
    @ParameterizedTest
    @ValueSource(strings = {"cat.png", "kitty.png"})
    public void uploadPhotoTest(String photoName) {
        PhotoPage photoPage = new LogPage()
                .login(user)
                .goToPhoto();
        int startPhotoSize = photoPage.getAllPhotosSize();
        photoPage.uploadPhoto(PATH_TO_RESOURCES_FOLDER + photoName);
        int endPhotoSize = photoPage.getAllPhotosSize();
        assertThat(endPhotoSize, greaterThan(startPhotoSize));
    }

    // Тест: логинимся -> загружаем фото -> ставим фото, как аватар -> проверяем, что ссылка на фото аватара изменилась
    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {"cat.png", "kitty.png"})
    public void changeAvatarTest(String photoName) {
        MainPage mainPage = new LogPage().login(user);
        String startAvatarRef = mainPage.getCurrentAvatarRef();
        mainPage = mainPage
                .goToPhoto()
                .uploadPhoto(PATH_TO_RESOURCES_FOLDER + photoName)
                .setAvatar()
                .goToMain();
        String endAvatarRef = mainPage.getCurrentAvatarRef();
        assertThat(startAvatarRef, not(equalTo(endAvatarRef)));
    }
}
