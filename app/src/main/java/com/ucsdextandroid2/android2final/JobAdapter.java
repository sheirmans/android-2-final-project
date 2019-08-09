package com.ucsdextandroid2.android2final;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class JobAdapter extends RecyclerView.Adapter<ListViewHolder>  {

    private List<? extends JobItem> items = new ArrayList<>();
    private OnItemClickListener<JobItem> onItemClickListener;


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListViewHolder listViewHolder = ListViewHolder.inflate(parent);
        listViewHolder.setClickListener( item -> {
            if(onItemClickListener != null)
                onItemClickListener.onItemClicked(item);
        });

        return listViewHolder;
    }
    public void submitList(@Nullable List<? extends JobItem> list){
        this.items = list;
        notifyDataSetChanged();
    }
    public void setOnItemClickListener(OnItemClickListener<JobItem>onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    private JobItem getItem(int position){return items.get(position);}

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.bind(getItem(position));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }




}
