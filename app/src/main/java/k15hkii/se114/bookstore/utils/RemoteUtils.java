package k15hkii.se114.bookstore.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.net.Uri;
import android.provider.OpenableColumns;
import lombok.SneakyThrows;
import lombok.val;
import lombok.var;
import okhttp3.RequestBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class RemoteUtils {

    private static String getFilename(ContentResolver resolver, Uri fileUri) {
        var name = "";
        val returnCursor = resolver.query(fileUri, null, null, null, null);
        if (returnCursor != null) {
            val nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
            returnCursor.moveToFirst();
            name = returnCursor.getString(nameIndex);
            returnCursor.close();
        }
        return name;
    }

    @SneakyThrows
    public static RequestBody from(Activity activity, ContentResolver resolver, Uri uri) {
        var descriptor = resolver.openFileDescriptor(uri, "r");
        val inputStream = new FileInputStream(descriptor.getFileDescriptor());
        var file = new File(activity.getCacheDir(), getFilename(resolver, uri));
        val outputStream = new FileOutputStream(file);

        byte[] b = new byte[(int) inputStream.getChannel().size()];
        while (inputStream.read(b, 0, (int) inputStream.getChannel().size()) > 0) {
            outputStream.write(b);
        }

        inputStream.close();
        outputStream.close();

        return new UploadRequestBody(file, "image");
//        return new FileRequestBody(resolver.openInputStream(uri), MediaType.parse(FileRequestBody.getContentType(resolver, uri)));
    }

}
