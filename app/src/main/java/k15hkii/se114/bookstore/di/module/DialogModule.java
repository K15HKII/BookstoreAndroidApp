package k15hkii.se114.bookstore.di.module;

import dagger.Module;
import dagger.Provides;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseDialog;
import k15hkii.se114.bookstore.ui.dialog.buynow.BuyNowViewModel;
import k15hkii.se114.bookstore.ui.dialog.changebirth.ChangeBirthViewModel;
import k15hkii.se114.bookstore.ui.dialog.changeemail.ChangeEmailViewModel;
import k15hkii.se114.bookstore.ui.dialog.changegender.ChangeGenderViewModel;
import k15hkii.se114.bookstore.ui.dialog.changename.ChangeNameDialogViewModel;
import k15hkii.se114.bookstore.ui.dialog.changepassword.ChangePassDialogViewModel;
import k15hkii.se114.bookstore.ui.dialog.changephone.ChangePhoneNumViewModel;
import k15hkii.se114.bookstore.ui.dialog.emptycart.EmptyCartViewModel;
import k15hkii.se114.bookstore.ui.dialog.errordata.ErrorDataViewModel;
import k15hkii.se114.bookstore.ui.dialog.errornetwork.ErrorNetworkViewModel;
import k15hkii.se114.bookstore.ui.dialog.failedcheck.FailedCheckViewModel;
import k15hkii.se114.bookstore.ui.dialog.filtersearch.FilterSearchViewModel;
import k15hkii.se114.bookstore.ui.dialog.logincheck.LoginCheckViewModel;
import k15hkii.se114.bookstore.ui.dialog.logout.LogOutViewModel;
import k15hkii.se114.bookstore.ui.dialog.missingdata.MissingDataViewModel;
import k15hkii.se114.bookstore.ui.dialog.missinginfo.MissingInfoViewModel;
import k15hkii.se114.bookstore.ui.dialog.oncart.OnCartViewModel;
import k15hkii.se114.bookstore.ui.dialog.soldout.SoldOutViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import static k15hkii.se114.bookstore.utils.ViewModelUtils.createViewModel;

@Module
public class DialogModule {

    private final BaseDialog dialog;

    public DialogModule(BaseDialog dialog) {
        this.dialog = dialog;
    }

    @Provides
    ChangeNameDialogViewModel provideChangeNameDialogViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper helper) {
        return createViewModel(dialog, ChangeNameDialogViewModel.class, () -> new ChangeNameDialogViewModel(schedulerProvider, remote, helper));
    }

    @Provides
    ChangePassDialogViewModel provideChangePassDialogViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper helper) {
        return createViewModel(dialog, ChangePassDialogViewModel.class, () -> new ChangePassDialogViewModel(schedulerProvider, remote, helper));
    }

    @Provides
    ChangePhoneNumViewModel provideChangePhoneNumViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper helper) {
        return createViewModel(dialog, ChangePhoneNumViewModel.class, () -> new ChangePhoneNumViewModel(schedulerProvider, remote, helper));
    }

    @Provides
    ChangeGenderViewModel provideChangeGenderViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper helper) {
        return createViewModel(dialog, ChangeGenderViewModel.class, () -> new ChangeGenderViewModel(schedulerProvider, remote, helper));
    }

    @Provides
    ChangeBirthViewModel provideChangeBirthViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper helper) {
        return createViewModel(dialog, ChangeBirthViewModel.class, () -> new ChangeBirthViewModel(schedulerProvider, remote, helper));
    }

    @Provides
    FilterSearchViewModel provideFilterSearchViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(dialog, FilterSearchViewModel.class, () -> new FilterSearchViewModel(schedulerProvider));
    }

    @Provides
    BuyNowViewModel provideBuyNowViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper helper) {
        return createViewModel(dialog, BuyNowViewModel.class, () -> new BuyNowViewModel(schedulerProvider, remote, helper));
    }

    @Provides
    OnCartViewModel provideOnCartViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper helper) {
        return createViewModel(dialog, OnCartViewModel.class, () -> new OnCartViewModel(schedulerProvider, remote, helper));
    }

    @Provides
    LogOutViewModel provideLogOutViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(dialog, LogOutViewModel.class, () -> new LogOutViewModel(schedulerProvider));
    }

    @Provides
    LoginCheckViewModel provideLoginCheckViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(dialog, LoginCheckViewModel.class, () -> new LoginCheckViewModel(schedulerProvider));
    }

    @Provides
    FailedCheckViewModel provideFailedCheckViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(dialog, FailedCheckViewModel.class, () -> new FailedCheckViewModel(schedulerProvider));
    }

    @Provides
    MissingInfoViewModel provideMissingInfoViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(dialog, MissingInfoViewModel.class, () -> new MissingInfoViewModel(schedulerProvider));
    }

    @Provides
    ErrorDataViewModel provideErrorDataViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(dialog, ErrorDataViewModel.class, () -> new ErrorDataViewModel(schedulerProvider));
    }

    @Provides
    MissingDataViewModel provideMissingDataViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(dialog, MissingDataViewModel.class, () -> new MissingDataViewModel(schedulerProvider));
    }

    @Provides
    EmptyCartViewModel provideEmptyCartViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(dialog, EmptyCartViewModel.class, () -> new EmptyCartViewModel(schedulerProvider));
    }

    @Provides
    ErrorNetworkViewModel provideErrorNetworkViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(dialog, ErrorNetworkViewModel.class, () -> new ErrorNetworkViewModel(schedulerProvider));
    }

    @Provides
    SoldOutViewModel provideSoldOutViewModel(SchedulerProvider schedulerProvider) {
        return createViewModel(dialog, SoldOutViewModel.class, () -> new SoldOutViewModel(schedulerProvider));
    }

    @Provides
    ChangeEmailViewModel provideChangeEmailViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper helper) {
        return createViewModel(dialog, ChangeEmailViewModel.class, () -> new ChangeEmailViewModel(schedulerProvider, remote, helper));
    }

}

