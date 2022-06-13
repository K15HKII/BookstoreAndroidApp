package k15hkii.se114.bookstore.ui.accountscreen.helppage.delaccountrequest;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

public class DeleteAccountViewModel extends BaseViewModel<DeleteAccountNavigator> implements Observable {
    public DeleteAccountViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public final ObservableField<String> reason = new ObservableField<>();

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    public void SubmitDeleteAccount(){
        //TODO: Delete Account
        getNavigator().OpenLoginNavigator();
    }

}
