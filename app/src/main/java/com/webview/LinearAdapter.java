package com.webview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/5/18.
 */

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {
    private Context mContext;
    private OnItemClickListener mlistener;
    public LinearAdapter(Context context,OnItemClickListener listener){
        this.mContext=context;
        this.mlistener=listener;
    }
    @Override
    public LinearAdapter.LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item,parent,false));
    }

    @Override
    public void onBindViewHolder(LinearAdapter.LinearViewHolder holder, final int position) {
holder.textview.setText("Hello world");
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

        public LinearViewHolder(View itemView) {
            super(itemView);
            textview=itemView.findViewById(R.id.tv);
        }
    }
    public interface OnItemClickListener{
        void  onClick(int pos);
    }
}
