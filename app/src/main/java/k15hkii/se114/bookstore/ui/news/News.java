package k15hkii.se114.bookstore.ui.news;

import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.NewsFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.OrderMenuTabAdapter;

public class News extends BaseFragment<NewsFragmentBinding, NewsViewModel> implements NewsNavigator {

    private TabLayout tabmenuNav;
    private ViewPager2 newsView;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.news_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        NewsFragmentBinding binding = getViewDataBinding();

        tabmenuNav = binding.tabMenuNewsNav;
        newsView = binding.vpNewsView;

        NewsMenuTab adapter = new NewsMenuTab(getActivity().getSupportFragmentManager(), this.getLifecycle());
        newsView.setAdapter(adapter);
        new TabLayoutMediator(tabmenuNav, newsView,
                (tab, position) -> {
                    String title = "";
                    switch (position) {
                        case 0:
                            title = "Khám phá";
                            break;
                        case 1:
                            title = "Đang theo dõi";
                            break;
                        case 2:
                            title = "Phố biến";
                            break;
                    }
                    tab.setText(title);
                }
        ).attach();
        viewModel.setNavigator(this);
        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

}
