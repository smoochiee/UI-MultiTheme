package com.pkj.wow.multitheme.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pkj.wow.multitheme.R;
import com.pkj.wow.multitheme.ScrollingActivity;
import com.pkj.wow.multitheme.model.Theme;
import com.pkj.wow.multitheme.view.ThemeView;

import java.util.List;

public class ThemeAdapter extends RecyclerView.Adapter<ThemeAdapter.MyViewHolder> {
 
    private List<Theme> themeList;
 
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ThemeView themeView;
 
        public MyViewHolder(View view) {
            super(view);
            themeView = (ThemeView) view.findViewById(R.id.themeView);
        }
    }
 
 
    public ThemeAdapter(List<Theme> themeList) {
        this.themeList = themeList;
    }
 
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row_theme, parent, false);
 
        return new MyViewHolder(itemView);
    }
 
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Theme theme = themeList.get(position);
        holder.themeView.setTheme(theme);

        holder.themeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScrollingActivity.selectedTheme = position;
                ScrollingActivity.mTheme = ScrollingActivity.mThemeList.get(position).getId();
                holder.themeView.setActivated(true);
                ThemeAdapter.this.notifyDataSetChanged();
                ((ScrollingActivity)holder.themeView.getContext()).recreate();
            }
        });

        if(ScrollingActivity.selectedTheme == position){
            holder.themeView.setActivated(true);
        }else {
            holder.themeView.setActivated(false);
        }
    }
 
    @Override
    public int getItemCount() {
        return themeList.size();
    }
}