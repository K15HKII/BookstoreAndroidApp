package k15hkii.se114.bookstore.ui.dialog.changebirth;

import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;

public class ChangeBirthViewModel extends BaseViewModel<ChangeBirthCallBack> {

    @Inject
    protected ModelRemote remote;

    PreferencesHelper helper;

    public final ObservableField<String> userBirth = new ObservableField<>();

    public ChangeBirthViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper helper) {
        super(schedulerProvider);
        this.helper = helper;
        this.remote = remote;
        remote.getUser(helper.getCurrentUserId())
              .doOnSuccess(user -> {
            userBirth.set(user.getBirthday().toString());
        }).subscribe();
    }

    public void onSubmitBirthText(){
        getNavigator().dismissDialog();
    }
}
