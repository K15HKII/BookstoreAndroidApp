package k15hkii.se114.bookstore.views.address.edit;

import android.widget.Spinner;
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
import k15hkii.se114.bookstore.databinding.EditAddressFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;
import k15hkii.se114.bookstore.views.bankscreen.edit.EditBankPageNavigator;
import k15hkii.se114.bookstore.views.intro.cityspinneradapter.CitySpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class EditAddressPage extends BaseFragment<EditAddressFragmentBinding, EditAddressPageViewModel> implements EditAddressPageNavigator {

    private EditAddressFragmentBinding editAddressFragmentBinding;
    private EditAddressPageViewModel mViewModel;
    private Spinner spCity, spDistrict,spVillage;
    private CitySpinnerAdapter cityadapter,districtAdapter,villageadapter;

    public static EditAddressPage newInstance() {
        return new EditAddressPage();
    }

    @Override
    public int getBindingVariable() {
        return BR.EditAddressPageViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.edit_address_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        editAddressFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        spCity = view.findViewById(R.id.spEditAddressCity);
        spDistrict = view.findViewById(R.id.spEditAddressDistrict);
        spVillage = view.findViewById(R.id.spEditAddressVillage);

        List<String> lsCity = new ArrayList<>();
        lsCity.add("Hồ Chí Minh");
        lsCity.add("Hà Nội");
        lsCity.add("Hải Phòng");

        List<String> lsDistrict = new ArrayList<>();
        lsDistrict.add("Quận 7");
        lsDistrict.add("Quận 2");
        lsDistrict.add("Quận 1");

        List<String> lsVillage = new ArrayList<>();
        lsVillage.add("Tân Kiểng");
        lsVillage.add("Tân Quy");
        lsVillage.add("Phường 7");

        cityadapter = new CitySpinnerAdapter(getActivity(),lsCity);
        spCity.setAdapter(cityadapter);

        districtAdapter = new CitySpinnerAdapter(getActivity(),lsDistrict);
        spDistrict.setAdapter(districtAdapter);

        villageadapter = new CitySpinnerAdapter(getActivity(),lsVillage);
        spVillage.setAdapter(villageadapter);

        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(EditAddressPageViewModel.class);
        // TODO: Use the ViewModel
    }

}
