package com.brins.fitness;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.viewHolder> {


    private List<Tip> myList;
    private Context mContext;
    public AdapterRecycler(@NonNull List<Tip> myList) {
        this.myList=myList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (mContext==null)
        {
            mContext=parent.getContext();
        }
        viewHolder holder=new viewHolder(LayoutInflater.from(mContext).inflate(R.layout.gvitem,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Tip tip=myList.get(position);
        holder.textView.setText(tip.getTip().toString());
        holder.imageView.setImageResource(tip.getImageId());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    static class viewHolder extends RecyclerView.ViewHolder{

         ImageView imageView;
         TextView textView;
        public viewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.tip_iv);
            textView=itemView.findViewById(R.id.tip_tv);
        }
    }
}
