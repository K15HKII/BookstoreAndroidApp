package k15hkii.se114.bookstore.di.module;

import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModelProvider;
import dagger.Module;
import dagger.Provides;
import k15hkii.se114.bookstore.ViewModelFactory;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.LoginViewModel;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;
import lombok.AllArgsConstructor;

@Module
public class FragmentModule {

    private BaseFragment<?, ?> fragment;

    public FragmentModule(BaseFragment<?, ?> fragment) {
        this.fragment = fragment;
    }

    @Provides
    public LoginViewModel provideLoginViewModel(SchedulerProvider schedulerProvider) {
        Supplier<LoginViewModel> supplier = () -> new LoginViewModel(schedulerProvider);
        ViewModelProvider provider = new ViewModelProvider(fragment, new ViewModelFactory<>(LoginViewModel.class, supplier));
        return provider.get(LoginViewModel.class);
    }

}
