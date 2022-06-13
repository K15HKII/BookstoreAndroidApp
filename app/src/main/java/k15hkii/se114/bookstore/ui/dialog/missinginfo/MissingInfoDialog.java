package k15hkii.se114.bookstore.ui.dialog.missinginfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.MissingInfoDialogBinding;
import k15hkii.se114.bookstore.di.component.DialogComponent;
import k15hkii.se114.bookstore.ui.base.BaseDialog;

import javax.inject.Inject;

public class MissingInfoDialog extends BaseDialog implements MissingInfoNavigator {

    private static final String TAG = "MissingInfoDialog";

    @Inject
    MissingInfoViewModel missingInfoViewModel;

    public static MissingInfoDialog newInstance() {
        MissingInfoDialog fragment = new MissingInfoDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MissingInfoDialogBinding binding = DataBindingUtil.inflate(inflater, R.layout.missing_info_dialog, container, false);
        View view = binding.getRoot();
        binding.setViewModel(missingInfoViewModel);
        missingInfoViewModel.setNavigator(this);
        this.getDialog().setCanceledOnTouchOutside(true);
        return view;
    }

    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager, TAG);
    }

    @Override
    public void performDependencyInjection(DialogComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void dismissDialog() {
        dismissDialog(TAG);
    }
}
