package k15hkii.se114.bookstore.ui.dialog.changegender;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.ObservableList;
import k15hkii.se114.bookstore.data.model.api.user.Gender;
import k15hkii.se114.bookstore.data.model.api.user.ProfileUpdateRequest;
import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.SpinnerWrapper;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.Arrays;

public class ChangeGenderViewModel extends BaseViewModel<ChangeGenderDialogCallBack> {

    @Inject
    protected ModelRemote remote;

    PreferencesHelper helper;

    User user;

    public final ObservableInt genderIndex = new ObservableInt(0);
    public final ObservableList<SpinnerWrapper<Gender>> gender = new ObservableArrayList<>();

    public void getData() {
        dispose(remote.getSelfUser(),
                user -> {
                    this.user = user;
                },
                throwable -> { });
    }

    public ChangeGenderViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper helper) {
        super(schedulerProvider);
        this.helper = helper;
        this.remote = remote;
        gender.addAll(Arrays.asList(SpinnerWrapper.toSpinner(Gender.values())));
    }

    public void onSubmitGenderText(){
        ProfileUpdateRequest request = new ProfileUpdateRequest();
        request.setGender(gender.get(genderIndex.get()).getItem());
        dispose(remote.updateSelfUser(request),
                user -> {
                    getNavigator().onSubmitGender();
                },
                throwable -> { });

    }

}
