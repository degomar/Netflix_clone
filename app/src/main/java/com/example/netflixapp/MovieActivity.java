package com.example.netflixapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.netflixapp.Model.Movie;

import java.util.ArrayList;
import java.util.List;


public class MovieActivity extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar toolbar;
    private TextView txtTitle;
    private TextView txtDesc;
    private TextView txtCast;
    private RecyclerView  recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtTitle = findViewById(R.id.txt_view_title);
        txtDesc = findViewById(R.id.text_view_desc);
        txtCast = findViewById(R.id.text_view_cast);
        recyclerView = findViewById(R.id.recycler_similar);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.arrow_back);
        }

        LayerDrawable drawable  = (LayerDrawable) ContextCompat.getDrawable(this, R.drawable.shadow);
        if (drawable != null){
           Drawable movieCover = ContextCompat.getDrawable(this, R.drawable.movie);
           drawable.setDrawableByLayerId(R.id.cover_movie_item, movieCover);
            ((ImageView)  findViewById(R.id.image_cover)).setImageDrawable(drawable);
        }

        txtTitle.setText("Batman Begins");
        txtDesc.setText(R.string.description);
        txtCast.setText(getString(R.string.cast,"Christian Bale, Michael Caine, Liam Neeson, Katie Holmes, Gary Oldman, Cillian Murphy, Tom Wilkinson, Morgan Freeman"));

        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Movie movie = new Movie();
            movies.add(movie);
        }

        recyclerView.setAdapter(new similarAdapter(movies));
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));


    }

    class similarAdapter extends RecyclerView.Adapter<similarAdapter.similarViewHolder>{

        private List<Movie> movies;

        public similarAdapter(List<Movie> movies) {
            this.movies = movies;
        }

        @NonNull
        @Override
        public similarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new similarViewHolder(getLayoutInflater().inflate(R.layout.movie_item_similar, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull similarViewHolder holder, int position) {
            Movie movie = movies.get(position);
           // holder.coverSimilar.setImageResource(movie.getCoverURL());

        }

        @Override
        public int getItemCount() {
            return movies.size();
        }

        class similarViewHolder  extends RecyclerView.ViewHolder{

            public ImageView coverSimilar;

           public similarViewHolder(@NonNull View itemView) {
               super(itemView);
            coverSimilar = itemView.findViewById(R.id.cover_movie_item);
           }

       }
    }



}