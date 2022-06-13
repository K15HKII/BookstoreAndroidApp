package k15hkii.se114.bookstore.ui.dialog.changepassword;

import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.UUID;

public class ChangePassDialogViewModel extends BaseViewModel<ChangePassCallBack> {

    //TODO: Change Password viewModel

    @Inject
    protected ModelRemote remote;

    PreferencesHelper preferencesHelper;

    public final ObservableField<String> username = new ObservableField<>();

    public ChangePassDialogViewModel(SchedulerProvider schedulerProvider, PreferencesHelper helper) {
        super(schedulerProvider);
        this.preferencesHelper = helper;
    }

    public void onSubmitPass(){
        getNavigator().onSubmitPass();
    }
}
