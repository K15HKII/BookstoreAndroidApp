package k15hkii.se114.bookstore.views.registerscreen;

import android.app.DatePickerDialog;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.widget.*;
import androidx.databinding.Observable;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.RegisterFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;

import java.util.Calendar;

public class Register extends BaseFragment<RegisterFragmentBinding, RegisterViewModel> implements AdapterView.OnItemSelectedListener, RegisterNavigator {

    private RegisterFragmentBinding registerFragmentBinding;
    private RegisterViewModel mViewModel;
    private Button btnRegister;
    private EditText etUsername,etDOB,etPhoneNum,etEmail,etPassword,etPasswordConfirm;
    private Spinner spGender;
    private TextView tvPolicy;
    private DatePickerDialog.OnDateSetListener datePickerDOB;
    private Calendar DOB;
    private boolean passwordVisible;

    public static Register newInstance() {
        return new Register();
    }

    @Override
    public int getBindingVariable() {
        return BR.RegisterViewModel;
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);
        // TODO: Use the ViewModel
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
