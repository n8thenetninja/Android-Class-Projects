package com.example.nate.listofanimals;

/**
 * Created by nate on 10/18/16.
 */

public class Animal {
    private String name, description;
    private Category category;

    public enum Category{ REPTILE, MAMMAL, BIRD, INSECT }

    public Animal(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
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

    public String getCategoryString() {return category.name(); }

    public String toString() {
        return "Name: " + name + "Description: " + description + "IconID: " + category.name();
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
