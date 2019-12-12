package com.showly.commodityclassifydemo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.showly.commodityclassifydemo.R;
import com.showly.commodityclassifydemo.bean.ThemeMainReq;

import java.util.List;

public class ThemeMainAdapter extends RecyclerView.Adapter<ThemeMainAdapter.ViewHolder> {
    private Context mContext;
    private List<ThemeMainReq.DatasBean> listinfos;

    public ThemeMainAdapter(Context context) {
        this.mContext = context;
    }

    //接收数据
    public void setData(List<ThemeMainReq.DatasBean> listinfos) {
        this.listinfos = listinfos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.itemView.setId(position);

        ThemeMainReq.DatasBean datasBean = listinfos.get(position);
        holder.text_content.setText(datasBean.getShowName());

        if (datasBean.isChick()) {
            holder.itemView.setBackgroundResource(R.drawable.auth_code_bg);
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#DDDDDD"));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSelectorListener.onSelect(v, position);
            }
        });

    }

    public interface OnSelectorListener {
        void onSelect(View view, int position);
    }

    public void setOnSelectorListener(OnSelectorListener listener) {
        mSelectorListener = listener;
    }

    private OnSelectorListener mSelectorListener;

    @Override
    public int getItemCount() {
        return listinfos.size() == 0 ? 0 : listinfos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text_content;

        public ViewHolder(View itemView) {
            super(itemView);
            text_content = itemView.findViewById(R.id.tv);
        }
    }


}
