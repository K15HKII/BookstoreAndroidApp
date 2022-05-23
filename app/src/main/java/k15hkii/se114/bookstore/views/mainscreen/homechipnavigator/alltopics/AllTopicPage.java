package k15hkii.se114.bookstore.views.mainscreen.homechipnavigator.alltopics;

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

import java.util.ArrayList;
import java.util.List;

public class AllTopicPage extends Fragment {

    private AllTopicViewModel mViewModel;
    private RecyclerView rcvTopics;
    private TopicAdapter topicAdapter;

    public static AllTopicPage newInstance() {
        return new AllTopicPage();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_topic_fragment, container, false);

        rcvTopics = view.findViewById(R.id.rcvHomeAllTopic);
        String[] TopicsArray = {"Văn học", "Giáo dục", "Công nghệ"};
        List<Topic> arrayName = new ArrayList<Topic>();
        for(int i=0;i< TopicsArray.length;i++){
            arrayName.add(new Topic(TopicsArray[i]));
        }

        topicAdapter = new TopicAdapter(arrayName);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        rcvTopics.setLayoutManager(linearLayoutManager);
        rcvTopics.setAdapter(topicAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AllTopicViewModel.class);
        // TODO: Use the ViewModel
    }

}
