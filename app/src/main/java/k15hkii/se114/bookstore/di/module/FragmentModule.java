package k15hkii.se114.bookstore.di.module;

import dagger.Module;
import dagger.Provides;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.views.forgotpassscreen.ForgotPasswordViewModel;
import k15hkii.se114.bookstore.views.loginscreen.LoginViewModel;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;
import k15hkii.se114.bookstore.views.mainscreen.page.favoritepage.FavoritePageViewModel;
import k15hkii.se114.bookstore.views.mainscreen.page.homepage.HomePageViewModel;
import k15hkii.se114.bookstore.views.mainscreen.page.rentpage.RentPageViewModel;
import k15hkii.se114.bookstore.views.mainscreen.page.shippingpage.ShippingPageViewModel;
import k15hkii.se114.bookstore.views.registerscreen.RegisterViewModel;

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

    @Provides
    public ForgotPasswordViewModel provideForgotPasswordViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, ForgotPasswordViewModel.class, () -> new ForgotPasswordViewModel(schedulerProvider));
    }

    @Provides
    public RegisterViewModel provideRegisterViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, RegisterViewModel.class, () -> new RegisterViewModel(schedulerProvider));
    }

    //TODO: MainScreen
    @Provides
    public HomePageViewModel provideHomePageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, HomePageViewModel.class, () -> new HomePageViewModel(schedulerProvider));
    }

    @Provides
    public RentPageViewModel provideRentPageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, RentPageViewModel.class, () -> new RentPageViewModel(schedulerProvider));
    }

    @Provides
    public ShippingPageViewModel provideShippingPageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, ShippingPageViewModel.class, () -> new ShippingPageViewModel(schedulerProvider));
    }

    @Provides
    public FavoritePageViewModel provideFavoritePageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, FavoritePageViewModel.class, () -> new FavoritePageViewModel(schedulerProvider));
    }

}
