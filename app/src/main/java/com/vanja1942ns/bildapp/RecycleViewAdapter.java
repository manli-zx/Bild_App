package com.vanja1942ns.bildapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Book> mData;


    public RecycleViewAdapter(Context context, List<Book> data) {
        mContext = context;
        mData = data;
    }

    @Override
    //promeni i sa viewType,i promeni viewgroup sa parent u zagradi i dole kod falsa
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_book,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, final int position) {

        holder.tv_book_title.setText(mData.get(position).getTitle());
        holder.img_book_thumbnail.setImageResource(mData.get(position).getThumbnail());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Book_Activity.class);


                //passing data to the book activity

                intent.putExtra("BookTitle",mData.get(position).getTitle());
                intent.putExtra("Description",mData.get(position).getDescription());
                intent.putExtra("Thumbnail",mData.get(position).getThumbnail());
                //start the activity
                mContext.startActivity(intent);
            }
        });

        //Set click listener
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        TextView tv_book_title;
        ImageView img_book_thumbnail;
        CardView mCardView;



        public MyViewHolder( View itemView) {
            super(itemView);

            tv_book_title =  itemView.findViewById(R.id.book_name_id);
            img_book_thumbnail =  itemView.findViewById(R.id.book_img_id);
            mCardView = itemView.findViewById(R.id.cardview_id);


        }
    }

}
