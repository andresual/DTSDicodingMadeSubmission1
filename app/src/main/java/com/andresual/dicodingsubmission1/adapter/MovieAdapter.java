package com.andresual.dicodingsubmission1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.andresual.dicodingsubmission1.R;
import com.andresual.dicodingsubmission1.model.MovieModel;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<MovieModel> movieModelArrayList;

    public void setMovieModelArrayList(ArrayList<MovieModel> movieModelArrayList) {
        this.movieModelArrayList = movieModelArrayList;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movieModelArrayList = new ArrayList<>();
    }

    public ArrayList<MovieModel> getMovieModelArrayList() {
        return movieModelArrayList;
    }

    @Override
    public int getCount() {
        return movieModelArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return movieModelArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 1;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        MovieModel movieModel = (MovieModel) getItem(i);
        viewHolder.bind(movieModel);
        return view;
    }

    private class ViewHolder {
        private TextView tvTitle;
        private TextView tvDesc;
        private TextView tvYear;
        private ImageView ivMovie;

        ViewHolder(View view) {
            tvTitle = view.findViewById(R.id.tv_title);
            tvYear = view.findViewById(R.id.tv_year);
            tvDesc = view.findViewById(R.id.tv_excerpt);
            ivMovie = view.findViewById(R.id.iv_hero);
        }

        void bind(MovieModel movieModel) {
            tvTitle.setText(movieModel.getTitle());
            tvDesc.setText(movieModel.getDesc());
            tvYear.setText("(" + movieModel.getYear()+")");
            ivMovie.setImageResource(movieModel.getImg());
        }
    }
}
