package com.example.nate.listofanimals;


import android.content.Intent;
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
        animals.add(new Animal("Sully the Snake","Age: 5\n" +
                "Category: Reptile\n" +
                "Favorite food: Mice\n\n" +
                "Sully is a 10' boa constrictor who lives in the jungle exhibit at the zoo. He was " +
                "donated to the zoo by Frank Musburger after Sully grew too big to keep in an apartment.",
                Animal.Category.REPTILE));
        animals.add(new Animal("Arty the Aardvark","Age: 12\n" +
                "Category: Mammal\n" +
                "Favorite food: Termites\n\n" +
                "Arty is a brown and black Aardvark, who was born here at the zoo by parents Arnold and" +
                "Ardis. Arty once saved the zoo by finding a next of termites in a supporting structure" +
                "of the forrest exhibit. Work crews were rushed in to fix the support, and Arty took a long" +
                "nap with a fill stomach",
                Animal.Category.MAMMAL));
        animals.add(new Animal("Ellen the Elephant","Age: 50\n" +
                "Category: Mammal\n" +
                "Favorite food: Bananas\n\n" +
                "Ellen is three and a half ton elephant who came to live here when the flemmingburg zoo" +
                "closed down. Usually you don't mention a lady's weight, but elephants are actually quite" +
                "proud of their weight. It means they don't have to worry about being pushed around by the " +
                "giraffes. Before Ellen retired, she was a circus elephant, and she still remembers some tricks." +
                "Go ahead! Ask her to lay down! That's her favorite trick.",
                Animal.Category.MAMMAL));
        animals.add(new Animal("Peter the Parrot","Age: 6\n" +
                "Category: bird\n" +
                "Favorite food: Mango\n\n" +
                "Peter is a red and blue parrot who likes to tell jokes, and mouth off in general." +
                "Usually you can find him in the gift shop greeting guests in his own flamboyant manner." +
                "his favorite joke is 'three guys are walking down the street, two of them walk into a bar, but" +
                "the third ducked.'",
                Animal.Category.BIRD));
        animals.add(new Animal("Bart the Beetle","Age: 5 weeks\n" +
                "Category: Insect\n" +
                "Favorite food: Apples\n\n" +
                "Bart is a large stink bug. There's not a lot to say about him. He likes sitting and eating, and " +
                "making vile smells to chase unwanted guests from his territory. You can find him in the bugtopia" +
                " exhibit next to the spiders.",
                Animal.Category.INSECT));

        animalAdapter = new AnimalAdapter(getActivity(),animals);

        setListAdapter(animalAdapter);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);

        launchAnimalDetailActivity(position);
    }

    private void launchAnimalDetailActivity(int position) {
        // Get information for animal clicked on
        Animal animal = (Animal) getListAdapter().getItem(position);
        // New intent to launch animal detail
        Intent intent = new Intent(getActivity(),AnimalDetail.class);
        // Pass information from animal to the activity
        intent.putExtra(MainActivity.ANIMAL_NAME_EXTRA, animal.getName());
        intent.putExtra(MainActivity.ANIMAL_DESCRIPTION_EXTRA, animal.getDescription());
        intent.putExtra(MainActivity.ANIMAL_CATEGORY_EXTRA, animal.getCategory());
        intent.putExtra(MainActivity.ANIMAL_ID_EXTRA, animal.getAnimalId());

        startActivity(intent);

    }

}
