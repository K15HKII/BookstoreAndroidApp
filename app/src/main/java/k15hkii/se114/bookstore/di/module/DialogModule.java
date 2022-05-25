package k15hkii.se114.bookstore.di.module;

import dagger.Module;
import dagger.Provides;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseDialog;
import k15hkii.se114.bookstore.ui.dialog.buynow.BuyNowViewModel;
import k15hkii.se114.bookstore.ui.dialog.changebirth.ChangeBirthViewModel;
import k15hkii.se114.bookstore.ui.dialog.changegender.ChangeGenderViewModel;
import k15hkii.se114.bookstore.ui.dialog.changename.ChangeNameDialogViewModel;
import k15hkii.se114.bookstore.ui.dialog.changepassword.ChangePassDialogViewModel;
import k15hkii.se114.bookstore.ui.dialog.changephone.ChangePhoneNumViewModel;
import k15hkii.se114.bookstore.ui.dialog.filtersearch.FilterSearchViewModel;
import k15hkii.se114.bookstore.ui.dialog.logout.LogOutViewModel;
import k15hkii.se114.bookstore.ui.dialog.oncart.OnCartViewModel;

import static k15hkii.se114.bookstore.utils.ViewModelUtils.createViewModel;

@Module
public class DialogModule {
    private BaseDialog dialog;

    public DialogModule(BaseDialog dialog){
        this.dialog = dialog;
    }

    @Provides
    ChangeNameDialogViewModel provideChangeNameDialogViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(dialog, ChangeNameDialogViewModel.class, () -> new ChangeNameDialogViewModel(schedulerProvider));
    }

    @Provides
    ChangePassDialogViewModel provideChangePassDialogViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(dialog, ChangePassDialogViewModel.class, () -> new ChangePassDialogViewModel(schedulerProvider));
    }

    @Provides
    ChangePhoneNumViewModel provideChangePhoneNumViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(dialog, ChangePhoneNumViewModel.class, () -> new ChangePhoneNumViewModel(schedulerProvider));
    }

    @Provides
    ChangeGenderViewModel provideChangeGenderViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(dialog, ChangeGenderViewModel.class, () -> new ChangeGenderViewModel(schedulerProvider));
    }

    @Provides
    ChangeBirthViewModel provideChangeBirthViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(dialog, ChangeBirthViewModel.class, () -> new ChangeBirthViewModel(schedulerProvider));
    }

    @Provides
    FilterSearchViewModel provideFilterSearchViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(dialog, FilterSearchViewModel.class, () -> new FilterSearchViewModel(schedulerProvider));
    }

    @Provides
    BuyNowViewModel provideBuyNowViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(dialog, BuyNowViewModel.class, () -> new BuyNowViewModel(schedulerProvider));
    }

    @Provides
    OnCartViewModel provideOnCartViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(dialog, OnCartViewModel.class, () -> new OnCartViewModel(schedulerProvider));
    }

    @Provides
    LogOutViewModel provideLogOutViewModel(SchedulerProvider schedulerProvider){
        return createViewModel(dialog, LogOutViewModel.class, () -> new LogOutViewModel(schedulerProvider));
    }
}

