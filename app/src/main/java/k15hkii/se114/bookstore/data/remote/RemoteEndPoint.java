package k15hkii.se114.bookstore.data.remote;

import k15hkii.se114.bookstore.BuildConfig;

public final class RemoteEndPoint {

    public static final String ENDPOINT_FACEBOOK_LOGIN = BuildConfig.BASE_URL + "/login/facebook";

    public static final String ENDPOINT_GOOGLE_LOGIN = BuildConfig.BASE_URL + "/login/google";

    public static final String ENDPOINT_LOGOUT = BuildConfig.BASE_URL + "/logout";

    public static final String ENDPOINT_SERVER_LOGIN = BuildConfig.BASE_URL + "/login";

    public static final String ENDPOINT_MODEL_USER = BuildConfig.BASE_URL + "/api/models/user";

    private RemoteEndPoint() {
        // This class is not publicly instantiable
    }

}
