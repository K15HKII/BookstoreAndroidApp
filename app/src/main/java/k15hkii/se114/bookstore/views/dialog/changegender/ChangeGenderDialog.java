package k15hkii.se114.bookstore.views.dialog.changegender;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import k15hkii.se114.bookstore.BookstoreApp;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.ChangeGenderDialogBinding;
import k15hkii.se114.bookstore.databinding.ChangeNameDialogBinding;
import k15hkii.se114.bookstore.di.component.DaggerDialogComponent;
import k15hkii.se114.bookstore.di.component.DialogComponent;
import k15hkii.se114.bookstore.di.module.DialogModule;
import k15hkii.se114.bookstore.viewmodel.base.BaseDialog;
import k15hkii.se114.bookstore.views.dialog.changename.ChangeNameDialog;
import k15hkii.se114.bookstore.views.dialog.changename.ChangeNameDialogViewModel;

import javax.inject.Inject;

public class ChangeGenderDialog extends BaseDialog implements ChangeGenderDialogCallBack {

    private static final String TAG = "ChangeGenderDialog";

    @Inject
    ChangeGenderViewModel changeGenderViewModel;

    public static ChangeGenderDialog newInstance() {
        ChangeGenderDialog fragment = new ChangeGenderDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ChangeGenderDialogBinding binding = DataBindingUtil.inflate( inflater, R.layout.change_gender_dialog, container, false);
        View view =binding.getRoot();

        performDependencyInjection(getBuildComponent());

        binding.setViewModel(changeGenderViewModel);
        changeGenderViewModel.setNavigator(this);
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
    public void onSubmitGender() {
        dismissDialog(TAG);
    }
}
