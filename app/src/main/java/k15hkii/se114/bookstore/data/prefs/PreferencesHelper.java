package k15hkii.se114.bookstore.data.prefs;

import k15hkii.se114.bookstore.data.remote.Authentication;

import java.util.UUID;

public interface PreferencesHelper {

    String getAccessToken();

    void setAccessToken(String accessToken);

    String getRefreshToken();

    void setRefreshToken(String accessToken);

    String getCurrentUserEmail();

    void setCurrentUserEmail(String email);

    UUID getCurrentUserId();

    void setCurrentUserId(UUID userId);

    int getCurrentUserLoggedInMode();

    void setCurrentUserLoggedInMode(Authentication.LoggedInMode mode);

    String getCurrentUserName();

    void setCurrentUserName(String userName);

    String getCurrentUserProfilePicUrl();

    void setCurrentUserProfilePicUrl(String profilePicUrl);
}
