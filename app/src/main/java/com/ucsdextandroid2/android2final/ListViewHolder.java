package com.ucsdextandroid2.android2final;


import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import okhttp3.internal.Util;

public class ListViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView titleView;
    private JobItem currentJobItem;
    private OnItemClickListener<JobItem> clickListener;

    public static ListViewHolder inflate(@NonNull ViewGroup parent){
        return new ListViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder, parent, false));
    }

    private ListViewHolder(@NonNull View itemView ){
        super (itemView);

        imageView = itemView.findViewById(R.id.vsi_image);
        titleView = itemView.findViewById((R.id.vsi_title));

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clickListener != null && currentJobItem != null)
                    clickListener.onItemClicked(currentJobItem);
            }
        });
    }
    public void bind (JobItem jobItem){
        this.currentJobItem = jobItem;


        titleView.setText(currentJobItem.getDescription());

    }
    public void setClickListener(OnItemClickListener<JobItem>clickListener){
        this.clickListener = clickListener;
    }
}
