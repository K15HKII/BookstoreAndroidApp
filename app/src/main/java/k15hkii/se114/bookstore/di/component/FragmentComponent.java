package k15hkii.se114.bookstore.di.component;

import dagger.Component;
import k15hkii.se114.bookstore.di.module.FragmentModule;
import k15hkii.se114.bookstore.di.scope.FragmentScope;
import k15hkii.se114.bookstore.ui.accountscreen.accountinfopage.AccountInfoPage;
import k15hkii.se114.bookstore.ui.accountscreen.helppage.HelpPage;
import k15hkii.se114.bookstore.ui.accountscreen.helppage.delaccountrequest.DeleteAccount;
import k15hkii.se114.bookstore.ui.accountscreen.helppage.introduction.Introduction;
import k15hkii.se114.bookstore.ui.accountscreen.helppage.policy.Policy;
import k15hkii.se114.bookstore.ui.accountscreen.settingpage.SettingPage;
import k15hkii.se114.bookstore.ui.accountscreen.helppage.helpcenter.HelpCenter;
import k15hkii.se114.bookstore.ui.accountscreen.settingpage.languagesetting.LanguageSetting;
import k15hkii.se114.bookstore.ui.accountscreen.settingpage.notificationsetting.NotificationSetting;
import k15hkii.se114.bookstore.ui.accountscreen.settingpage.notificationsetting.myordernotification.MyOrderNotification;
import k15hkii.se114.bookstore.ui.accountscreen.settingpage.notificationsetting.othernotification.OtherNotification;
import k15hkii.se114.bookstore.ui.accountscreen.settingpage.notificationsetting.vouchernotification.VoucherNotificaiton;
import k15hkii.se114.bookstore.ui.accountscreen.settingpage.privacysetting.PrivacySetting;
import k15hkii.se114.bookstore.ui.orderinfoscreen.ordercancle.OrderCancle;
import k15hkii.se114.bookstore.ui.orderinfoscreen.ordercancle.OrderCancleViewModel;
import k15hkii.se114.bookstore.ui.voucherscreen.SelectorVoucher;
import k15hkii.se114.bookstore.ui.voucherscreen.VoucherPage;
import k15hkii.se114.bookstore.ui.address.SelectorAddressPage;
import k15hkii.se114.bookstore.ui.address.add.AddAddressPage;
import k15hkii.se114.bookstore.ui.address.edit.EditAddressPage;
import k15hkii.se114.bookstore.ui.bankscreen.SelectorBankPage;
import k15hkii.se114.bookstore.ui.bankscreen.add.AddBankPage;
import k15hkii.se114.bookstore.ui.bankscreen.edit.EditBankPage;
import k15hkii.se114.bookstore.ui.bookdetailscreen.BookDetailPage;
import k15hkii.se114.bookstore.ui.forgotpassscreen.ForgotPasswordPage;
import k15hkii.se114.bookstore.ui.intro.firstpage.IntroFirstPage;
import k15hkii.se114.bookstore.ui.intro.fourthpage.IntroFourthPage;
import k15hkii.se114.bookstore.ui.intro.secondpage.IntroSecondPage;
import k15hkii.se114.bookstore.ui.intro.thirdpage.IntroThirdPage;
import k15hkii.se114.bookstore.ui.loginscreen.Login;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.allbooks.AllBooksPage;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.familiarbooks.FamiliarBooksPage;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.foryoubooks.ForYouBooksPage;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.popularbooks.PopularBooksPage;
import k15hkii.se114.bookstore.ui.mainscreen.page.recentbook.RecentListBook;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.RentInfoView;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.add.AddRentBookDetail;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.add.AddRentBookView;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.menutab.RentedViewPage;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.menutab.RentingViewPage;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.menutab.detail.RentDetailBill;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.cancleorder.CancleOrder;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.shipmentarrived.ShipmentArrivedViewPage;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.shippingview.ShippingViewPage;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.waitingorderview.WaitingOrderViewPage;
import k15hkii.se114.bookstore.ui.mainscreen.page.accountpage.AccountPage;
import k15hkii.se114.bookstore.ui.mainscreen.page.favoritepage.FavoritePage;
import k15hkii.se114.bookstore.ui.mainscreen.page.homepage.HomePage;
import k15hkii.se114.bookstore.ui.mainscreen.page.rentpage.RentPage;
import k15hkii.se114.bookstore.ui.mainscreen.page.shippingpage.ShippingPage;
import k15hkii.se114.bookstore.ui.news.News;
import k15hkii.se114.bookstore.ui.news.createfeed.CreateNews;
import k15hkii.se114.bookstore.ui.news.explorer.Explorer;
import k15hkii.se114.bookstore.ui.news.follow.Follow;
import k15hkii.se114.bookstore.ui.news.popularnews.PopularNews;
import k15hkii.se114.bookstore.ui.notificationnews.NotificationPage;
import k15hkii.se114.bookstore.ui.oncartscreen.OncartViewPage;
import k15hkii.se114.bookstore.ui.orderinfoscreen.orderConfirm.OrderInfoPage;
import k15hkii.se114.bookstore.ui.orderinfoscreen.PaymentMethodPage;
import k15hkii.se114.bookstore.ui.orderinfoscreen.orderchecker.OrderChecker;
import k15hkii.se114.bookstore.ui.orderinfoscreen.orderdetail.OrderDetail;
import k15hkii.se114.bookstore.ui.orderinfoscreen.orderrating.OrderRating;
import k15hkii.se114.bookstore.ui.ratingbookscreen.RatingBooksDetailPage;
import k15hkii.se114.bookstore.ui.ratingbookscreen.ratelistbook.RateListBook;
import k15hkii.se114.bookstore.ui.registerscreen.Register;
import k15hkii.se114.bookstore.ui.searchbook.SearchBookView;
import k15hkii.se114.bookstore.ui.searchbook.SearchBookViewResult;
import k15hkii.se114.bookstore.ui.success.lend.LendSuccess;
import k15hkii.se114.bookstore.ui.success.order.OrderSuccess;

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

    void inject(SelectorBankPage selectorBankPage);

    void inject(AddBankPage addBankPage);

    void inject(EditBankPage editBankPage);

    void inject(SelectorAddressPage selectorAddressPage);

    void inject(AddAddressPage addAddressPage);

    void inject(EditAddressPage editAddressPage);

    void inject(OrderInfoPage orderInfoPage);

    void inject(PaymentMethodPage paymentMethodPage);

    void inject(OncartViewPage oncartViewPage);

    void inject(RentInfoView rentInfoView);

    void inject(AddRentBookView addRentBookView);

    void inject(AddRentBookDetail addRentBookDetail);

    void inject(RentedViewPage rentedViewPage);

    void inject(RentingViewPage rentingViewPage);

    void inject(ShipmentArrivedViewPage shipmentArrivedViewPage);

    void inject(ShippingViewPage shippingViewPage);

    void inject(WaitingOrderViewPage waitingOrderViewPage);

    void inject(BookDetailPage bookDetailPage);

    void inject(RatingBooksDetailPage ratingBooksDetailPage);

    void inject(NotificationPage notificationPage);

    void inject(SearchBookView searchBookView);

    void inject(SearchBookViewResult searchBookViewResult);


    void inject(MyOrderNotification myOrderNotification);


    void inject(VoucherNotificaiton voucherNotificaiton);


    void inject(OtherNotification otherNotification);


    void inject(IntroFirstPage introFirstPage);

    void inject(IntroSecondPage introsecondPage);

    void inject(IntroThirdPage introThirdPage);

    void inject(IntroFourthPage introFourthPage);


    void inject(AllBooksPage allBooksPage);


    void inject(FamiliarBooksPage familiarBooksPage);


    void inject(ForYouBooksPage forYouBooksPage);


    void inject(PopularBooksPage popularBooksPage);


    void inject(OrderDetail orderDetail);


    void inject(LendSuccess lendSuccess);


    void inject(OrderSuccess orderSuccess);


    void inject(OrderChecker orderChecker);


    void inject(OrderRating orderRating);


    void inject(RentDetailBill rentDetailBill);


    void inject(CancleOrder cancleOrder);


    void inject(SelectorVoucher selectorVoucher);

    void inject(News news);

    void inject(Explorer explorer);

    void inject(Follow follow);

    void inject(PopularNews popularNews);

    void inject(RateListBook rateListBook);

    void inject(CreateNews createNews);

    void inject(RecentListBook recentListBook);

    void inject(OrderCancle orderCancle);
}
