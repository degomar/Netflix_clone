package com.example.netflixapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toolbar;


public class MovieActivity extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
    }
}