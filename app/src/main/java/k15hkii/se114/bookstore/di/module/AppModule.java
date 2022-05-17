package k15hkii.se114.bookstore.di.module;

import android.app.Application;
import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import k15hkii.se114.bookstore.data.remote.AppAuthentication;
import k15hkii.se114.bookstore.data.remote.Authentication;
import k15hkii.se114.bookstore.data.remote.RestHeader;
import k15hkii.se114.bookstore.di.PreferenceInfo;
import k15hkii.se114.bookstore.utils.AppConstants;
import k15hkii.se114.bookstore.utils.rx.AppSchedulerProvider;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

@Module
public class AppModule {

    @Provides
    @PreferenceInfo
    String providePrefName() { return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    Authentication provideAuthentication(AppAuthentication appAuthentication) { return appAuthentication; }

    @Provides
    @Singleton
    Context provideContext(Application application) { return application; }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
                .registerTypeAdapter(RestHeader.PublicRestHeader.class, RestHeader.PublicRestHeaderSerializer.getInstance())
                .registerTypeAdapter(RestHeader.ProtectedRestHeader.class, RestHeader.ProtectedRestHeaderSerializer.getInstance())
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

}
