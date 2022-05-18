package k15hkii.se114.bookstore.views.mainscreen.RentScreen.menutab;

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
import k15hkii.se114.bookstore.views.mainscreen.RentScreen.RentBooksRecycleView.RentBookItem;
import k15hkii.se114.bookstore.views.mainscreen.RentScreen.RentBooksRecycleView.RentView;
import k15hkii.se114.bookstore.views.mainscreen.RentScreen.RentBooksRecycleView.RentViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class RentedViewPage extends Fragment {

    public static RentedViewPage newInstance() {
        return new RentedViewPage();
    }

    private RentedViewPageViewModel mViewModel;
    private RecyclerView rcvRentView;
    private RentViewAdapter rentViewAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rented_view_page_fragment, container, false);

        rcvRentView = view.findViewById(R.id.rcvRentedBookView);
        rentViewAdapter = new RentViewAdapter(getListBook(),RentedViewPage.this.getContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RentedViewPage.this.getContext());
        rcvRentView.setLayoutManager(linearLayoutManager);
        rcvRentView.setAdapter(rentViewAdapter);

        return  view;
    }

    private List<RentView> getListBook() {
        List<RentView> lsRentOrder = new ArrayList<>();

        List<RentBookItem> lsBook1 = new ArrayList<>();
        lsBook1.add(new RentBookItem("Dac Nhan Tam"));
        lsBook1.add(new RentBookItem("hello"));


        List<RentBookItem> lsBook2 = new ArrayList<>();
        lsBook2.add(new RentBookItem("Dac Nhan Tam"));

        lsRentOrder.add(new RentView("20.000đ","nothing1",lsBook1));
        lsRentOrder.add(new RentView("10.000đ","nothing2",lsBook2));

        return lsRentOrder;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RentedViewPageViewModel.class);
        // TODO: Use the ViewModel
    }

}
