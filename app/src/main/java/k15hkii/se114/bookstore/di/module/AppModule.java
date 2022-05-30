package k15hkii.se114.bookstore.di.module;

import android.app.Application;
import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import dagger.Module;
import dagger.Provides;
import k15hkii.se114.bookstore.BookstoreApp;
import k15hkii.se114.bookstore.BuildConfig;
import k15hkii.se114.bookstore.data.DataSession;
import k15hkii.se114.bookstore.data.prefs.AppPreferencesHelper;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.Authentication;
import k15hkii.se114.bookstore.data.remote.LocalModelRemote;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.data.remote.RestHeader;
import k15hkii.se114.bookstore.di.PreferenceInfo;
import k15hkii.se114.bookstore.utils.AppConstants;
import k15hkii.se114.bookstore.utils.rx.AppSchedulerProvider;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Singleton;

@Module
public class AppModule {

    @Provides
    @PreferenceInfo
    String providePrefName() { return AppConstants.PREF_NAME; }

    @Provides
    @Singleton
    DataSession provideDataSession() { return new DataSession(); }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) { return appPreferencesHelper; }

    @Provides
    @Singleton
    Authentication provideAuthentication(Retrofit retrofit) { return retrofit.create(Authentication.class); }

    @Provides
    @Singleton
    ModelRemote provideModelRemote(Retrofit retrofit) {
        if (BookstoreApp.IS_LOCAL)
            return new LocalModelRemote();
        return retrofit.create(ModelRemote.class);
    }

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
    @Singleton
    Retrofit provideRetrofit(Gson gson) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL.endsWith("/") ? BuildConfig.BASE_URL : BuildConfig.BASE_URL + "/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson));

        /*HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        builder.client(client);*/

        return builder.build();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

}
