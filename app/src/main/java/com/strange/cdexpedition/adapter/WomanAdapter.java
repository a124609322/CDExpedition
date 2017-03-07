package com.strange.cdexpedition.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.strange.cdexpedition.R;
import com.strange.cdexpedition.vo.Woman;

import java.util.List;

/**
 * Created by AngerYman on 2017/3/2.
 */

public class WomanAdapter extends RecyclerView.Adapter<WomanAdapter.ViewHolder> {

    private List<Woman> womanList;

    public WomanAdapter(List<Woman> womanList) {
        this.womanList = womanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.layout_woman,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Woman woman = womanList.get(position);
        holder.imageView.setImageResource(woman.getPhoto());
        holder.textView.setText(woman.getName());
    }

    @Override
    public int getItemCount() {
        return womanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.woman_header);
            textView = (TextView) itemView.findViewById(R.id.woman_name);
        }
    }
}
