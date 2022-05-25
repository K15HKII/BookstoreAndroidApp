package k15hkii.se114.bookstore.di.module;

import dagger.Module;
import k15hkii.se114.bookstore.ui.base.BaseActivity;

@Module
public class ActivityModule {

    private final BaseActivity<?, ?> activity;

    public ActivityModule(BaseActivity<?, ?> activity) {
        this.activity = activity;
    }



}
