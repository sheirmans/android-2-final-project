package com.ucsdextandroid2.android2final;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavoriteFragment extends Fragment {
    private JobAdapter jobAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jobAdapter = new JobAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_job, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.am_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(jobAdapter);

        jobAdapter.setOnItemClickListener(new OnItemClickListener<JobItem>() {
            @Override
            public void onItemClicked(JobItem item) {
                Toast.makeText(requireContext(), item.getDescription(), Toast.LENGTH_SHORT).show();
            }
        });

        AppDatabase.get(requireContext()).jobDao()
                .getAllJobsLiveData()
                .observe(this, new Observer<List<JobItem>>() {
                    @Override
                    public void onChanged(List<JobItem> job) {
                        jobAdapter.submitList(job);
                    }
                });
    }

}
