package k15hkii.se114.bookstore.di.component;

import dagger.Component;
import k15hkii.se114.bookstore.di.module.FragmentModule;
import k15hkii.se114.bookstore.di.scope.FragmentScope;
import k15hkii.se114.bookstore.ui.account.AccountPage;
import k15hkii.se114.bookstore.ui.account.address.SelectorAddressPage;
import k15hkii.se114.bookstore.ui.account.address.add.AddAddressPage;
import k15hkii.se114.bookstore.ui.account.address.edit.EditAddressPage;
import k15hkii.se114.bookstore.ui.account.bank.SelectorBankPage;
import k15hkii.se114.bookstore.ui.account.bank.add.AddBankPage;
import k15hkii.se114.bookstore.ui.account.bank.edit.EditBankPage;
import k15hkii.se114.bookstore.ui.account.help.HelpPage;
import k15hkii.se114.bookstore.ui.account.help.delete.DeleteAccount;
import k15hkii.se114.bookstore.ui.account.help.helpcenter.HelpCenter;
import k15hkii.se114.bookstore.ui.account.help.introduction.Introduction;
import k15hkii.se114.bookstore.ui.account.help.policy.Policy;
import k15hkii.se114.bookstore.ui.account.setting.SettingPage;
import k15hkii.se114.bookstore.ui.account.setting.languagesetting.LanguageSetting;
import k15hkii.se114.bookstore.ui.account.setting.notificationsetting.NotificationSetting;
import k15hkii.se114.bookstore.ui.account.setting.notificationsetting.myordernotification.MyOrderNotification;
import k15hkii.se114.bookstore.ui.account.setting.notificationsetting.othernotification.OtherNotification;
import k15hkii.se114.bookstore.ui.account.setting.notificationsetting.vouchernotification.VoucherNotificaiton;
import k15hkii.se114.bookstore.ui.account.setting.privacysetting.PrivacySetting;
import k15hkii.se114.bookstore.ui.auth.forgotpassword.ForgotPasswordPage;
import k15hkii.se114.bookstore.ui.auth.loginscreen.Login;
import k15hkii.se114.bookstore.ui.auth.register.Register;
import k15hkii.se114.bookstore.ui.book.detail.BookDetailPage;
import k15hkii.se114.bookstore.ui.book.rating.RatingBooksDetailPage;
import k15hkii.se114.bookstore.ui.book.rating.list.RateListBook;
import k15hkii.se114.bookstore.ui.book.search.SearchBookView;
import k15hkii.se114.bookstore.ui.book.search.SearchBookViewResult;
import k15hkii.se114.bookstore.ui.cart.OncartViewPage;
import k15hkii.se114.bookstore.ui.intro.firstpage.IntroFirstPage;
import k15hkii.se114.bookstore.ui.intro.fourthpage.IntroFourthPage;
import k15hkii.se114.bookstore.ui.intro.secondpage.IntroSecondPage;
import k15hkii.se114.bookstore.ui.intro.thirdpage.IntroThirdPage;
import k15hkii.se114.bookstore.ui.mainscreen.navigator.all.AllBooksPage;
import k15hkii.se114.bookstore.ui.mainscreen.navigator.familiar.FamiliarBooksPage;
import k15hkii.se114.bookstore.ui.mainscreen.navigator.foryou.ForYouBooksPage;
import k15hkii.se114.bookstore.ui.mainscreen.navigator.popular.PopularBooksPage;
import k15hkii.se114.bookstore.ui.mainscreen.page.favoritepage.FavoritePage;
import k15hkii.se114.bookstore.ui.mainscreen.page.homepage.HomePage;
import k15hkii.se114.bookstore.ui.mainscreen.page.recentbook.RecentListBook;
import k15hkii.se114.bookstore.ui.mainscreen.page.rentpage.RentPage;
import k15hkii.se114.bookstore.ui.mainscreen.page.shippingpage.ShippingPage;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.RentInfoView;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.add.AddRentBookDetail;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.add.AddRentBookView;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.menutab.RentedViewPage;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.menutab.RentingViewPage;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.menutab.detail.RentDetailBill;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.cancleorder.CancelOrder;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.shipmentarrived.ShipmentArrivedViewPage;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.shippingview.ShippingViewPage;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.waitingorderview.WaitingOrderViewPage;
import k15hkii.se114.bookstore.ui.news.News;
import k15hkii.se114.bookstore.ui.news.createfeed.CreateNews;
import k15hkii.se114.bookstore.ui.news.explorer.Explorer;
import k15hkii.se114.bookstore.ui.news.follow.Follow;
import k15hkii.se114.bookstore.ui.news.popularnews.PopularNews;
import k15hkii.se114.bookstore.ui.notification.NotificationPage;
import k15hkii.se114.bookstore.ui.order.PaymentMethodPage;
import k15hkii.se114.bookstore.ui.order.cancel.OrderCancle;
import k15hkii.se114.bookstore.ui.order.checker.OrderChecker;
import k15hkii.se114.bookstore.ui.order.confirm.OrderInfoPage;
import k15hkii.se114.bookstore.ui.order.detail.OrderDetail;
import k15hkii.se114.bookstore.ui.order.rating.OrderRating;
import k15hkii.se114.bookstore.ui.success.lend.LendSuccess;
import k15hkii.se114.bookstore.ui.success.order.OrderSuccess;
import k15hkii.se114.bookstore.ui.voucher.VoucherPage;
import k15hkii.se114.bookstore.ui.voucher.selector.SelectorVoucher;

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


    void inject(CancelOrder cancleOrder);


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
