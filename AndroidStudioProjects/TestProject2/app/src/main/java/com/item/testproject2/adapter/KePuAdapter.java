package com.item.testproject2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.item.testproject2.R;
import com.item.testproject2.beans.KePu;
import com.item.testproject2.pojo.Article;

import java.util.List;


public class KePuAdapter extends RecyclerView.Adapter<KePuAdapter.ViewHolder> {
    private List<Article> mKePuList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView articleImage;
        TextView articleTitle;
        TextView articleContent;
        TextView articleDate;
        public ViewHolder(View view){
            super(view);
            articleImage=view.findViewById(R.id.kepu_image);
            articleTitle=view.findViewById(R.id.Article_title);
            articleContent=view.findViewById(R.id.Article_describe);
            articleDate=view.findViewById(R.id.Article_date);
        }
    }

    public KePuAdapter(List<Article> kePuList){
        mKePuList=kePuList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.kepu_layout,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Article article=mKePuList.get(position);
        holder.articleTitle.setText(article.getTitle());
        holder.articleContent.setText(article.getContent());
        holder.articleDate.setText((CharSequence) article.getDate());
    }

    @Override
    public int getItemCount() {
        return mKePuList.size();
    }
}
