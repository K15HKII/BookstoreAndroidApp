package k15hkii.se114.bookstore.ui.dialog.changename;

import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.UUID;

public class ChangeNameDialogViewModel extends BaseViewModel<ChangeNameCallBack> {

    @Inject protected ModelRemote remote;
    private UUID userId;
    private String userName;

    public void setUserId(UUID userId) {
        this.userId = userId;

        remote.getUser(userId).doOnSuccess(user -> {
            userName = user.getFirstName() + " " + user.getLastName();
        }).subscribe();
    }

    public ChangeNameDialogViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onSubmitClick(){
        getNavigator().dismissDialog();
    }
}
