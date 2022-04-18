package com.example.libraryapp.MainScreen.HomeScreen.HomeChipNavigation;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.libraryapp.R;
import com.example.libraryapp.ViewModel.AllTopicViewModel;

public class AllTopicPage extends Fragment {

    private AllTopicViewModel mViewModel;
    private ListView lsTopics;
    private ArrayAdapter<String> arrayAdapterTopic;

    public static AllTopicPage newInstance() {
        return new AllTopicPage();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_topic_fragment, container, false);

        lsTopics = view.findViewById(R.id.lvHomeAllTopic);
        String[] TopicsArray = {"Văn học", "Giáo dục", "Công nghệ"};

        arrayAdapterTopic = new ArrayAdapter<String>(getActivity(), R.layout.topic_adapter, TopicsArray);
        lsTopics.setAdapter(arrayAdapterTopic);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AllTopicViewModel.class);
        // TODO: Use the ViewModel
    }

}
