package k15hkii.se114.bookstore.ui.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.library.baseAdapters.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.NewsFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.news.adapter.NewsAdapter;

import javax.inject.Inject;

public class News extends BaseFragment<NewsFragmentBinding, NewsViewModel> implements NewsNavigator {

/*    private TabLayout tabmenuNav;
    private ViewPager2 newsView;*/

    @Inject
    protected NewsAdapter newsAdapter;

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

        binding.rvNewsView.setAdapter(newsAdapter);

       /* tabmenuNav = binding.tabMenuNewsNav;
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
        ).attach();*/
        viewModel.setNavigator(this);
        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

}
