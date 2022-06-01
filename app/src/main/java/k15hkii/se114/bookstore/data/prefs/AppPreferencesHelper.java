package k15hkii.se114.bookstore.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import k15hkii.se114.bookstore.data.remote.Authentication;
import k15hkii.se114.bookstore.di.PreferenceInfo;
import k15hkii.se114.bookstore.utils.AppConstants;

import javax.inject.Inject;
import java.util.UUID;

public class AppPreferencesHelper implements PreferencesHelper {

    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";

    private static final String PREF_KEY_REFRESH_TOKEN = "PREF_KEY_REFRESH_TOKEN";

    private static final String PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL";

    private static final String PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID";

    private static final String PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME";

    private static final String PREF_KEY_CURRENT_USER_PROFILE_PIC_URL = "PREF_KEY_CURRENT_USER_PROFILE_PIC_URL";

    private static final String PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE";

    private final SharedPreferences sharedPreferences;

    @Inject
    public AppPreferencesHelper(Context context, @PreferenceInfo String prefFileName) {
        sharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public String getAccessToken() {
        return sharedPreferences.getString(PREF_KEY_ACCESS_TOKEN, null);
    }

    @Override
    public void setAccessToken(String accessToken) {
        Log.d("AppPreferencesHelper", "setAccessToken: " + accessToken);
        sharedPreferences.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply();
    }

    @Override
    public String getRefreshToken() {
        return sharedPreferences.getString(PREF_KEY_REFRESH_TOKEN, null);
    }

    @Override
    public void setRefreshToken(String refreshToken) {
        Log.d("AppPreferencesHelper", "setRefreshToken: " + refreshToken);
        sharedPreferences.edit().putString(PREF_KEY_REFRESH_TOKEN, refreshToken).apply();
    }

    @Override
    public String getCurrentUserEmail() {
        return sharedPreferences.getString(PREF_KEY_CURRENT_USER_EMAIL, null);
    }

    @Override
    public void setCurrentUserEmail(String email) {
        sharedPreferences.edit().putString(PREF_KEY_CURRENT_USER_EMAIL, email).apply();
    }

    @Override
    public UUID getCurrentUserId() {
        String userId = sharedPreferences.getString(PREF_KEY_CURRENT_USER_ID, null);
        return UUID.fromString(userId);
    }

    @Override
    public void setCurrentUserId(UUID userId) {
        sharedPreferences.edit().putString(PREF_KEY_CURRENT_USER_ID, userId.toString()).apply();
        Log.d("AppPreferencesHelper", "setCurrentUserId: " + userId);
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return sharedPreferences.getInt(PREF_KEY_USER_LOGGED_IN_MODE,
                Authentication.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType());
    }

    @Override
    public void setCurrentUserLoggedInMode(Authentication.LoggedInMode mode) {
        sharedPreferences.edit().putInt(PREF_KEY_USER_LOGGED_IN_MODE, mode.getType()).apply();
    }

    @Override
    public String getCurrentUserName() {
        return sharedPreferences.getString(PREF_KEY_CURRENT_USER_NAME, null);
    }

    @Override
    public void setCurrentUserName(String userName) {
        sharedPreferences.edit().putString(PREF_KEY_CURRENT_USER_NAME, userName).apply();
    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return sharedPreferences.getString(PREF_KEY_CURRENT_USER_PROFILE_PIC_URL, null);
    }

    @Override
    public void setCurrentUserProfilePicUrl(String profilePicUrl) {
        sharedPreferences.edit().putString(PREF_KEY_CURRENT_USER_PROFILE_PIC_URL, profilePicUrl).apply();
    }
}
