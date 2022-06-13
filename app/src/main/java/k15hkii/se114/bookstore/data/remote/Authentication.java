package k15hkii.se114.bookstore.data.remote;

import io.reactivex.Single;
import k15hkii.se114.bookstore.data.model.auth.LoginRequest;
import k15hkii.se114.bookstore.data.model.auth.LoginResponse;
import k15hkii.se114.bookstore.data.model.auth.RegisterRequest;
import k15hkii.se114.bookstore.data.model.auth.RegisterResponse;
import k15hkii.se114.bookstore.ui.registerscreen.Register;
import retrofit2.http.*;

public interface Authentication {

    @POST("login")
    Single<LoginResponse> login(@Body LoginRequest request);

    @POST("signup")
    Single<RegisterResponse> register(@Body RegisterRequest request);

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }

    }

}
