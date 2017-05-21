package com.fatchao.mvpbasedemo.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * author pangchao
 * created on 2017/5/20
 * email fat_chao@163.com.
 */
public abstract class RvHolder<T> extends RecyclerView.ViewHolder {
    private RvListener mListener;

    public RvHolder(View itemView, int type, RvListener listener) {
        super(itemView);
        this.mListener = listener;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(v.getId(), getAdapterPosition());
            }
        });
    }

    public abstract void bindHolder(T t, int position);

}
