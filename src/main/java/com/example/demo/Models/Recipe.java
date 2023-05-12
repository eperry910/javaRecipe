package com.example.demo.Models;

import java.util.ArrayList;
import java.util.UUID;

public class Recipe {
    public UUID id;
    public String name;
    public ArrayList<Ingredient> ingredientsList = new ArrayList<Ingredient>();
    public ArrayList<String> steps = new ArrayList<String>();
    public Recipe(String name, ArrayList<Ingredient> ingredientsList, ArrayList<String> steps){
        this.name = name;
        this.ingredientsList = ingredientsList;
        this.steps = steps;
    }
}
