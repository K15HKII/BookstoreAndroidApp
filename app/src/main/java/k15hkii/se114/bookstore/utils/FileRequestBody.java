package k15hkii.se114.bookstore.utils;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;
import org.jetbrains.annotations.Nullable;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileRequestBody extends RequestBody {

    private InputStream inputStream;

    private MediaType type;

    public FileRequestBody(InputStream inputStream, MediaType type) {
        this.inputStream = inputStream;
        this.type = type;
    }

    @Override
    public MediaType contentType() {
        return type;
    }

    @Override
    public long contentLength() throws IOException {
        return inputStream.available();
    }

    @Override
    public void writeTo(@NonNull BufferedSink sink) throws IOException {
        Source source = null;
        try {
            source = Okio.source(inputStream);
            sink.writeAll(source);
        } catch (Exception e) {
            if (source != null) {
                source.close();
            }
        }
    }

    @SuppressLint("Range")
    public static String getContentType(ContentResolver resolver, Uri uri) {
        String type = null;
        Cursor cursor = resolver.query(uri, null, null, null, null);
        try {
            if (cursor != null) {
                cursor.moveToFirst();
                type = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.MIME_TYPE));
                cursor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return type;
    }

}
