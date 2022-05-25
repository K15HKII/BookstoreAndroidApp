package k15hkii.se114.bookstore.di.module;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import k15hkii.se114.bookstore.data.remote.Authentication;
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
import k15hkii.se114.bookstore.ui.accountscreen.voucherscreen.VoucherPageViewModel;
import k15hkii.se114.bookstore.ui.accountscreen.voucherscreen.VoucherViewAdapter;
import k15hkii.se114.bookstore.ui.address.RecycleViewAddressSelector.OtherAddressAdapter;
import k15hkii.se114.bookstore.ui.address.SelectorAddressPageViewModel;
import k15hkii.se114.bookstore.ui.address.add.AddAddressPageViewModel;
import k15hkii.se114.bookstore.ui.address.edit.EditAddressPageViewModel;
import k15hkii.se114.bookstore.ui.bankscreen.RecycleViewBankSelector.OtherBankAdapter;
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
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentBookItemAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentViewAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderItemAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderViewAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.ratingbookview.RatingBookViewPageViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.shipmentarrived.ShipmentArrivedViewPageViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.shippingview.ShippingViewPageViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.waitingorderview.WaitingOrderViewPageViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.page.accountpage.AccountPageViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.page.favoritepage.FavoritePageViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.page.homepage.HomePageViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.page.rentpage.RentPageViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.page.shippingpage.ShippingPageViewModel;
import k15hkii.se114.bookstore.ui.notificationnews.NotificationPageViewModel;
import k15hkii.se114.bookstore.ui.oncartscreen.OncartItemAdapter;
import k15hkii.se114.bookstore.ui.oncartscreen.OncartViewViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.OrderInfoPageViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.PaymentMethodViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.RecycleViewOrderBooks.OrderBooksViewAdapter;
import k15hkii.se114.bookstore.ui.ratingbookscreen.RatingBooksDetailPageViewModel;
import k15hkii.se114.bookstore.ui.ratingbookscreen.RatingReportAdapter;
import k15hkii.se114.bookstore.ui.registerscreen.RegisterViewModel;
import k15hkii.se114.bookstore.ui.searchbook.RecentSearchAdapter;
import k15hkii.se114.bookstore.ui.searchbook.SearchBookViewResultViewModel;
import k15hkii.se114.bookstore.ui.searchbook.SearchBookViewViewModel;

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
    public RentBookItemAdapter rentBookItemAdapter(Context context) {
        return new RentBookItemAdapter(context);
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
    public RatingReportAdapter ratingReportAdapter(Context context) {
        return new RatingReportAdapter(context);
    }

    @Provides
    public RecentSearchAdapter recentSearchAdapter(Context context) {
        return new RecentSearchAdapter(context);
    }
    //endregion
    //endregion

}
