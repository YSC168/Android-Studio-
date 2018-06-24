package com.webview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/5/18.
 */

class RecycAdapter extends RecyclerView.Adapter<RecycAdapter.LinearViewHolder> {

    private Context mContext;
    private OnItemClickListener mlistener;
    public RecycAdapter(Context context,OnItemClickListener listener){
        this.mContext=context;
        this.mlistener=listener;
    }
    @Override
    public RecycAdapter.LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.recyclerlayout_item,parent,false));
    }

    @Override
    public void onBindViewHolder(RecycAdapter.LinearViewHolder holder, final int position) {
        holder.textview.setText("Hello world");
        holder.imageView.setImageResource(R.drawable.tx);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mlistener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 500;
    }
    class LinearViewHolder extends RecyclerView.ViewHolder{
        private TextView textview;
        private ImageView imageView;

        public LinearViewHolder(View itemView) {
            super(itemView);
            textview=itemView.findViewById(R.id.tv);
            imageView=itemView.findViewById(R.id.iv);
        }
    }

    public interface OnItemClickListener{
        void  onClick(int pos);
    }
}
