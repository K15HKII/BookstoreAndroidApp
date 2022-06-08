package k15hkii.se114.bookstore.ui.dialog.changephone;

import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;

public class ChangePhoneNumViewModel extends BaseViewModel<ChangePhoneNumCallBack> {

    @Inject
    protected ModelRemote remote;

    PreferencesHelper helper;

    public final ObservableField<String> userPhone = new ObservableField<>();

    public ChangePhoneNumViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper helper) {
        super(schedulerProvider);
        this.helper = helper;
        this.remote = remote;
        remote.getUser(helper.getCurrentUserId())
              .doOnSuccess(user -> {
                  userPhone.set(user.getPhone());
              }).subscribe();
    }

    public void onSubmitPhoneTextClick(){
        getNavigator().onSubmitPhone();
    }
}
