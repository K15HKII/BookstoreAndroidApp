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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Register extends BaseFragment<RegisterFragmentBinding, RegisterViewModel> implements AdapterView.OnItemSelectedListener, RegisterNavigator {

    private DatePickerDialog.OnDateSetListener datePickerDOB;
    final Calendar myCalendar = Calendar.getInstance();
    private EditText edtDOB;

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
        RegisterFragmentBinding binding = getViewDataBinding();
        edtDOB = binding.etRegisterDOB;
        datePickerDOB = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, day);
                updateLabel();
            }
        };
        edtDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(getContext(),datePickerDOB,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        viewModel.setNavigator(Register.this);
        return view;
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.TAIWAN);
        edtDOB.setText(dateFormat.format(myCalendar.getTime()));
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
