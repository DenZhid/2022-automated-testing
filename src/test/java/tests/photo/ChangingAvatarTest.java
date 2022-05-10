package tests.photo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import pages.LoginPage;
import pages.MainPage;
import pages.photo.PhotoPage;
import tests.BaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

public class ChangingAvatarTest extends BaseTest {

    private static final String PERSONAL_ALBUM_NAME = "Личные фотографии";

    // Тест: логинимся -> загружаем фото -> ставим фото, как аватар -> проверяем, что ссылка на фото аватара изменилась
    @ParameterizedTest
    //@Timeout(value = 10)
    @Tag("Photo")
    @DisplayName("ChangingAvatarTest")
    @ValueSource(strings = {"cat.png", "kitty.png"})
    void changeAvatarTest(String photoName) {
        MainPage mainPage = new LoginPage().login(user);
        String startAvatarRef = mainPage.getCurrentAvatarRef();
        mainPage = mainPage
                .goToPhoto()
                .uploadPhoto(PATH_TO_RESOURCES_FOLDER + photoName)
                .setAvatar()
                .goToMain();
        String endAvatarRef = mainPage.getCurrentAvatarRef();
        assertThat(startAvatarRef, not(equalTo(endAvatarRef)));
    }

    // Зачискта после тестов
    @AfterEach
    void cleanup() {
        new PhotoPage()
                .goToEditAlbumPage(PERSONAL_ALBUM_NAME)
                .deletePhotoByNumber(0);
    }
}
