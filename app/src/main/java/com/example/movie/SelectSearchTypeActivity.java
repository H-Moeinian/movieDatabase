package com.example.movie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.movie.movie.MovieInformation;

public class SelectSearchTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_search_type);
        Button btnOnline =findViewById(R.id.btnOnline);
        Button btnOffline = findViewById(R.id.btnOffline);
        btnOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectSearchTypeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectSearchTypeActivity.this, OfflineSearch.class);
                startActivity(intent);

            }
        });
    }
}
