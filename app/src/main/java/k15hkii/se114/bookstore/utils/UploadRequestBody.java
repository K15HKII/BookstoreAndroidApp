package k15hkii.se114.bookstore.utils;

import lombok.val;
import lombok.var;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class UploadRequestBody extends RequestBody {

   private final File file;
   private final String contentType;

    public UploadRequestBody(File file, String contentType) {
        this.file = file;
        this.contentType = contentType;
    }

    @Nullable
    @Override
    public MediaType contentType() {
        return MediaType.parse(contentType + "/*");
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {
        val buffer = new byte[8 * 1024];
        val fileInputStream = new FileInputStream(file);

        var read = 0;
        while ((read = fileInputStream.read(buffer)) != -1) {
            sink.write(buffer, 0, read);
        }
    }

}
