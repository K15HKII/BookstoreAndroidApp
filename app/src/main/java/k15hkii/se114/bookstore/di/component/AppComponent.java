package k15hkii.se114.bookstore.di.component;

import android.app.Application;
import dagger.BindsInstance;
import dagger.Component;
import k15hkii.se114.bookstore.BookstoreApp;
import k15hkii.se114.bookstore.data.remote.Authentication;
import k15hkii.se114.bookstore.di.module.AppModule;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(BookstoreApp app);

    SchedulerProvider getSchedulerProvider();

    Authentication getAuthentication();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

}
