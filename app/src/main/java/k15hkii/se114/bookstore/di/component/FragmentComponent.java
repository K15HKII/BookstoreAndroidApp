package k15hkii.se114.bookstore.di.component;

import dagger.Component;
import k15hkii.se114.bookstore.di.module.FragmentModule;
import k15hkii.se114.bookstore.views.loginscreen.Login;

@Component(modules = {FragmentModule.class}, dependencies = AppComponent.class)
public interface FragmentComponent {

    void inject(Login login);

}
