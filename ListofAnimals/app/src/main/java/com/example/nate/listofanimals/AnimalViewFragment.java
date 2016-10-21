package com.example.nate.listofanimals;


import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnimalViewFragment extends Fragment {


    public AnimalViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentLayout = inflater.inflate(R.layout.fragment_animal_view,container,false);

        TextView name = (TextView) fragmentLayout.findViewById(R.id.viewAnimalTitle);
        TextView description = (TextView) fragmentLayout.findViewById(R.id.viewAnimalDescription);
        ImageView icon = (ImageView) fragmentLayout.findViewById(R.id.viewAnimalIcon);

        Intent intent = getActivity().getIntent();
        name.setText(intent.getExtras().getString(MainActivity.ANIMAL_NAME_EXTRA));
        description.setText(intent.getExtras().getString(MainActivity.ANIMAL_DESCRIPTION_EXTRA));

        Animal.Category animalCategory = (Animal.Category) intent.getSerializableExtra(MainActivity.ANIMAL_CATEGORY_EXTRA);
        icon.setImageResource(Animal.categoryToDrawable(animalCategory));

        // Inflate the layout for this fragment
        return fragmentLayout;
    }

}
