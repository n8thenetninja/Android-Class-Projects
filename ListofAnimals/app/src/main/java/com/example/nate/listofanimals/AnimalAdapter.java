package com.example.nate.listofanimals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nate on 10/18/16.
 */

public class AnimalAdapter extends ArrayAdapter<Animal> {
    public AnimalAdapter(Context context, ArrayList<Animal> animals) {
        super(context, 0, animals);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get data for this position
        Animal animal = getItem(position);
        // Check if existing view is being reused, else inflate a new one
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row,parent,false);
        }
        // Get references of views to populate with specific data
        TextView animalName = (TextView) convertView.findViewById(R.id.listItemTitle);
        ImageView animalIcon = (ImageView) convertView.findViewById(R.id.listItemImg);
        TextView animalCategory = (TextView) convertView.findViewById(R.id.viewAnimalCategory);
        // Fill each referenced view with data it references
        animalName.setText(animal.getName());
        animalIcon.setImageResource(animal.getAssociatedDrawable());
        // Return view to be displayed
        return convertView;
    }
}
