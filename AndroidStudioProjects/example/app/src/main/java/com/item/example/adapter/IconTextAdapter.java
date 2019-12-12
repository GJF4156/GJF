package com.item.example.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.item.example.IconFont.FontIconView;
import com.item.example.R;
import com.item.example.beans.IconText;

import java.util.List;

public class IconTextAdapter extends RecyclerView.Adapter<IconTextAdapter.ViewHolder> {
    private List<IconText> mIconTextList;
    private addClickListerner listener;

    public static interface addClickListerner{
        public void addClick(int position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View iconTextView;
        FontIconView icon;
        TextView iconText;
        public ViewHolder(View view){
            super(view);
            iconTextView=view;
            icon=view.findViewById(R.id.center_icon);
            iconText=view.findViewById(R.id.center_icon_text);
        }
    }

    public void setCusClickListener(addClickListerner cusClickListener) {
        this.listener = cusClickListener;
    }

    public IconTextAdapter(List<IconText> iconTextList){
        mIconTextList=iconTextList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.icon_text,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.iconTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                IconText iconText=mIconTextList.get(position);
                //Toast.makeText(v.getContext(),"点击"+iconText.getIcontext()+position,Toast.LENGTH_SHORT).show();
                listener.addClick(position);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       IconText iconText=mIconTextList.get(position);
       holder.icon.setText(iconText.getIcon());
       holder.iconText.setText(iconText.getIcontext());
    }

    @Override
    public int getItemCount() {
        return mIconTextList.size();
    }
}
