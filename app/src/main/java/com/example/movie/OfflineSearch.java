package com.example.movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.movie.movie.Search;

import java.util.List;

public class OfflineSearch extends AppCompatActivity {
    OpenDBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline_search);
        db = new OpenDBHelper(this);
        final EditText edtSearch1 = findViewById(R.id.edtSearch1);
        Button btnSearch1 = findViewById(R.id.btnSearch1);
        btnSearch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edtSearch1.getText().toString();
                final RecyclerView recyclerView = findViewById(R.id.recycler1);
                List<Search> search = db.getData(s);

                RecyclerAdapter adapter = new RecyclerAdapter(search);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(OfflineSearch.this,
                        RecyclerView.VERTICAL,false));



            }
        });
    }
}
