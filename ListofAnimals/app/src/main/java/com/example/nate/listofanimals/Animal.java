package com.example.nate.listofanimals;

/**
 * Created by nate on 10/18/16.
 */

public class Animal {
    private String name, description;
    private long animalId, dateAdded;
    private Category category;

    public enum Category{ REPTILE, MAMMAL, BIRD, INSECT }

    public Animal(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.animalId = 0;
        this.dateAdded = 0;
    }

    public Animal(String name, String description, Category category, long animalId, long dateAdded) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.animalId = animalId;
        this.dateAdded = dateAdded;
    }

    public String getName() {
         return name;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public long getDateAdded() {
        return dateAdded;
    }

    public long getAnimalId() {
        return animalId;
    }

    public String toString() {
        return "id: " + animalId + " Name: " + name + "Description: " + description + "IconID: " + category.name()
                + " Date added: " + dateAdded;
    }

    public int getAssociatedDrawable() {
        return categoryToDrawable(category);
    }

    public static int categoryToDrawable(Category animalCategory) {
        switch(animalCategory) {
            case REPTILE:
                return R.drawable.reptile;
            case MAMMAL:
                return R.drawable.mammal;
            case BIRD:
                return R.drawable.bird;
            case INSECT:
                return R.drawable.insect;
        }

        return R.drawable.paw_icon;
    }




}
