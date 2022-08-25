package com.example.ecommerce.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.ecommerce.Model.CategoryModel;
import com.example.ecommerce.R;
import com.github.vipulasri.timelineview.TimelineView;

import java.util.ArrayList;

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.Viewholder> {

    private ArrayList<CategoryModel> arrayList_routs;

    public TimelineAdapter(ArrayList<CategoryModel> arrayList_routs) {

        this.arrayList_routs = arrayList_routs;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate( R.layout.custom_track,parent,false);

        return new Viewholder(view,viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        CategoryModel model = arrayList_routs.get(position);
        holder.text_timeline_title.setText(model.getName());
    }

    @Override
    public int getItemCount() {

        return arrayList_routs.size();
    }

    @Override
    public int getItemViewType(int position) {
        return TimelineView.getTimeLineViewType(position, getItemCount());
    }


    public class Viewholder extends RecyclerView.ViewHolder
    {
        AppCompatTextView text_timeline_title;
        TimelineView mTimelineView;

        public Viewholder(@NonNull View itemView, int viewType) {
            super(itemView);
            text_timeline_title = itemView.findViewById(R.id.title);
            mTimelineView = itemView.findViewById(R.id.timeline);
            mTimelineView.initLine(viewType);
        }
    }
}
