package k15hkii.se114.bookstore.ui.dialog.changename;

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
import k15hkii.se114.bookstore.di.component.DaggerDialogComponent;
import k15hkii.se114.bookstore.di.component.DialogComponent;
import k15hkii.se114.bookstore.di.module.DialogModule;
import k15hkii.se114.bookstore.ui.base.BaseDialog;

import javax.inject.Inject;

public class ChangeNameDialog extends BaseDialog implements ChangeNameCallBack {

    private static final String TAG = "ChangeNameDialog";

    @Inject protected ChangeNameDialogViewModel changeNameDialogViewModel;

    public static ChangeNameDialog newInstance() {
        ChangeNameDialog fragment = new ChangeNameDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ChangeNameDialogBinding binding = DataBindingUtil.inflate( inflater,R.layout.change_name_dialog, container, false);
        View view =binding.getRoot();

        performDependencyInjection(getBuildComponent());

        binding.setViewModel(changeNameDialogViewModel);
        changeNameDialogViewModel.setNavigator(this);

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
    public void dismissDialog() {
        dismissDialog(TAG);
    }
}
