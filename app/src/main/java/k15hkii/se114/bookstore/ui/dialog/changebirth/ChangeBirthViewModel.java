package k15hkii.se114.bookstore.ui.dialog.changebirth;

import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;

public class ChangeBirthViewModel extends BaseViewModel<ChangeBirthCallBack> {

    @Inject
    protected ModelRemote remote;

    private String userBirth;

    private User user;

    public void setUserBirth(String id) {

//        remote.getUser(id).doOnSuccess(user -> {
//
//        })
    }

    public ChangeBirthViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onSubmitBirthText(){
        getNavigator().dismissDialog();
    }
}
