package k15hkii.se114.bookstore.di.module;

import dagger.Module;
import dagger.Provides;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.views.accountscreen.accountinfopage.AccountInfoViewViewModel;
import k15hkii.se114.bookstore.views.accountscreen.helppage.HelpPageViewModel;
import k15hkii.se114.bookstore.views.accountscreen.helppage.delaccountrequest.DeleteAccountViewModel;
import k15hkii.se114.bookstore.views.accountscreen.helppage.introduction.IntroductionViewModel;
import k15hkii.se114.bookstore.views.accountscreen.helppage.policy.PolicyViewModel;
import k15hkii.se114.bookstore.views.accountscreen.settingpage.SettingPageViewModel;
import k15hkii.se114.bookstore.views.accountscreen.helppage.helpcenter.HelpCenterViewModel;
import k15hkii.se114.bookstore.views.accountscreen.settingpage.languagesetting.LanguageSetting;
import k15hkii.se114.bookstore.views.accountscreen.settingpage.notificationsetting.NotificationSetting;
import k15hkii.se114.bookstore.views.accountscreen.settingpage.privacysetting.PrivacySetting;
import k15hkii.se114.bookstore.views.accountscreen.voucherscreen.VoucherPageViewModel;
import k15hkii.se114.bookstore.views.forgotpassscreen.ForgotPasswordViewModel;
import k15hkii.se114.bookstore.views.loginscreen.LoginViewModel;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;
import k15hkii.se114.bookstore.views.mainscreen.page.accountpage.AccountPageViewModel;
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

    @Provides
    public AccountPageViewModel provideAccountPageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, AccountPageViewModel.class, () -> new AccountPageViewModel(schedulerProvider));
    }

    @Provides
    public AccountInfoViewViewModel provideAccountInfoViewViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, AccountInfoViewViewModel.class, () -> new AccountInfoViewViewModel(schedulerProvider));
    }

    @Provides
    public HelpPageViewModel provideHelpPageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, HelpPageViewModel.class, () -> new HelpPageViewModel(schedulerProvider));
    }

    @Provides
    public SettingPageViewModel provideSettingPageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, SettingPageViewModel.class, () -> new SettingPageViewModel(schedulerProvider));
    }

    @Provides
    public VoucherPageViewModel provideVoucherPageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, VoucherPageViewModel.class, () -> new VoucherPageViewModel(schedulerProvider));
    }

    @Provides
    public HelpCenterViewModel provideHelpCenterViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, HelpCenterViewModel.class, () -> new HelpCenterViewModel(schedulerProvider));
    }

    @Provides
    public IntroductionViewModel provideIntroductionViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, IntroductionViewModel.class, () -> new IntroductionViewModel(schedulerProvider));
    }

    @Provides
    public PolicyViewModel providePolicyViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, PolicyViewModel.class, () -> new PolicyViewModel(schedulerProvider));
    }

    @Provides
    public DeleteAccountViewModel provideDeleteAccountViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, DeleteAccountViewModel.class, () -> new DeleteAccountViewModel(schedulerProvider));
    }

    @Provides
    public NotificationSetting provideNotificationSetting(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, NotificationSetting.class, () -> new NotificationSetting(schedulerProvider));
    }

    @Provides
    public PrivacySetting providePrivacySetting(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, PrivacySetting.class, () -> new PrivacySetting(schedulerProvider));
    }

    @Provides
    public LanguageSetting provideLanguageSetting(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, LanguageSetting.class, () -> new LanguageSetting(schedulerProvider));
    }

}
