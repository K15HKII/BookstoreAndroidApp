package k15hkii.se114.bookstore.ui.dialog.soldout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.SoldOutDialogBinding;
import k15hkii.se114.bookstore.di.component.DialogComponent;
import k15hkii.se114.bookstore.ui.base.BaseDialog;

import javax.inject.Inject;

public class SoldOutDialog extends BaseDialog implements SoldOutNavigator {

    private static final String TAG = "SoldOutDialog";

    @Inject
    SoldOutViewModel viewModel;

    public static SoldOutDialog newInstance() {
        SoldOutDialog fragment = new SoldOutDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SoldOutDialogBinding binding = DataBindingUtil.inflate(inflater, R.layout.sold_out_dialog, container, false);
        View view = binding.getRoot();
        binding.setViewModel(viewModel);
        viewModel.setNavigator(this);
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
