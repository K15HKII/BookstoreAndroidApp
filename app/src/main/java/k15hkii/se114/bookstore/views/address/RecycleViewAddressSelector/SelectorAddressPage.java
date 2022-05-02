package k15hkii.se114.bookstore.views.address.RecycleViewAddressSelector;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.viewmodel.AddressChoiceViewModel;
import k15hkii.se114.bookstore.views.address.Address;

import java.util.ArrayList;
import java.util.List;

public class SelectorAddressPage extends Fragment {

    private AddressChoiceViewModel mViewModel;
    private RecyclerView rcvOtherAddress;
    private OtherAddressAdapter otherAddressAdapter;

    public static SelectorAddressPage newInstance() {
        return new SelectorAddressPage();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.selector_address_fragment, container, false);

        rcvOtherAddress = view.findViewById(R.id.rcvAddressChoiceOtherAddress);

        String[] names = {"Biên Hòa, Đồng Nai","Vạn Ninh, Khánh Hòa"};

        List<Address> arrayName = new ArrayList<Address>();
        for(int i=0;i<names.length;i++){
            arrayName.add(new Address(names[i]));
        }

        otherAddressAdapter = new OtherAddressAdapter(arrayName,getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        rcvOtherAddress.setLayoutManager(linearLayoutManager);
        rcvOtherAddress.setAdapter(otherAddressAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AddressChoiceViewModel.class);
        // TODO: Use the ViewModel
    }

}
