package k15hkii.se114.bookstore;

import android.app.Application;
import k15hkii.se114.bookstore.di.component.AppComponent;
import k15hkii.se114.bookstore.di.component.DaggerAppComponent;
import lombok.Getter;

public class BookstoreApp extends Application {

    @Getter AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                                         .application(this)
                                         .build();

        appComponent.inject(this);
    }

}