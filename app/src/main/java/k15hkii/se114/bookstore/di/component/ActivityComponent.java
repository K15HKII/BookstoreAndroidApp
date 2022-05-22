package k15hkii.se114.bookstore.di.component;

import dagger.Component;
import k15hkii.se114.bookstore.di.module.ActivityModule;
import k15hkii.se114.bookstore.di.scope.ActivityScope;

@ActivityScope
@Component(modules = {ActivityModule.class}, dependencies = AppComponent.class)
public interface ActivityComponent {

}
