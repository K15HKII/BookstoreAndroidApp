package k15hkii.se114.bookstore.di.component;

import dagger.Component;
import k15hkii.se114.bookstore.di.module.DialogModule;
import k15hkii.se114.bookstore.di.scope.DialogScope;
import k15hkii.se114.bookstore.views.dialog.buynow.BuyNowDialog;
import k15hkii.se114.bookstore.views.dialog.changebirth.ChangeBirthDialog;
import k15hkii.se114.bookstore.views.dialog.changegender.ChangeGenderDialog;
import k15hkii.se114.bookstore.views.dialog.changename.ChangeNameDialog;
import k15hkii.se114.bookstore.views.dialog.changepassword.ChangePassDialog;
import k15hkii.se114.bookstore.views.dialog.changephone.ChangePhoneNumDialog;
import k15hkii.se114.bookstore.views.dialog.filtersearch.FilterSearchDialog;
import k15hkii.se114.bookstore.views.dialog.logout.LogOutDialog;
import k15hkii.se114.bookstore.views.dialog.oncart.OnCartDialog;

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
}
