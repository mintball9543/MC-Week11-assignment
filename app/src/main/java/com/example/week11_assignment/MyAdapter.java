package com.example.week11_assignment;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private ArrayList<PaintTitle> mDataset;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<PaintTitle> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public  MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Log.d("hwang", "onCreateViewHolder");


        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewitem, parent, false);  // recyclerview
        // View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewitem, parent, false);  // cardview
        MyViewHolder vh = new  MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.imageView.setImageResource(mDataset.get(position % 3).imageId);
        holder.tv1.setText(mDataset.get(position % 3).title);
        holder.tv2.setText(mDataset.get(position % 3).price);


        final int newpos = position % 3;
        final Context mycontext = holder.itemView.getContext();

        // 버튼 클릭 이벤트
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mycontext, mDataset.get(newpos).title, Toast.LENGTH_SHORT).show();
                String str = mDataset.get(newpos).title;
                String price = mDataset.get(newpos).price;
                int id = mDataset.get(newpos).imageId;
                String detail_msg = mDataset.get(newpos).detail_msg;

                Intent intent = new Intent(mycontext, DetailActivity.class);
                intent.putExtra("id", id);
                intent.putExtra("title", str);
                intent.putExtra("price", price);
                intent.putExtra("detail_msg", detail_msg);
                mycontext.startActivity(intent);
            }
        });


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
//        return 3;
          return mDataset.size();
    }

}
