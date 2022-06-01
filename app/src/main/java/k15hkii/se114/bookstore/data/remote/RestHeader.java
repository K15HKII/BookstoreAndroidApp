package k15hkii.se114.bookstore.data.remote;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import lombok.Getter;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.Type;
import java.util.UUID;

@Singleton
public class RestHeader {

    private ProtectedRestHeader mProtectedApiHeader;

    private PublicRestHeader mPublicApiHeader;

    @Inject
    public RestHeader(PublicRestHeader publicApiHeader, ProtectedRestHeader protectedApiHeader) {
        mPublicApiHeader = publicApiHeader;
        mProtectedApiHeader = protectedApiHeader;
    }

    public ProtectedRestHeader getProtectedApiHeader() {
        return mProtectedApiHeader;
    }

    public PublicRestHeader getPublicApiHeader() {
        return mPublicApiHeader;
    }

    public static final class ProtectedRestHeader {

        private final PreferencesHelper preferencesHelper;

        @Inject public ProtectedRestHeader(PreferencesHelper preferencesHelper) {
            this.preferencesHelper = preferencesHelper;
        }

        public String getAccessToken() {
            return preferencesHelper.getAccessToken();
        }

        public UUID getUserId() {
            return preferencesHelper.getCurrentUserId();
        }

    }


    public static final class ProtectedRestHeaderSerializer implements JsonSerializer<ProtectedRestHeader> {

        @Getter(lazy = true) private static final ProtectedRestHeaderSerializer instance = new ProtectedRestHeaderSerializer();

        private ProtectedRestHeaderSerializer() {
        }

        @Override
        public JsonElement serialize(ProtectedRestHeader src, Type typeOfSrc, JsonSerializationContext context) {
            return null;
        }

    }

    public static final class PublicRestHeader {

        private final PreferencesHelper preferencesHelper;

        @Inject public PublicRestHeader(PreferencesHelper preferencesHelper) {
            this.preferencesHelper = preferencesHelper;
        }

    }

    public static final class PublicRestHeaderSerializer implements JsonSerializer<PublicRestHeader> {

        @Getter(lazy = true) private static final PublicRestHeaderSerializer instance = new PublicRestHeaderSerializer();

        private PublicRestHeaderSerializer() {
        }

        @Override
        public JsonElement serialize(PublicRestHeader src, Type typeOfSrc, JsonSerializationContext context) {
            return null;
        }

    }

}
