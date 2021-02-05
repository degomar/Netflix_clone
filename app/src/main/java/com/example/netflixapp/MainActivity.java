package com.example.netflixapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.netflixapp.Model.Category;
import com.example.netflixapp.Model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView_main;
    private homeRecycler homeRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Movie> movies = new ArrayList<>();
        Movie movie = new Movie();
        movie.setCoverURL(R.drawable.movie);
        movies.add(movie);

        List<Category> categoriesList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Category  category = new Category();
            category.setName("cat" + i);

            for (int j = 0; j < 30; j++) {
                Movie movie1 = new Movie();
                //movie1.setCoverURL(R.drawable.movie);
                movies.add(movie1);

            }
                category.setMovies(movies);
                categoriesList.add(category);



        }


        recyclerView_main = findViewById(R.id.recycler_view_main);
        homeRecycler = new homeRecycler(categoriesList);
        recyclerView_main.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView_main.setAdapter(homeRecycler);

    }

    class homeRecycler extends RecyclerView.Adapter<homeRecycler.CategoryHolder>{

        private List<Category> categories;

        public homeRecycler(List<Category> categories) {
            this.categories = categories;
        }



        @NonNull
        @Override
        public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new CategoryHolder(getLayoutInflater().inflate(R.layout.category_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
            Category category = categories.get(position);
            holder.textViewTitle.setText(category.getName());
            holder.recyclerViewMovie.setAdapter(new MovieAdapter(category.getMovies()));
            holder.recyclerViewMovie.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));

        }

        @Override
        public int getItemCount() {
            return categories.size();
        }



        class CategoryHolder extends RecyclerView.ViewHolder{

            TextView textViewTitle;
            RecyclerView recyclerViewMovie;

            public CategoryHolder(@NonNull View itemView) {
                super(itemView);

                textViewTitle = itemView.findViewById(R.id.category_title_item);
                recyclerViewMovie = itemView.findViewById(R.id.recycler_category_item);
            }
        }

    }


    class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder>{

        private List<Movie> movies;

        public MovieAdapter(List<Movie> movies) {
            this.movies = movies;
        }



        @NonNull
        @Override
        public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MovieHolder(getLayoutInflater().inflate(R.layout.movie_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
            Movie movie = movies.get(position);
           // holder.coverUrl.setImageResource(movie.getCoverURL());

        }

        @Override
        public int getItemCount() {
            return movies.size();
        }

        class MovieHolder extends RecyclerView.ViewHolder{

            ImageView coverUrl;
            public MovieHolder(@NonNull View itemView) {
                super(itemView);
                coverUrl = itemView.findViewById(R.id.cover_movie_item);
            }

        }



    }

}