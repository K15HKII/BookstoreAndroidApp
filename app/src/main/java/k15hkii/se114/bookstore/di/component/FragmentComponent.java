package k15hkii.se114.bookstore.di.component;

import dagger.Component;
import k15hkii.se114.bookstore.di.module.FragmentModule;
import k15hkii.se114.bookstore.di.scope.FragmentScope;
import k15hkii.se114.bookstore.views.accountscreen.accountinfopage.AccountInfoPage;
import k15hkii.se114.bookstore.views.accountscreen.helppage.HelpPage;
import k15hkii.se114.bookstore.views.accountscreen.helppage.delaccountrequest.DeleteAccount;
import k15hkii.se114.bookstore.views.accountscreen.helppage.introduction.Introduction;
import k15hkii.se114.bookstore.views.accountscreen.helppage.policy.Policy;
import k15hkii.se114.bookstore.views.accountscreen.settingpage.SettingPage;
import k15hkii.se114.bookstore.views.accountscreen.helppage.helpcenter.HelpCenter;
import k15hkii.se114.bookstore.views.accountscreen.settingpage.languagesetting.LanguageSetting;
import k15hkii.se114.bookstore.views.accountscreen.settingpage.notificationsetting.NotificationSetting;
import k15hkii.se114.bookstore.views.accountscreen.settingpage.notificationsetting.myordernotification.MyOrderNotification;
import k15hkii.se114.bookstore.views.accountscreen.settingpage.notificationsetting.othernotification.OtherNotification;
import k15hkii.se114.bookstore.views.accountscreen.settingpage.notificationsetting.vouchernotification.VoucherNotificaiton;
import k15hkii.se114.bookstore.views.accountscreen.settingpage.privacysetting.PrivacySetting;
import k15hkii.se114.bookstore.views.accountscreen.voucherscreen.VoucherPage;
import k15hkii.se114.bookstore.views.address.SelectorAddressPage;
import k15hkii.se114.bookstore.views.address.add.AddAddressPage;
import k15hkii.se114.bookstore.views.address.edit.EditAddressPage;
import k15hkii.se114.bookstore.views.bankscreen.SelectorBankPage;
import k15hkii.se114.bookstore.views.bankscreen.add.AddBankPage;
import k15hkii.se114.bookstore.views.bankscreen.edit.EditBankPage;
import k15hkii.se114.bookstore.views.bookdetailscreen.BookDetailPage;
import k15hkii.se114.bookstore.views.forgotpassscreen.ForgotPasswordPage;
import k15hkii.se114.bookstore.views.intro.firstpage.IntroFirstPage;
import k15hkii.se114.bookstore.views.intro.fourthpage.IntroFourthPage;
import k15hkii.se114.bookstore.views.intro.secondpage.IntroSecondPage;
import k15hkii.se114.bookstore.views.intro.thirdpage.IntroThirdPage;
import k15hkii.se114.bookstore.views.loginscreen.Login;
import k15hkii.se114.bookstore.views.mainscreen.homechipnavigator.allbooks.AllBooksPage;
import k15hkii.se114.bookstore.views.mainscreen.homechipnavigator.alltopics.AllTopicPage;
import k15hkii.se114.bookstore.views.mainscreen.homechipnavigator.familiarbooks.FamiliarBooksPage;
import k15hkii.se114.bookstore.views.mainscreen.homechipnavigator.foryoubooks.ForYouBooksPage;
import k15hkii.se114.bookstore.views.mainscreen.homechipnavigator.popularbooks.PopularBooksPage;
import k15hkii.se114.bookstore.views.mainscreen.rentscreen.RentInfoView;
import k15hkii.se114.bookstore.views.mainscreen.rentscreen.add.AddRentBookDetail;
import k15hkii.se114.bookstore.views.mainscreen.rentscreen.add.AddRentBookView;
import k15hkii.se114.bookstore.views.mainscreen.rentscreen.menutab.RentedViewPage;
import k15hkii.se114.bookstore.views.mainscreen.rentscreen.menutab.RentingViewPage;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.ratingbookview.RatingBookViewPage;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.shipmentarrived.ShipmentArrivedViewPage;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.shippingview.ShippingViewPage;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.waitingorderview.WaitingOrderViewPage;
import k15hkii.se114.bookstore.views.mainscreen.page.accountpage.AccountPage;
import k15hkii.se114.bookstore.views.mainscreen.page.favoritepage.FavoritePage;
import k15hkii.se114.bookstore.views.mainscreen.page.homepage.HomePage;
import k15hkii.se114.bookstore.views.mainscreen.page.rentpage.RentPage;
import k15hkii.se114.bookstore.views.mainscreen.page.shippingpage.ShippingPage;
import k15hkii.se114.bookstore.views.notificationnews.NotificationPage;
import k15hkii.se114.bookstore.views.oncartscreen.OncartViewPage;
import k15hkii.se114.bookstore.views.orderinfoscreen.OrderInfoPage;
import k15hkii.se114.bookstore.views.orderinfoscreen.PaymentMethodPage;
import k15hkii.se114.bookstore.views.ratingbookscreen.RatingBooksDetailPage;
import k15hkii.se114.bookstore.views.registerscreen.Register;
import k15hkii.se114.bookstore.views.searchbook.SearchBookView;
import k15hkii.se114.bookstore.views.searchbook.SearchBookViewResult;

@FragmentScope
@Component(modules = {FragmentModule.class}, dependencies = AppComponent.class)
public interface FragmentComponent {

    void inject(Login login);

    void inject(ForgotPasswordPage forgotPasswordPage);

    void inject(Register register);

    void inject(HomePage homePage);

    void inject(RentPage rentPage);

    void inject(ShippingPage shippingPage);

    void inject(FavoritePage favoritePage);

    //TODO: ACCOUNT

    void inject(AccountPage accountPage);

    void inject(AccountInfoPage accountInfoPage);

    void inject(HelpPage helpPage);

    void inject(SettingPage settingPage);

    void inject(VoucherPage voucherPage);

    //TODO: HELP

    void inject(HelpCenter helpCenter);

    void inject(Introduction introduction);

    void inject(Policy policy);

    void inject(DeleteAccount deleteAccount);

    //TODO: SETTING

    void inject(NotificationSetting notificationSetting);

    void inject(PrivacySetting privacySetting);

    void inject(LanguageSetting languageSetting);

    //TODO: BANK

    void inject(SelectorBankPage selectorBankPage);

    void inject(AddBankPage addBankPage);

    void inject(EditBankPage editBankPage);

    //TODO: ADDRESS

    void inject(SelectorAddressPage selectorAddressPage);

    void inject(AddAddressPage addAddressPage);

    void inject(EditAddressPage editAddressPage);

    //TODO: ORDERINFO

    void inject(OrderInfoPage orderInfoPage);

    void inject(PaymentMethodPage paymentMethodPage);

    //TODO: ONCARTVIEW

    void inject(OncartViewPage oncartViewPage);

    //TODO: MAINSCREEN
    //TODO: MAINSCREEN.RENTSCREEN

    void inject(RentInfoView rentInfoView);

    //TODO: MAINSCREEN.RENTSCREEN.ADD

    void inject(AddRentBookView addRentBookView);

    void inject(AddRentBookDetail addRentBookDetail);

    //TODO: MAINSCREEN.RENTSCREEN.MENUTAB

    void inject(RentedViewPage rentedViewPage);

    void inject(RentingViewPage rentingViewPage);

    //TODO: MAINSCREEN.SHIPMENTSCREEN

    void inject(RatingBookViewPage ratingBookViewPage);

    void inject(ShipmentArrivedViewPage shipmentArrivedViewPage);

    void inject(ShippingViewPage shippingViewPage);

    void inject(WaitingOrderViewPage waitingOrderViewPage);

    //TODO: BOOKDETAILPAGE

    void inject(BookDetailPage bookDetailPage);

    //TODO: RATINGBOOKSDETAILPAGE

    void inject(RatingBooksDetailPage ratingBooksDetailPage);

    //TODO: NOTIFICATIONPAGE

    void inject(NotificationPage notificationPage);

    //TODO: SEARCHBOOK

    void inject(SearchBookView searchBookView);

    void inject(SearchBookViewResult searchBookViewResult);

    //TODO: ACCOUTNSCREEN.NOTIFICATIONSETTING.MYORDERNOTIFICATION

    void inject(MyOrderNotification myOrderNotification);

    //TODO: ACCOUTNSCREEN.NOTIFICATIONSETTING.VOUCHERNOTIFICATION

    void inject(VoucherNotificaiton voucherNotificaiton);

    //TODO: ACCOUTNSCREEN.NOTIFICATIONSETTING.OTHERNOTIFICATION

    void inject(OtherNotification otherNotification);

    //TODO: INTROPAGE

    void inject(IntroFirstPage introFirstPage);

    void inject(IntroSecondPage introsecondPage);

    void inject(IntroThirdPage introThirdPage);

    void inject(IntroFourthPage introFourthPage);

    //TODO: MAINSCREEN.ALLBOOKSPAGE

    void inject(AllBooksPage allBooksPage);

    //TODO: MAINSCREEN.FAMILIAR
    void inject(FamiliarBooksPage familiarBooksPage);

    //TODO: MAINSCREEN.FORYOU
    void inject(ForYouBooksPage forYouBooksPage);

    //TODO: MAINSCREEN.POPULAR
    void inject(PopularBooksPage popularBooksPage);


}