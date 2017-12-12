package com.example.vinod.recyclerviewdemoone;

import android.icu.text.UnicodeSetSpanner;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.TooManyListenersException;
import java.util.zip.Inflater;

/**
 * Created by vinod on 10/12/17.
 */

public class ItemRecycler extends RecyclerView.Adapter<ItemRecycler.ViewHolder> {

    List<Model> list;
    onItemClick onItemClick;


    public ItemRecycler(List<Model> list,onItemClick onItemClick)
    {
        this.list=list;
        this.onItemClick=onItemClick;
    }
    @Override
    public ItemRecycler.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemRecycler.ViewHolder holder, final int position)
    {
        holder.textView1.setText(list.get(position).getText1());
        holder.textView2.setText(list.get(position).getText2());
        holder.imageView.setImageResource(list.get(position).getImages());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onClick(v,position);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textView1;
        TextView textView2;
        RelativeLayout relativeLayout;
        public ViewHolder(View itemView)
        {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.imageView);
            textView1=(TextView)itemView.findViewById(R.id.text1);
            textView2=(TextView)itemView.findViewById(R.id.text2);
            relativeLayout=(RelativeLayout)itemView.findViewById(R.id.relativeLayout);
        }
    }

    public interface onItemClick
    {
         void onClick(View view,int position);
    }

}
