package k15hkii.se114.bookstore.data.remote;

import com.rx2androidnetworking.Rx2AndroidNetworking;
import io.reactivex.Single;
import k15hkii.se114.bookstore.data.model.auth.LoginRequest;
import k15hkii.se114.bookstore.data.model.auth.LoginResponse;

public class AppAuthentication implements Authentication {



    @Override
    public Single<LoginResponse> login(LoginRequest request) {
        return Rx2AndroidNetworking.get(RemoteEndPoint.ENDPOINT_SERVER_LOGIN)
                .addPathParameter(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

}
