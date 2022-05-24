package k15hkii.se114.bookstore.views.dialog.changephone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import k15hkii.se114.bookstore.BookstoreApp;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.ChangeNameDialogBinding;
import k15hkii.se114.bookstore.databinding.ChangePhoneNumberDialogBinding;
import k15hkii.se114.bookstore.di.component.DaggerDialogComponent;
import k15hkii.se114.bookstore.di.component.DialogComponent;
import k15hkii.se114.bookstore.di.module.DialogModule;
import k15hkii.se114.bookstore.viewmodel.base.BaseDialog;
import k15hkii.se114.bookstore.views.dialog.changename.ChangeNameDialog;

import javax.inject.Inject;

public class ChangePhoneNumDialog extends BaseDialog implements ChangePhoneNumCallBack {

    private final String TAG = "ChangePhoneNumberDialog";

    @Inject ChangePhoneNumViewModel changePhoneNumViewModel;

    public static ChangePhoneNumDialog newInstance() {
        ChangePhoneNumDialog fragment = new ChangePhoneNumDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ChangePhoneNumberDialogBinding binding = DataBindingUtil.inflate( inflater, R.layout.change_phone_number_dialog, container, false);
        View view =binding.getRoot();

        performDependencyInjection(getBuildComponent());

        binding.setViewModel(changePhoneNumViewModel);
        changePhoneNumViewModel.setNavigator(this);
        this.getDialog().setCanceledOnTouchOutside(true);

        return view;
    }

    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager, TAG);
    }

    private DialogComponent getBuildComponent(){
        return DaggerDialogComponent.builder()
                .appComponent(((BookstoreApp)(getContext().getApplicationContext())).getAppComponent())
                .dialogModule(new DialogModule(this))
                .build();
    }

    private void performDependencyInjection(DialogComponent buildComponent){
        buildComponent.inject(this);
    }

    @Override
    public void onSubmitPhone() {
        dismissDialog(TAG);
    }
}
