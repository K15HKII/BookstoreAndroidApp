package k15hkii.se114.bookstore.di.component;

import dagger.Component;
import k15hkii.se114.bookstore.di.module.DialogModule;
import k15hkii.se114.bookstore.di.scope.DialogScope;
import k15hkii.se114.bookstore.ui.dialog.buynow.BuyNowDialog;
import k15hkii.se114.bookstore.ui.dialog.changebirth.ChangeBirthDialog;
import k15hkii.se114.bookstore.ui.dialog.changegender.ChangeGenderDialog;
import k15hkii.se114.bookstore.ui.dialog.changename.ChangeNameDialog;
import k15hkii.se114.bookstore.ui.dialog.changepassword.ChangePassDialog;
import k15hkii.se114.bookstore.ui.dialog.changephone.ChangePhoneNumDialog;
import k15hkii.se114.bookstore.ui.dialog.emptycart.EmptyCartDialog;
import k15hkii.se114.bookstore.ui.dialog.errordata.ErrorDataDialog;
import k15hkii.se114.bookstore.ui.dialog.failedcheck.FailedCheckDialog;
import k15hkii.se114.bookstore.ui.dialog.filtersearch.FilterSearchDialog;
import k15hkii.se114.bookstore.ui.dialog.logincheck.LoginCheckDialog;
import k15hkii.se114.bookstore.ui.dialog.logout.LogOutDialog;
import k15hkii.se114.bookstore.ui.dialog.missingdata.MissingDataDialog;
import k15hkii.se114.bookstore.ui.dialog.missinginfo.MissingInfoDialog;
import k15hkii.se114.bookstore.ui.dialog.oncart.OnCartDialog;

@DialogScope
@Component(modules = DialogModule.class, dependencies = AppComponent.class)
public interface DialogComponent {

    void inject(ChangeNameDialog changeNameDialog);

    void inject(ChangePassDialog changePassDialog);

    void inject(ChangePhoneNumDialog changePhoneNumDialog);

    void inject(ChangeGenderDialog changeGenderDialog);

    void inject(ChangeBirthDialog changeBirthDialog);

    void inject(FilterSearchDialog filterSearchDialog);

    void inject(BuyNowDialog buyNowDialog);

    void inject(OnCartDialog onCartDialog);

    void inject(LogOutDialog logOutDialog);

    void inject(LoginCheckDialog loginCheckDialog);

    void inject(FailedCheckDialog failedCheckDialog);

    void inject(MissingInfoDialog missingInfoDialog);

    void inject(ErrorDataDialog errorDataDialog);

    void inject(MissingDataDialog missingDataDialog);

    void inject(EmptyCartDialog emptyCartDialog);
}
