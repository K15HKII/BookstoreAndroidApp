package k15hkii.se114.bookstore.di.module;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
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
import k15hkii.se114.bookstore.data.remote.*;
import k15hkii.se114.bookstore.di.PreferenceInfo;
import k15hkii.se114.bookstore.ui.ViewModelRemote;
import k15hkii.se114.bookstore.utils.AppConstants;
import k15hkii.se114.bookstore.utils.rx.AppSchedulerProvider;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import okhttp3.OkHttpClient;
import okhttp3.Request;
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
    ViewModelRemote provideViewModelRemote(ModelRemote remote) { return new ViewModelRemote(remote); }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) { return appPreferencesHelper; }

    @Provides
    @Singleton
    Authentication provideAuthentication(Retrofit retrofit, PreferencesHelper helper) {
        return new AppAuthentication(retrofit.create(Authentication.class), helper);
    }

    @Provides
    @Singleton
    ModelRemote provideModelRemote(Retrofit retrofit) {
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
    Retrofit provideRetrofit(Gson gson, PreferencesHelper preferencesHelper) {
        final String baseUrl = BuildConfig.BASE_URL.endsWith("/") ? BuildConfig.BASE_URL : BuildConfig.BASE_URL + "/";
        Log.d("AppModule", "Base URL: " + baseUrl);
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson));

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        clientBuilder.addInterceptor(loggingInterceptor);
        clientBuilder.addInterceptor(chain -> {
            if (preferencesHelper.getAccessToken() != null && preferencesHelper.getRefreshToken() != null) {
                Request request = chain.request().newBuilder()
                        .addHeader("x-access-token", preferencesHelper.getAccessToken())
                        .addHeader("x-refresh-token", preferencesHelper.getRefreshToken())
                        .build();
                return chain.proceed(request);
            }
            return chain.proceed(chain.request());
        });
        builder.client(clientBuilder.build());

        return builder.build();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

}
