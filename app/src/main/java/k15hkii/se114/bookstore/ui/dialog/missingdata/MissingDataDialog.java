package k15hkii.se114.bookstore.ui.dialog.missingdata;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.MissingDataDialogBinding;
import k15hkii.se114.bookstore.di.component.DialogComponent;
import k15hkii.se114.bookstore.ui.base.BaseDialog;

import javax.inject.Inject;

public class MissingDataDialog extends BaseDialog implements MissingDataNavigator {

    private static final String TAG = "MissingDataDialog";

    @Inject
    protected MissingDataViewModel viewModel;

    public static MissingDataDialog newInstance() {
        MissingDataDialog fragment = new MissingDataDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    public static MissingDataDialog newInstance(FragmentManager supportFragmentManager, Bundle bundle) {
        MissingDataDialog fragment = new MissingDataDialog();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MissingDataDialogBinding binding = DataBindingUtil.inflate(inflater, R.layout.missing_data_dialog, container, false);
        View view = binding.getRoot();
        binding.setViewModel(viewModel);
        viewModel.setNavigator(this);
        Bundle bundle = getArguments();
        if (bundle != null) {
            binding.tvErrorMess.setText(bundle.getString("error"));
        }
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
