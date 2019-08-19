package com.example.movie;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movie.movie.Search;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    List<Search> list;
    public RecyclerAdapter(List<Search> list){
       this.list = list;

    }


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item,viewGroup,false);
        RecyclerViewHolder holder = new RecyclerViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {
        String title = list.get(i).getTitle();
        recyclerViewHolder.txtTitle.setText("title: "+title);
        String year = list.get(i).getYear();
        recyclerViewHolder.txtYear.setText("production year:"+year);
        String posterURL = list.get(i).getPoster();
        Picasso.get().load(posterURL).into(recyclerViewHolder.imgPoster);



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle;
        TextView txtYear;
        ImageView imgPoster;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtYear = itemView.findViewById(R.id.txtYear);
            imgPoster = itemView.findViewById(R.id.imgPoster);

        }
    }
}
