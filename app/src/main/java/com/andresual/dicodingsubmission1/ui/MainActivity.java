package com.andresual.dicodingsubmission1.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.andresual.dicodingsubmission1.R;
import com.andresual.dicodingsubmission1.adapter.MovieAdapter;
import com.andresual.dicodingsubmission1.model.MovieModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataTitle;
    private String[] dataDesc;
    private String[] dataYear;
    private TypedArray dataImg;
    private MovieAdapter adapter;

    private ArrayList<MovieModel> movieModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_movie);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MovieModel movieModel = new MovieModel();
                movieModel.setTitle(movieModelArrayList.get(i).getTitle());
                movieModel.setDesc(movieModelArrayList.get(i).getDesc());
                movieModel.setYear(movieModelArrayList.get(i).getYear());
                movieModel.setImg(movieModelArrayList.get(i).getImg());
                Intent moveWithObjectIntent = new Intent(MainActivity.this, DetailActivity.class);
                moveWithObjectIntent.putExtra(DetailActivity.EXTRA_MOVIE, movieModel);
                startActivity(moveWithObjectIntent);
            }
        });
    }

    private void addItem() {
        movieModelArrayList = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            MovieModel movieModel = new MovieModel();
            movieModel.setTitle(dataTitle[i]);
            movieModel.setDesc(dataDesc[i]);
            movieModel.setYear(dataYear[i]);
            movieModel.setImg(dataImg.getResourceId(i, -1));
            movieModelArrayList.add(movieModel);
        }
        adapter.setMovieModelArrayList(movieModelArrayList);
    }

    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataDesc = getResources().getStringArray(R.array.data_description);
        dataYear = getResources().getStringArray(R.array.data_year);
        dataImg = getResources().obtainTypedArray(R.array.data_photo);
    }
}
