package k15hkii.se114.bookstore.di.component;

import dagger.Component;
import k15hkii.se114.bookstore.di.module.FragmentModule;

@Component(modules = {FragmentModule.class}, dependencies = AppComponent.class)
public interface FragmentComponent {

}
