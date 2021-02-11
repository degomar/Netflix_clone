package com.example.netflixapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;


public class MovieActivity extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar toolbar;
    private TextView txtTitle;
    private TextView txtDesc;
    private TextView txtCast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtTitle = findViewById(R.id.txt_view_title);
        txtDesc = findViewById(R.id.text_view_desc);
        txtCast = findViewById(R.id.text_view_cast);

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

    }
}