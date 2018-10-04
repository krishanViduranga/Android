package com.example.krishanv.json_youtube;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;


import java.util.ArrayList;


public class reviewsadapter extends ArrayAdapter<reviews> {
    Context context;
    private ArrayList<reviews> reviewList;
    private LayoutInflater vi;
    private int Resource;
    private ViewHolder holder;
    // Button soww;
    View view;
    //ArrayList<Reviews> cp=0;
    int gen=0;


    reviewsadapter(Context context, int resource, ArrayList<reviews> objects) {
        super(context, resource, objects);
        vi = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Resource = resource;
        this.reviewList = objects;

    }


    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        View v = convertView;

        // if view is null then set below views


        if (v == null) {
            holder = new ViewHolder();
            v = vi.inflate(Resource, null);

            //binding holder variables to xml views

            holder.tvtitle = (TextView) v.findViewById(R.id.title);
            holder.tvcomment = (TextView) v.findViewById(R.id.comment);
            holder.tvusefullness = (TextView) v.findViewById(R.id.usefulness);

            holder.rbrating = (RatingBar) v.findViewById(R.id.ratingbar);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        //setting data to the holder vars from "Reviews" getters

        holder.tvtitle.setText(reviewList.get(position).getTitle());
        holder.tvcomment.setText(reviewList.get(position).getComment());
        holder.tvusefullness.setText("usefullness:"+reviewList.get(position).getUsefulness());

        holder.rbrating.setRating(Integer.parseInt(reviewList.get(position).getStars()));
        return v;

    }





    private static class ViewHolder {

        TextView tvtitle;
        TextView tvcomment;
        TextView tvusefullness;
        RatingBar rbrating;
    }






}
