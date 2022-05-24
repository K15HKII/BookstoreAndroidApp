package k15hkii.se114.bookstore.di.module;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import k15hkii.se114.bookstore.data.remote.Authentication;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.views.accountscreen.accountinfopage.AccountInfoViewViewModel;
import k15hkii.se114.bookstore.views.accountscreen.helppage.HelpPageViewModel;
import k15hkii.se114.bookstore.views.accountscreen.helppage.delaccountrequest.DeleteAccountViewModel;
import k15hkii.se114.bookstore.views.accountscreen.helppage.introduction.IntroductionViewModel;
import k15hkii.se114.bookstore.views.accountscreen.helppage.policy.PolicyViewModel;
import k15hkii.se114.bookstore.views.accountscreen.settingpage.SettingPageViewModel;
import k15hkii.se114.bookstore.views.accountscreen.helppage.helpcenter.HelpCenterViewModel;
import k15hkii.se114.bookstore.views.accountscreen.settingpage.languagesetting.LanguageSettingViewModel;
import k15hkii.se114.bookstore.views.accountscreen.settingpage.notificationsetting.NotificationSettingViewModel;
import k15hkii.se114.bookstore.views.accountscreen.settingpage.notificationsetting.myordernotification.MyOrderNotificationViewModel;
import k15hkii.se114.bookstore.views.accountscreen.settingpage.notificationsetting.othernotification.OtherNotificationViewModel;
import k15hkii.se114.bookstore.views.accountscreen.settingpage.notificationsetting.vouchernotification.VoucherNotificaitonViewModel;
import k15hkii.se114.bookstore.views.accountscreen.settingpage.privacysetting.PrivacySettingViewModel;
import k15hkii.se114.bookstore.views.accountscreen.voucherscreen.VoucherPageViewModel;
import k15hkii.se114.bookstore.views.address.SelectorAddressPageViewModel;
import k15hkii.se114.bookstore.views.address.add.AddAddressPageViewModel;
import k15hkii.se114.bookstore.views.address.edit.EditAddressPageViewModel;
import k15hkii.se114.bookstore.views.bankscreen.SelectorBankPageViewModel;
import k15hkii.se114.bookstore.views.bankscreen.add.AddBankPageViewModel;
import k15hkii.se114.bookstore.views.bankscreen.edit.EditBankPageViewModel;
import k15hkii.se114.bookstore.views.bookdetailscreen.BookDetailPageViewModel;
import k15hkii.se114.bookstore.views.forgotpassscreen.ForgotPasswordViewModel;
import k15hkii.se114.bookstore.views.intro.firstpage.IntroFirstPageViewModel;
import k15hkii.se114.bookstore.views.intro.fourthpage.IntroFourthPageViewModel;
import k15hkii.se114.bookstore.views.intro.secondpage.IntroSecondPageViewModel;
import k15hkii.se114.bookstore.views.intro.thirdpage.IntroThirdPageViewModel;
import k15hkii.se114.bookstore.views.loginscreen.LoginViewModel;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;
import k15hkii.se114.bookstore.views.mainscreen.homechipnavigator.BookViewAdapter;
import k15hkii.se114.bookstore.views.mainscreen.homechipnavigator.allbooks.AllBooksViewViewModel;
import k15hkii.se114.bookstore.views.mainscreen.homechipnavigator.familiarbooks.FamiliarBooksViewModel;
import k15hkii.se114.bookstore.views.mainscreen.homechipnavigator.foryoubooks.ForYouBooksViewModel;
import k15hkii.se114.bookstore.views.mainscreen.homechipnavigator.popularbooks.PopularBooksViewModel;
import k15hkii.se114.bookstore.views.mainscreen.rentscreen.RentInfoViewViewModel;
import k15hkii.se114.bookstore.views.mainscreen.rentscreen.add.AddRentBookDetailViewModel;
import k15hkii.se114.bookstore.views.mainscreen.rentscreen.add.AddRentBookViewViewModel;
import k15hkii.se114.bookstore.views.mainscreen.rentscreen.menutab.RentedViewPageViewModel;
import k15hkii.se114.bookstore.views.mainscreen.rentscreen.menutab.RentingViewPageViewModel;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.OrderShipmentAdapter.orderitemsrecycleview.OrderViewAdapter;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.ratingbookview.RatingBookViewPageViewModel;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.shipmentarrived.ShipmentArrivedViewPageViewModel;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.shippingview.ShippingViewPageViewModel;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.waitingorderview.WaitingOrderViewPageViewModel;
import k15hkii.se114.bookstore.views.mainscreen.page.accountpage.AccountPageViewModel;
import k15hkii.se114.bookstore.views.mainscreen.page.favoritepage.FavoritePageViewModel;
import k15hkii.se114.bookstore.views.mainscreen.page.homepage.HomePageViewModel;
import k15hkii.se114.bookstore.views.mainscreen.page.rentpage.RentPageViewModel;
import k15hkii.se114.bookstore.views.mainscreen.page.shippingpage.ShippingPageViewModel;
import k15hkii.se114.bookstore.views.notificationnews.NotificationPageViewModel;
import k15hkii.se114.bookstore.views.oncartscreen.OncartViewViewModel;
import k15hkii.se114.bookstore.views.orderinfoscreen.OrderInfoPageViewModel;
import k15hkii.se114.bookstore.views.orderinfoscreen.PaymentMethodViewModel;
import k15hkii.se114.bookstore.views.ratingbookscreen.RatingBooksDetailPageViewModel;
import k15hkii.se114.bookstore.views.registerscreen.RegisterViewModel;
import k15hkii.se114.bookstore.views.searchbook.SearchBookViewResultViewModel;
import k15hkii.se114.bookstore.views.searchbook.SearchBookViewViewModel;

import static k15hkii.se114.bookstore.utils.ViewModelUtils.createViewModel;

@Module
public class FragmentModule {

    private final BaseFragment<?, ?> fragment;

    public FragmentModule(BaseFragment<?, ?> fragment) {
        this.fragment = fragment;
    }

    //region ViewModels
    @Provides
    public LoginViewModel provideLoginViewModel(SchedulerProvider schedulerProvider, Authentication authentication) {
        return createViewModel(fragment, LoginViewModel.class, () -> new LoginViewModel(schedulerProvider, authentication));
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
    public NotificationSettingViewModel provideNotificationSettingViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, NotificationSettingViewModel.class, () -> new NotificationSettingViewModel(schedulerProvider));
    }

    @Provides
    public PrivacySettingViewModel providePrivacySettingViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, PrivacySettingViewModel.class, () -> new PrivacySettingViewModel(schedulerProvider));
    }

    @Provides
    public LanguageSettingViewModel provideLanguageSettingViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, LanguageSettingViewModel.class, () -> new LanguageSettingViewModel(schedulerProvider));
    }

    @Provides
    public SelectorAddressPageViewModel provideSelectorAddressPageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, SelectorAddressPageViewModel.class, () -> new SelectorAddressPageViewModel(schedulerProvider));
    }

    @Provides
    public AddAddressPageViewModel provideAddAddressPageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, AddAddressPageViewModel.class, () -> new AddAddressPageViewModel(schedulerProvider));
    }

    @Provides
    public EditAddressPageViewModel provideEditAddressPageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, EditAddressPageViewModel.class, () -> new EditAddressPageViewModel(schedulerProvider));
    }

    @Provides
    public SelectorBankPageViewModel provideSelectorBankPageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, SelectorBankPageViewModel.class, () -> new SelectorBankPageViewModel(schedulerProvider));
    }

    @Provides
    public AddBankPageViewModel provideAddBankPageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, AddBankPageViewModel.class, () -> new AddBankPageViewModel(schedulerProvider));
    }

    @Provides
    public EditBankPageViewModel provideEditBankPageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, EditBankPageViewModel.class, () -> new EditBankPageViewModel(schedulerProvider));
    }

    @Provides
    public PaymentMethodViewModel providePaymentMethodViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, PaymentMethodViewModel.class, () -> new PaymentMethodViewModel(schedulerProvider));
    }

    @Provides
    public OncartViewViewModel provideOncartViewViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, OncartViewViewModel.class, () -> new OncartViewViewModel(schedulerProvider));
    }

    @Provides
    public OrderInfoPageViewModel provideOrderInfoPageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, OrderInfoPageViewModel.class, () -> new OrderInfoPageViewModel(schedulerProvider));
    }

    @Provides
    public RentInfoViewViewModel provideRentInfoViewViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, RentInfoViewViewModel.class, () -> new RentInfoViewViewModel(schedulerProvider));
    }

    @Provides
    public BookDetailPageViewModel provideBookDetailPageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, BookDetailPageViewModel.class, () -> new BookDetailPageViewModel(schedulerProvider));
    }

    @Provides
    public AddRentBookViewViewModel provideAddRentBookViewViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, AddRentBookViewViewModel.class, () -> new AddRentBookViewViewModel(schedulerProvider));
    }

    @Provides
    public AddRentBookDetailViewModel provideAddRentBookDetailViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, AddRentBookDetailViewModel.class, () -> new AddRentBookDetailViewModel(schedulerProvider));
    }

    @Provides
    public RatingBooksDetailPageViewModel provideRatingBooksDetailPageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, RatingBooksDetailPageViewModel.class, () -> new RatingBooksDetailPageViewModel(schedulerProvider));
    }

    @Provides
    public NotificationPageViewModel provideNotificationPageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, NotificationPageViewModel.class, () -> new NotificationPageViewModel(schedulerProvider));
    }

    @Provides
    public RentedViewPageViewModel provideRentedViewPageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, RentedViewPageViewModel.class, () -> new RentedViewPageViewModel(schedulerProvider));
    }

    @Provides
    public RentingViewPageViewModel provideRentingViewPageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, RentingViewPageViewModel.class, () -> new RentingViewPageViewModel(schedulerProvider));
    }

    @Provides
    public SearchBookViewViewModel provideSearchBookViewViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, SearchBookViewViewModel.class, () -> new SearchBookViewViewModel(schedulerProvider));
    }

    @Provides
    public SearchBookViewResultViewModel provideSearchBookViewResultViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, SearchBookViewResultViewModel.class, () -> new SearchBookViewResultViewModel(schedulerProvider));
    }

    @Provides
    public RatingBookViewPageViewModel provideRatingBookViewPageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, RatingBookViewPageViewModel.class, () -> new RatingBookViewPageViewModel(schedulerProvider));
    }

    @Provides
    public ShipmentArrivedViewPageViewModel provideShipmentArrivedViewPageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, ShipmentArrivedViewPageViewModel.class, () -> new ShipmentArrivedViewPageViewModel(schedulerProvider));
    }

    @Provides
    public ShippingViewPageViewModel provideShippingViewPageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, ShippingViewPageViewModel.class, () -> new ShippingViewPageViewModel(schedulerProvider));
    }

    @Provides
    public WaitingOrderViewPageViewModel provideWaitingOrderViewPageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, WaitingOrderViewPageViewModel.class, () -> new WaitingOrderViewPageViewModel(schedulerProvider));
    }

    @Provides
    public MyOrderNotificationViewModel provideMyOrderNotificationViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, MyOrderNotificationViewModel.class, () -> new MyOrderNotificationViewModel(schedulerProvider));
    }

    @Provides
    public VoucherNotificaitonViewModel provideVoucherNotificaitonViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, VoucherNotificaitonViewModel.class, () -> new VoucherNotificaitonViewModel(schedulerProvider));
    }

    @Provides
    public OtherNotificationViewModel provideOtherNotificationViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, OtherNotificationViewModel.class, () -> new OtherNotificationViewModel(schedulerProvider));
    }

    @Provides
    public IntroFirstPageViewModel provideIntroFirstPageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, IntroFirstPageViewModel.class, () -> new IntroFirstPageViewModel(schedulerProvider));
    }

    @Provides
    public IntroSecondPageViewModel provideIntroSecondPageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, IntroSecondPageViewModel.class, () -> new IntroSecondPageViewModel(schedulerProvider));
    }

    @Provides
    public IntroThirdPageViewModel provideIntroThirdPageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, IntroThirdPageViewModel.class, () -> new IntroThirdPageViewModel(schedulerProvider));
    }

    @Provides
    public IntroFourthPageViewModel provideIntroFourthPageViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, IntroFourthPageViewModel.class, () -> new IntroFourthPageViewModel(schedulerProvider));
    }

    @Provides
    public AllBooksViewViewModel provideAllBooksViewViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, AllBooksViewViewModel.class, () -> new AllBooksViewViewModel(schedulerProvider));
    }

    @Provides
    public FamiliarBooksViewModel provideFamiliarBooksViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, FamiliarBooksViewModel.class, () -> new FamiliarBooksViewModel(schedulerProvider));
    }

    @Provides
    public ForYouBooksViewModel provideForYouBooksViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, ForYouBooksViewModel.class, () -> new ForYouBooksViewModel(schedulerProvider));
    }

    @Provides
    public PopularBooksViewModel providePopularBooksViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(fragment, PopularBooksViewModel.class, () -> new PopularBooksViewModel(schedulerProvider));
    }

    //endregion

    //region Adapters
    @Provides
    public BookViewAdapter provideBookViewAdapter(Context context) {
        return new BookViewAdapter(context);
    }
    @Provides
    public OrderViewAdapter orderBooksViewAdapter(Context context) {
        return new OrderViewAdapter(context);
    }
    //endregion

}
