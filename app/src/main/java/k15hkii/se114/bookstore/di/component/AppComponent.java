package k15hkii.se114.bookstore.di.component;

import dagger.Component;
import k15hkii.se114.bookstore.BookstoreApp;
import k15hkii.se114.bookstore.di.module.AppModule;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(BookstoreApp app);

    SchedulerProvider getSchedulerProvider();

}
