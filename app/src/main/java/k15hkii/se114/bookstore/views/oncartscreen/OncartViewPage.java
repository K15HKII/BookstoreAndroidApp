package k15hkii.se114.bookstore.views.oncartscreen;

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
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.OncartViewFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class OncartViewPage extends BaseFragment<OncartViewFragmentBinding, OncartViewViewModel> implements OncartViewPageNavigator {

    private OncartViewFragmentBinding oncartViewFragmentBinding;
    private OncartViewViewModel mViewModel;
    RecyclerView rcvListOncart;
    OncartItemAdapter oncartItemAdapter;

    public static OncartViewPage newInstance() {
        return new OncartViewPage();
    }

    @Override
    public int getBindingVariable() {
        return BR.OncartViewPageViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.oncart_view_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        oncartViewFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        rcvListOncart = view.findViewById(R.id.lvOnCartViewListItems);
        String[] names = {"Sách Đắc Nhân Tâm","Sách Công Nghệ","Danh Nghiệp","Giải tích AKA Giải thích"};

        List<OncartItem> arrayName = new ArrayList<OncartItem>();
        for(int i=0;i<names.length;i++){
            arrayName.add(new OncartItem(names[i]));
        }

        oncartItemAdapter = new OncartItemAdapter(getActivity(),arrayName);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        rcvListOncart.setLayoutManager(linearLayoutManager);
        rcvListOncart.setAdapter(oncartItemAdapter);
        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(OncartViewViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }
}
