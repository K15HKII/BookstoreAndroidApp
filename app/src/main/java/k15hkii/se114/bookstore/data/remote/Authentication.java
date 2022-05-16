package k15hkii.se114.bookstore.data.remote;

import io.reactivex.Single;
import k15hkii.se114.bookstore.data.model.auth.LoginRequest;
import k15hkii.se114.bookstore.data.model.auth.LoginResponse;

public interface Authentication {

    Single<LoginResponse> login(LoginRequest request);

}
