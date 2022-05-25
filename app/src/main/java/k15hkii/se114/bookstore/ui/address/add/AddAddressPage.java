package k15hkii.se114.bookstore.ui.address.add;

import android.widget.AdapterView;
import android.widget.Spinner;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.AddAddressPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.intro.cityspinneradapter.CitySpinnerAdapter;

public class AddAddressPage extends BaseFragment<AddAddressPageFragmentBinding, AddAddressPageViewModel> implements AdapterView.OnItemSelectedListener,AddAddressPageNavigator {

    private AddAddressPageFragmentBinding addAddressPageFragmentBinding;
    private AddAddressPageViewModel mViewModel;
    private Spinner spCity, spDistrict,spVillage;
    private CitySpinnerAdapter cityadapter,districtAdapter,villageadapter;

    public static AddAddressPage newInstance() {
        return new AddAddressPage();
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.add_address_page_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        addAddressPageFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AddAddressPageViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
