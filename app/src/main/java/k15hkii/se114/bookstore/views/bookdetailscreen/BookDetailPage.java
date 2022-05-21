package k15hkii.se114.bookstore.views.bookdetailscreen;

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
import k15hkii.se114.bookstore.databinding.BookDetailViewFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class BookDetailPage extends BaseFragment<BookDetailViewFragmentBinding, BookDetailPageViewModel> implements BookDetailPageNavigator {

    private BookDetailViewFragmentBinding bookDetailViewFragmentBinding;
    private BookDetailPageViewModel mViewModel;
    private RecyclerView rcvCommentsList;
    private CommentViewAdapter commentViewAdapter;

    public static BookDetailPage newInstance() {
        return new BookDetailPage();
    }

    @Override
    public int getBindingVariable() {
        return BR.BookDetailPageViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.book_detail_view_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        bookDetailViewFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        String[] names = {"tritran@gm.com","tritran12@gm.com","tritran45@gm.com"};
        List<Comment> arrayName = new ArrayList<Comment>();
        for(int i=0;i<names.length;i++){
            arrayName.add(new Comment(names[i]));
        }

        rcvCommentsList = view.findViewById(R.id.rcvDeltailBookCommentList);
        commentViewAdapter = new CommentViewAdapter(arrayName,getActivity());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        rcvCommentsList.setLayoutManager(linearLayoutManager);
        rcvCommentsList.setAdapter(commentViewAdapter);

        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(BookDetailPageViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }
}
