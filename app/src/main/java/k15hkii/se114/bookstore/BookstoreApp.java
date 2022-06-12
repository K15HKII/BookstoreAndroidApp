package k15hkii.se114.bookstore;

import android.app.Application;
import android.util.Log;
import k15hkii.se114.bookstore.data.remote.LocationRepository;
import k15hkii.se114.bookstore.di.component.AppComponent;
import k15hkii.se114.bookstore.di.component.DaggerAppComponent;
import lombok.Getter;

import javax.inject.Inject;

public class BookstoreApp extends Application {

    public static final boolean IS_LOCAL = false;
    @Getter AppComponent appComponent;

    @Inject protected LocationRepository locationRepository;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                                         .application(this)
                                         .build();

        appComponent.inject(this);
        if (locationRepository.isInitialize()) {
            Log.d("BookstoreApp", "Location repository is initialized");
        }
    }

}
