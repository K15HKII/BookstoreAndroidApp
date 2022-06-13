package k15hkii.se114.bookstore.ui.news;

import android.util.Log;
import androidx.databinding.ObservableArrayList;
import k15hkii.se114.bookstore.data.model.api.message.Feedback;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.news.adapter.NewsAdapterViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

public class NewsViewModel extends BaseViewModel<NewsNavigator> {

    public final ObservableArrayList<NewsAdapterViewModel> news = new ObservableArrayList<>();

    private final ModelRemote remote;

    public NewsViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider);
        this.remote = remote;
        loadData();
    }

    public void loadData() {
        dispose(remote.getFeedbacks()
                        .map(feedbacks -> {
                            List<NewsAdapterViewModel> list = new ArrayList<>();
                            for (Feedback feedback : feedbacks) {
                                NewsAdapterViewModel viewModel = new NewsAdapterViewModel(getSchedulerProvider(), remote);
                                viewModel.setMessage(feedback);
                                list.add(viewModel);
                            }
                            return list;
                        }),
                news -> {
                    this.news.clear();
                    this.news.addAll(news);
                },
                throwable -> {
                    Log.d("NewsViewModel", "Error get feedbacks", throwable);
                });
    }

}
