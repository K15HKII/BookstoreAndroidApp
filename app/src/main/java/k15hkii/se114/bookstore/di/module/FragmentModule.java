package k15hkii.se114.bookstore.di.module;

import dagger.Module;
import dagger.Provides;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.LoginViewModel;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;

import static k15hkii.se114.bookstore.utils.ViewModelUtils.createViewModel;

@Module
public class FragmentModule {

    private final BaseFragment<?, ?> fragment;

    public FragmentModule(BaseFragment<?, ?> fragment) {
        this.fragment = fragment;
    }

    @Provides
    public LoginViewModel provideLoginViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, LoginViewModel.class, () -> new LoginViewModel(schedulerProvider));
    }

}
