package k15hkii.se114.bookstore.data.remote;

import android.util.Log;
import io.reactivex.Single;
import k15hkii.se114.bookstore.data.model.auth.LoginRequest;
import k15hkii.se114.bookstore.data.model.auth.LoginResponse;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AppAuthentication implements Authentication {

    private final Authentication authentication;
    private final PreferencesHelper preferencesHelper;

    @Override
    public Single<LoginResponse> login(LoginRequest request) {
        return authentication.login(request).doOnSuccess(response -> {
            if (!response.isAuthenticated()) {
                Log.d("LoginViewModel", "Login failed");
                return;
            }
            preferencesHelper.setAccessToken(response.getAccessToken());
            preferencesHelper.setRefreshToken(response.getRefreshToken());
        });
    }

}