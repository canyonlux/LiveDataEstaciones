package com.example.livedataestaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private SeasonViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(SeasonViewModel.class);
        ImageView imageView = findViewById(R.id.imageViewSeason);

        viewModel.getSeasonImageLiveData().observe(this, imageResId -> {
            imageView.setImageResource(imageResId);
        });
    }
}
