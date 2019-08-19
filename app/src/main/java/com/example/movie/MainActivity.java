package com.example.movie;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.movie.movie.MovieInformation;
import com.example.movie.movie.Search;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import org.json.JSONObject;

import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    OpenDBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new OpenDBHelper(this);
        final EditText edtName = findViewById(R.id.edtName);
        Button btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final RecyclerView recyclerView = findViewById(R.id.recycler);
                AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
                asyncHttpClient.get("https://www.omdbapi.com/?s="+edtName.getText().toString()+"&apikey=4f3ca53",
                        new JsonHttpResponseHandler(){
                            @Override
                            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                                super.onSuccess(statusCode, headers, response);
                                Gson gson = new Gson();
                                MovieInformation  movieInformation = gson.fromJson(response.toString(),MovieInformation.class);

                                List<Search>  search = movieInformation.getSearch();
                                db.addData(search);
                                RecyclerAdapter adapter = new RecyclerAdapter(search);
                                recyclerView.setAdapter(adapter);
                                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                                        RecyclerView.VERTICAL,false));


                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                                super.onFailure(statusCode, headers, throwable, errorResponse);
                            }
                        });
            }
        });



    }
}
