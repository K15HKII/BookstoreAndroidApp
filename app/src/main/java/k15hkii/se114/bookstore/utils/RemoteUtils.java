package k15hkii.se114.bookstore.utils;

import android.net.Uri;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.io.File;

public class RemoteUtils {

    public static RequestBody from(Uri uri) {
        return RequestBody.create(MediaType.parse("multipart/form-data"), new File(uri.getPath()));
    }

}
