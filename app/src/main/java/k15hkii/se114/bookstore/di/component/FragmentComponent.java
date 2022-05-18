package k15hkii.se114.bookstore.di.component;

import dagger.Component;
import k15hkii.se114.bookstore.di.module.FragmentModule;
import k15hkii.se114.bookstore.views.accountscreen.accountinfopage.AccountInfoPage;
import k15hkii.se114.bookstore.views.accountscreen.helppage.HelpPage;
import k15hkii.se114.bookstore.views.accountscreen.helppage.delaccountrequest.DeleteAccount;
import k15hkii.se114.bookstore.views.accountscreen.helppage.introduction.Introduction;
import k15hkii.se114.bookstore.views.accountscreen.helppage.policy.Policy;
import k15hkii.se114.bookstore.views.accountscreen.settingpage.SettingPage;
import k15hkii.se114.bookstore.views.accountscreen.helppage.helpcenter.HelpCenter;
import k15hkii.se114.bookstore.views.accountscreen.settingpage.languagesetting.LanguageSetting;
import k15hkii.se114.bookstore.views.accountscreen.settingpage.notificationsetting.NotificationSetting;
import k15hkii.se114.bookstore.views.accountscreen.settingpage.privacysetting.PrivacySetting;
import k15hkii.se114.bookstore.views.accountscreen.voucherscreen.VoucherPage;
import k15hkii.se114.bookstore.views.forgotpassscreen.ForgotPasswordPage;
import k15hkii.se114.bookstore.views.loginscreen.Login;
import k15hkii.se114.bookstore.views.mainscreen.page.accountpage.AccountPage;
import k15hkii.se114.bookstore.views.mainscreen.page.favoritepage.FavoritePage;
import k15hkii.se114.bookstore.views.mainscreen.page.homepage.HomePage;
import k15hkii.se114.bookstore.views.mainscreen.page.rentpage.RentPage;
import k15hkii.se114.bookstore.views.mainscreen.page.shippingpage.ShippingPage;
import k15hkii.se114.bookstore.views.registerscreen.Register;

@Component(modules = {FragmentModule.class}, dependencies = AppComponent.class)
public interface FragmentComponent {

    void inject(Login login);

    void inject(ForgotPasswordPage forgotPasswordPage);

    void inject(Register register);

    void inject(HomePage homePage);

    void inject(RentPage rentPage);

    void inject(ShippingPage shippingPage);

    void inject(FavoritePage favoritePage);

    void inject(AccountPage accountPage);

    void inject(AccountInfoPage accountInfoPage);

    void inject(HelpPage helpPage);

    void inject(SettingPage settingPage);

    void inject(VoucherPage voucherPage);

    void inject(HelpCenter helpCenter);

    void inject(Introduction introduction);

    void inject(Policy policy);

    void inject(DeleteAccount deleteAccount);

    void inject(NotificationSetting notificationSetting);

    void inject(PrivacySetting privacySetting);

    void inject(LanguageSetting languageSetting);
}
