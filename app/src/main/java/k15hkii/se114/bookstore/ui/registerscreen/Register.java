package k15hkii.se114.bookstore.ui.registerscreen;

import android.app.DatePickerDialog;
import android.widget.*;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.RegisterFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.loginscreen.LoadingDialog;

import java.util.Calendar;

public class Register extends BaseFragment<RegisterFragmentBinding, RegisterViewModel> implements AdapterView.OnItemSelectedListener, RegisterNavigator {

    private RegisterFragmentBinding registerFragmentBinding;
    private DatePickerDialog.OnDateSetListener datePickerDOB;
    private Calendar DOB;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.register_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        registerFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(Register.this);
        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

//    Thiết lập combobox selected item
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }


}
