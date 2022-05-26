package k15hkii.se114.bookstore.ui.forgotpassscreen;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;

public class ForgotPasswordViewModel extends BaseViewModel<ForgotPassNavigator> implements Observable {

    @Inject
    protected ModelRemote remote;
    private String email;
    private String userId;

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        remote.getUser(userId).doOnSuccess(user -> {
            this.email = Integer.toString(user.getEmail());
        }).subscribe();
    }

    public ForgotPasswordViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public ForgotPasswordViewModel(String userId, SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
        this.userId = userId;
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
