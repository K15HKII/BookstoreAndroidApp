package k15hkii.se114.bookstore.ui.dialog.changegender;

import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;

public class ChangeGenderViewModel extends BaseViewModel<ChangeGenderDialogCallBack> {

    @Inject
    protected ModelRemote remote;

    PreferencesHelper helper;

    public final ObservableField<String> userGender = new ObservableField<>();

    public ChangeGenderViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper helper) {
        super(schedulerProvider);
        this.helper = helper;
        this.remote = remote;
        remote.getUser(helper.getCurrentUserId())
              .doOnSuccess(user -> {
                  userGender.set(user.getGender().toString());
              }).subscribe();
    }

    public void onSubmitGenderText(){
        getNavigator().onSubmitGender();
    }
}
