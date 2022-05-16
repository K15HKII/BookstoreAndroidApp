package k15hkii.se114.bookstore.di.module;

import dagger.Module;
import k15hkii.se114.bookstore.viewmodel.base.BaseActivity;
import lombok.AllArgsConstructor;

@Module
@AllArgsConstructor
public class ActivityModule {

    private final BaseActivity<?, ?> activity;

}
