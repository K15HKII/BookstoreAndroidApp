package k15hkii.se114.bookstore.di.module;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.Authentication;
import k15hkii.se114.bookstore.data.remote.LocationRepository;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.di.UserId;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.accountscreen.voucherscreen.*;
import k15hkii.se114.bookstore.ui.accountscreen.voucherscreen.adapterSelect.VoucherItemAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.page.recentbook.RecentListBookViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.menutab.detail.RentDetailBillViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.cancleorder.CancelOrderViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.waitingorderview.WaitingOrderListViewModel;
import k15hkii.se114.bookstore.ui.news.NewsViewModel;
import k15hkii.se114.bookstore.ui.news.createfeed.CreateNewsViewModel;
import k15hkii.se114.bookstore.ui.news.explorer.ExplorerViewModel;
import k15hkii.se114.bookstore.ui.news.follow.FollowViewModel;
import k15hkii.se114.bookstore.ui.news.popularnews.PopularNewsViewModel;
import k15hkii.se114.bookstore.ui.notificationnews.ListDataNotificationAdapter;
import k15hkii.se114.bookstore.ui.notificationnews.NotificationOrderViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.orderchecker.OrderCheckerViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.orderdetail.OrderDetailViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.orderrating.OrderRatingViewModel;
import k15hkii.se114.bookstore.ui.ratingbookscreen.ratelistbook.RateListBookViewModel;
import k15hkii.se114.bookstore.ui.success.order.OrderSuccessViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.accountscreen.accountinfopage.AccountInfoViewViewModel;
import k15hkii.se114.bookstore.ui.accountscreen.helppage.HelpPageViewModel;
import k15hkii.se114.bookstore.ui.accountscreen.helppage.delaccountrequest.DeleteAccountViewModel;
import k15hkii.se114.bookstore.ui.accountscreen.helppage.introduction.IntroductionViewModel;
import k15hkii.se114.bookstore.ui.accountscreen.helppage.policy.PolicyViewModel;
import k15hkii.se114.bookstore.ui.accountscreen.settingpage.SettingPageViewModel;
import k15hkii.se114.bookstore.ui.accountscreen.helppage.helpcenter.HelpCenterViewModel;
import k15hkii.se114.bookstore.ui.accountscreen.settingpage.languagesetting.LanguageSettingViewModel;
import k15hkii.se114.bookstore.ui.accountscreen.settingpage.notificationsetting.NotificationSettingViewModel;
import k15hkii.se114.bookstore.ui.accountscreen.settingpage.notificationsetting.myordernotification.MyOrderNotificationViewModel;
import k15hkii.se114.bookstore.ui.accountscreen.settingpage.notificationsetting.othernotification.OtherNotificationViewModel;
import k15hkii.se114.bookstore.ui.accountscreen.settingpage.notificationsetting.vouchernotification.VoucherNotificaitonViewModel;
import k15hkii.se114.bookstore.ui.accountscreen.settingpage.privacysetting.PrivacySettingViewModel;
import k15hkii.se114.bookstore.ui.address.recycleViewAddressSelector.OtherAddressAdapter;
import k15hkii.se114.bookstore.ui.address.SelectorAddressPageViewModel;
import k15hkii.se114.bookstore.ui.address.add.AddAddressPageViewModel;
import k15hkii.se114.bookstore.ui.address.edit.EditAddressPageViewModel;
import k15hkii.se114.bookstore.ui.bankscreen.recycleViewBankSelector.OtherBankAdapter;
import k15hkii.se114.bookstore.ui.bankscreen.SelectorBankPageViewModel;
import k15hkii.se114.bookstore.ui.bankscreen.add.AddBankPageViewModel;
import k15hkii.se114.bookstore.ui.bankscreen.edit.EditBankPageViewModel;
import k15hkii.se114.bookstore.ui.bookdetailscreen.BookDetailPageViewModel;
import k15hkii.se114.bookstore.ui.bookdetailscreen.CommentViewAdapter;
import k15hkii.se114.bookstore.ui.forgotpassscreen.ForgotPasswordViewModel;
import k15hkii.se114.bookstore.ui.intro.firstpage.IntroFirstPageViewModel;
import k15hkii.se114.bookstore.ui.intro.fourthpage.IntroFourthPageViewModel;
import k15hkii.se114.bookstore.ui.intro.secondpage.IntroSecondPageViewModel;
import k15hkii.se114.bookstore.ui.intro.thirdpage.IntroThirdPageViewModel;
import k15hkii.se114.bookstore.ui.loginscreen.LoginViewModel;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.allbooks.AllBooksViewViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.familiarbooks.FamiliarBooksViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.foryoubooks.ForYouBooksViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.popularbooks.PopularBooksViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.RentInfoViewViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.add.AddRentBookDetailViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.add.AddRentBookViewViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.menutab.RentedViewPageViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.menutab.RentingViewPageViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentViewAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderItemAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderViewAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.shipmentarrived.ShipmentArrivedViewPageViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.shippingview.ShippingViewPageViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.page.accountpage.AccountPageViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.page.favoritepage.FavoritePageViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.page.homepage.HomePageViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.page.rentpage.RentPageViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.page.shippingpage.ShippingPageViewModel;
import k15hkii.se114.bookstore.ui.notificationnews.NotificationPageViewModel;
import k15hkii.se114.bookstore.ui.oncartscreen.OncartItemAdapter;
import k15hkii.se114.bookstore.ui.oncartscreen.OncartViewViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.orderConfirm.OrderInfoPageViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.PaymentMethodViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBooksViewAdapter;
import k15hkii.se114.bookstore.ui.ratingbookscreen.RateDetailViewModel;
import k15hkii.se114.bookstore.ui.registerscreen.RegisterViewModel;
import k15hkii.se114.bookstore.ui.searchbook.SearchBookViewResultViewModel;
import k15hkii.se114.bookstore.ui.searchbook.SearchBookViewViewModel;
import k15hkii.se114.bookstore.ui.success.lend.*;

import java.util.UUID;

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
    public ForgotPasswordViewModel provideForgotPasswordViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        return createViewModel(fragment, ForgotPasswordViewModel.class, () -> new ForgotPasswordViewModel(schedulerProvider, remote));
    }

    @Provides
    public RegisterViewModel provideRegisterViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, RegisterViewModel.class, () -> new RegisterViewModel(schedulerProvider));
    }
    @Provides
    public HomePageViewModel provideHomePageViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, HomePageViewModel.class, () -> new HomePageViewModel(schedulerProvider));
    }

    @Provides
    public RentPageViewModel provideRentPageViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, RentPageViewModel.class, () -> new RentPageViewModel(schedulerProvider));
    }

    @Provides
    public ShippingPageViewModel provideShippingPageViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, ShippingPageViewModel.class, () -> new ShippingPageViewModel(schedulerProvider));
    }

    @Provides
    public FavoritePageViewModel provideFavoritePageViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, PreferencesHelper preferencesHelper) {
        return createViewModel(fragment, FavoritePageViewModel.class, () -> new FavoritePageViewModel(schedulerProvider, mapper, preferencesHelper));
    }

    @Provides
    public AccountPageViewModel provideAccountPageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, @UserId UUID userId) {
        return createViewModel(fragment, AccountPageViewModel.class, () -> new AccountPageViewModel(schedulerProvider,remote, userId));
    }

    @Provides
    public AccountInfoViewViewModel provideAccountInfoViewViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, @UserId UUID userId) {
        return createViewModel(fragment, AccountInfoViewViewModel.class, () -> new AccountInfoViewViewModel(schedulerProvider, remote, userId));
    }

    @Provides
    public HelpPageViewModel provideHelpPageViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, HelpPageViewModel.class, () -> new HelpPageViewModel(schedulerProvider));
    }

    @Provides
    public SettingPageViewModel provideSettingPageViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, SettingPageViewModel.class, () -> new SettingPageViewModel(schedulerProvider));
    }

    @Provides
    public VoucherPageViewModel provideVoucherPageViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, PreferencesHelper preferencesHelper) {
        return createViewModel(fragment, VoucherPageViewModel.class, () -> new VoucherPageViewModel(schedulerProvider, mapper, preferencesHelper));
    }

    @Provides
    public HelpCenterViewModel provideHelpCenterViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, HelpCenterViewModel.class, () -> new HelpCenterViewModel(schedulerProvider));
    }

    @Provides
    public IntroductionViewModel provideIntroductionViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, IntroductionViewModel.class, () -> new IntroductionViewModel(schedulerProvider));
    }

    @Provides
    public PolicyViewModel providePolicyViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, PolicyViewModel.class, () -> new PolicyViewModel(schedulerProvider));
    }

    @Provides
    public DeleteAccountViewModel provideDeleteAccountViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, DeleteAccountViewModel.class, () -> new DeleteAccountViewModel(schedulerProvider));
    }

    @Provides
    public NotificationSettingViewModel provideNotificationSettingViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, NotificationSettingViewModel.class, () -> new NotificationSettingViewModel(schedulerProvider));
    }

    @Provides
    public PrivacySettingViewModel providePrivacySettingViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, PrivacySettingViewModel.class, () -> new PrivacySettingViewModel(schedulerProvider));
    }

    @Provides
    public LanguageSettingViewModel provideLanguageSettingViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, LanguageSettingViewModel.class, () -> new LanguageSettingViewModel(schedulerProvider));
    }

    @Provides
    public SelectorAddressPageViewModel provideSelectorAddressPageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper preferencesHelper) {
        return createViewModel(fragment, SelectorAddressPageViewModel.class, () -> new SelectorAddressPageViewModel(schedulerProvider, remote, preferencesHelper));
    }

    @Provides
    public AddAddressPageViewModel provideAddAddressPageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, LocationRepository locationRepository, @UserId UUID userId) {
        return createViewModel(fragment, AddAddressPageViewModel.class, () -> new AddAddressPageViewModel(schedulerProvider, remote, locationRepository, userId));
    }

    @Provides
    public EditAddressPageViewModel provideEditAddressPageViewModel(SchedulerProvider schedulerProvider, LocationRepository repository, ModelRemote remote, @UserId UUID userId) {
        return createViewModel(fragment, EditAddressPageViewModel.class, () -> new EditAddressPageViewModel(schedulerProvider, repository, remote, userId));
    }

    @Provides
    public SelectorBankPageViewModel provideSelectorBankPageViewModel(SchedulerProvider schedulerProvider, PreferencesHelper preferencesHelper, ModelRemote remote) {
        return createViewModel(fragment, SelectorBankPageViewModel.class, () -> new SelectorBankPageViewModel(schedulerProvider, preferencesHelper, remote));
    }

    @Provides
    public AddBankPageViewModel provideAddBankPageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, @UserId UUID userId) {
        return createViewModel(fragment, AddBankPageViewModel.class, () -> new AddBankPageViewModel(schedulerProvider, remote, userId));
    }

    @Provides
    public EditBankPageViewModel provideEditBankPageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, @UserId UUID userId) {
        return createViewModel(fragment, EditBankPageViewModel.class, () -> new EditBankPageViewModel(schedulerProvider, remote, userId));
    }

    @Provides
    public PaymentMethodViewModel providePaymentMethodViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, PaymentMethodViewModel.class, () -> new PaymentMethodViewModel(schedulerProvider));
    }

    @Provides
    public OncartViewViewModel provideOncartViewViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper preferencesHelper) {
        return createViewModel(fragment, OncartViewViewModel.class, () -> new OncartViewViewModel(schedulerProvider, remote, preferencesHelper));
    }

    @Provides
    public OrderInfoPageViewModel provideOrderInfoPageViewModel(SchedulerProvider schedulerProvider, PreferencesHelper helper, ModelRemote remote, ViewModelMapper mapper) {
        return createViewModel(fragment, OrderInfoPageViewModel.class, () -> new OrderInfoPageViewModel(schedulerProvider, helper, remote, mapper));
    }

    @Provides
    public RentInfoViewViewModel provideRentInfoViewViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper) {
        return createViewModel(fragment, RentInfoViewViewModel.class, () -> new RentInfoViewViewModel(schedulerProvider, mapper));
    }

    @Provides
    public BookDetailPageViewModel provideBookDetailPageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, @UserId UUID userId) {
        return createViewModel(fragment, BookDetailPageViewModel.class, () -> new BookDetailPageViewModel(schedulerProvider, remote, userId));
    }

    @Provides
    public AddRentBookViewViewModel provideAddRentBookViewViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, AddRentBookViewViewModel.class, () -> new AddRentBookViewViewModel(schedulerProvider));
    }

    @Provides
    public AddRentBookDetailViewModel provideAddRentBookDetailViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, AddRentBookDetailViewModel.class, () -> new AddRentBookDetailViewModel(schedulerProvider));
    }

    @Provides
    public RateDetailViewModel provideRatingBooksDetailPageViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, PreferencesHelper helper, ModelRemote remote) {
        return createViewModel(fragment, RateDetailViewModel.class, () -> new RateDetailViewModel(schedulerProvider, mapper, remote, helper));
    }

    @Provides
    public NotificationPageViewModel provideNotificationPageViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, NotificationPageViewModel.class, () -> new NotificationPageViewModel(schedulerProvider));
    }

    @Provides
    public NotificationOrderViewModel provideNotificationOrderViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, NotificationOrderViewModel.class, () -> new NotificationOrderViewModel(schedulerProvider));
    }

    @Provides
    public RentedViewPageViewModel provideRentedViewPageViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, PreferencesHelper preferencesHelper) {
        return createViewModel(fragment, RentedViewPageViewModel.class, () -> new RentedViewPageViewModel(schedulerProvider, mapper, preferencesHelper));
    }

    @Provides
    public RentingViewPageViewModel provideRentingViewPageViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, PreferencesHelper preferencesHelper) {
        return createViewModel(fragment, RentingViewPageViewModel.class, () -> new RentingViewPageViewModel(schedulerProvider, mapper, preferencesHelper));
    }

    @Provides
    public SearchBookViewViewModel provideSearchBookViewViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, ViewModelMapper mapper) {
        return createViewModel(fragment, SearchBookViewViewModel.class, () -> new SearchBookViewViewModel(schedulerProvider, remote, mapper));
    }

    @Provides
    public SearchBookViewResultViewModel provideSearchBookViewResultViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper) {
        return createViewModel(fragment, SearchBookViewResultViewModel.class, () -> new SearchBookViewResultViewModel(schedulerProvider, mapper));
    }

    @Provides
    public ShipmentArrivedViewPageViewModel provideShipmentArrivedViewPageViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, PreferencesHelper preferencesHelper) {
        return createViewModel(fragment, ShipmentArrivedViewPageViewModel.class, () -> new ShipmentArrivedViewPageViewModel(schedulerProvider, mapper, preferencesHelper));
    }

    @Provides
    public ShippingViewPageViewModel provideShippingViewPageViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, PreferencesHelper preferencesHelper) {
        return createViewModel(fragment, ShippingViewPageViewModel.class, () -> new ShippingViewPageViewModel(schedulerProvider, mapper, preferencesHelper));
    }

    @Provides
    public WaitingOrderListViewModel provideWaitingOrderViewPageViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, PreferencesHelper preferencesHelper) {
        return createViewModel(fragment, WaitingOrderListViewModel.class, () -> new WaitingOrderListViewModel(schedulerProvider, mapper, preferencesHelper));
    }

    @Provides
    public MyOrderNotificationViewModel provideMyOrderNotificationViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, MyOrderNotificationViewModel.class, () -> new MyOrderNotificationViewModel(schedulerProvider));
    }

    @Provides
    public VoucherNotificaitonViewModel provideVoucherNotificaitonViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, VoucherNotificaitonViewModel.class, () -> new VoucherNotificaitonViewModel(schedulerProvider));
    }

    @Provides
    public OtherNotificationViewModel provideOtherNotificationViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, OtherNotificationViewModel.class, () -> new OtherNotificationViewModel(schedulerProvider));
    }

    @Provides
    public IntroFirstPageViewModel provideIntroFirstPageViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, IntroFirstPageViewModel.class, () -> new IntroFirstPageViewModel(schedulerProvider));
    }

    @Provides
    public IntroSecondPageViewModel provideIntroSecondPageViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, IntroSecondPageViewModel.class, () -> new IntroSecondPageViewModel(schedulerProvider));
    }

    @Provides
    public IntroThirdPageViewModel provideIntroThirdPageViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, IntroThirdPageViewModel.class, () -> new IntroThirdPageViewModel(schedulerProvider));
    }

    @Provides
    public IntroFourthPageViewModel provideIntroFourthPageViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, IntroFourthPageViewModel.class, () -> new IntroFourthPageViewModel(schedulerProvider));
    }

    @Provides
    public AllBooksViewViewModel provideAllBooksViewViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper) {
        return createViewModel(fragment, AllBooksViewViewModel.class, () -> new AllBooksViewViewModel(schedulerProvider, mapper));
    }

    @Provides
    public FamiliarBooksViewModel provideFamiliarBooksViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, PreferencesHelper helper) {
        return createViewModel(fragment, FamiliarBooksViewModel.class, () -> new FamiliarBooksViewModel(schedulerProvider, mapper, helper));
    }

    @Provides
    public ForYouBooksViewModel provideForYouBooksViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, PreferencesHelper preferencesHelper) {
        return createViewModel(fragment, ForYouBooksViewModel.class, () -> new ForYouBooksViewModel(schedulerProvider, mapper, preferencesHelper));
    }

    @Provides
    public PopularBooksViewModel providePopularBooksViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper) {
        return createViewModel(fragment, PopularBooksViewModel.class, () -> new PopularBooksViewModel(schedulerProvider, mapper));
    }

    @Provides
    public OrderDetailViewModel provideOrderDetailViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, ModelRemote remote) {
        return createViewModel(fragment, OrderDetailViewModel.class, () -> new OrderDetailViewModel(schedulerProvider, mapper, remote));
    }

    @Provides
    public LendSuccessViewModel provideLendSuccessViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, LendSuccessViewModel.class, () -> new LendSuccessViewModel(schedulerProvider));
    }

    @Provides
    public OrderSuccessViewModel provideOrderSuccessViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, OrderSuccessViewModel.class, () -> new OrderSuccessViewModel(schedulerProvider));
    }

    @Provides
    public OrderCheckerViewModel provideOrderCheckerViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, ModelRemote remote) {
        return createViewModel(fragment, OrderCheckerViewModel.class, () -> new OrderCheckerViewModel(schedulerProvider, mapper, remote));
    }

    @Provides
    public OrderRatingViewModel provideOrderRatingViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, ModelRemote remote) {
        return createViewModel(fragment, OrderRatingViewModel.class, () -> new OrderRatingViewModel(schedulerProvider, mapper, remote));
    }

    @Provides
    public RentDetailBillViewModel provideRentDetailBillViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        return createViewModel(fragment, RentDetailBillViewModel.class, () -> new RentDetailBillViewModel(schedulerProvider, remote));
    }

    @Provides
    public CancelOrderViewModel provideCancleOrderViewModel (SchedulerProvider schedulerProvider, ViewModelMapper mapper, PreferencesHelper helper) {
        return createViewModel(fragment, CancelOrderViewModel.class, () -> new CancelOrderViewModel(schedulerProvider, mapper, helper));
    }

    @Provides
    public SelectorVoucherViewModel provideSelectorVoucherViewModel (SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, SelectorVoucherViewModel.class, () -> new SelectorVoucherViewModel(schedulerProvider));
    }

    @Provides
    public NewsViewModel provideNewsViewModel (SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, NewsViewModel.class, () -> new NewsViewModel(schedulerProvider));
    }

    @Provides
    public ExplorerViewModel provideExplorerViewModel (SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, ExplorerViewModel.class, () -> new ExplorerViewModel(schedulerProvider));
    }

    @Provides
    public RateListBookViewModel provideRateListBookViewModel (SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, RateListBookViewModel.class, () -> new RateListBookViewModel(schedulerProvider));
    }

    @Provides
    public PopularNewsViewModel providePopularNewsViewModel (SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, PopularNewsViewModel.class, () -> new PopularNewsViewModel(schedulerProvider));
    }

    @Provides
    public FollowViewModel provideFollowViewModel (SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, FollowViewModel.class, () -> new FollowViewModel(schedulerProvider));
    }

    @Provides
    public CreateNewsViewModel provideCreateNewsViewModel (SchedulerProvider schedulerProvider) {
        return createViewModel(fragment, CreateNewsViewModel.class, () -> new CreateNewsViewModel(schedulerProvider));
    }

    @Provides
    public RecentListBookViewModel provideRecentListBookViewModel (SchedulerProvider schedulerProvider,ViewModelMapper mapper, PreferencesHelper helper) {
        return createViewModel(fragment, RecentListBookViewModel.class, () -> new RecentListBookViewModel(schedulerProvider,mapper, helper));
    }

//    @Provides
//    public OrderViewViewModel provideOrderViewViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper) {
//        return createViewModel(fragment, OrderViewViewModel.class, () -> new OrderViewViewModel(schedulerProvider, mapper));
//    }

    //endregion

    //region Adapters
    @Provides
    public VoucherItemAdapter provideVoucherItemAdapter(Context context) {
        return new VoucherItemAdapter(context);
    }

    @Provides
    public BookViewAdapter provideBookViewAdapter(Context context) {
        return new BookViewAdapter(context);
    }

    @Provides
    public OrderViewAdapter orderViewAdapter(Context context) {
        return new OrderViewAdapter(context);
    }

    @Provides
    public OrderBooksViewAdapter orderBooksViewAdapter(Context context) {
        return new OrderBooksViewAdapter(context);
    }

    @Provides
    public VoucherViewAdapter voucherViewAdapter(Context context) {
        return new VoucherViewAdapter(context);
    }

    @Provides
    public OtherAddressAdapter otherAddressAdapter(Context context) {
        return new OtherAddressAdapter(context);
    }

    @Provides
    public OtherBankAdapter otherBankAdapter(Context context) {
        return new OtherBankAdapter(context);
    }

    @Provides
    public CommentViewAdapter commentViewAdapter(Context context) {
        return new CommentViewAdapter(context);
    }

    @Provides
    public RentViewAdapter rentViewAdapter(Context context) {
        return new RentViewAdapter(context);
    }

    @Provides
    public OrderItemAdapter orderItemAdapter(Context context) {
        return new OrderItemAdapter(context);
    }

    @Provides
    public OncartItemAdapter oncartItemAdapter(Context context) {
        return new OncartItemAdapter(context);
    }

    @Provides
    public ListDataNotificationAdapter listDataNotificationAdapter(Context context) {
        return new ListDataNotificationAdapter(context);
    }
    //endregion
    //endregion

}
