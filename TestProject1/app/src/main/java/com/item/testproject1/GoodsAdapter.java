package com.item.testproject1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.ViewHolder> {
    private List<Goods> mGoodsList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View goodsView;
        ImageView goodsImage;
        TextView goodsname;
        public ViewHolder(View view){
            super(view);
            goodsView=view;
            goodsImage=view.findViewById(R.id.goods_image);
            goodsname=view.findViewById(R.id.goods_name);
        }
    }
    public GoodsAdapter(List<Goods> goodsList){
        mGoodsList=goodsList;
    }
    @Override
    public GoodsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.goods_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
       holder.goodsView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int position =holder.getAdapterPosition();
               Goods goods=mGoodsList.get(position);
               Toast.makeText(v.getContext(),"你点击了"+goods.getName(),Toast.LENGTH_SHORT).show();
           }
       });
       holder.goodsImage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int position=holder.getAdapterPosition();
               Goods goods=mGoodsList.get(position);
               Toast.makeText(v.getContext(),"你点击了"+goods.getName(),Toast.LENGTH_SHORT).show();
           }
       });
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull GoodsAdapter.ViewHolder holder, int position) {
        Goods goods=mGoodsList.get(position);
        holder.goodsImage.setImageResource(goods.getImageId());
        holder.goodsname.setText(goods.getName());
    }
    @Override
    public int getItemCount() {
        return mGoodsList.size();
    }
}
