package com.example.nate.listofanimals;


import android.os.Bundle;
import android.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivityListFragment extends ListFragment {

    private ArrayList<Animal> animals;
    private AnimalAdapter animalAdapter;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /*
        String[] values = new String[] {"android","windoze","linux",
                "solaris","ChromeOS","OSX","ios" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,values);

        setListAdapter(adapter); */

        animals = new ArrayList<Animal>();
        animals.add(new Animal("Sully the Snake","This is the description of the animal",
                Animal.Category.REPTILE));
        animals.add(new Animal("Arty the Aardvark","This is the description of the animal",
                Animal.Category.MAMMAL));
        animals.add(new Animal("Ellen the Elephant","This is the description of the animal",
                Animal.Category.MAMMAL));
        animals.add(new Animal("Peter the Parrot","This is the description of the animal",
                Animal.Category.BIRD));
        animals.add(new Animal("Bart the Beetle","This is the description of the animal",
                Animal.Category.INSECT));

        animalAdapter = new AnimalAdapter(getActivity(),animals);

        setListAdapter(animalAdapter);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
    }

}
