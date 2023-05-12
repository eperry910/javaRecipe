package com.example.demo.DAO;

import com.example.demo.Models.Recipe;

import java.util.ArrayList;

public class RecipeDataAccess {
    ArrayList<Recipe> allRecipes = new ArrayList<>();
    public ArrayList<Recipe> getAllRecipes(){
        return this.allRecipes;
    }
    public void addRecipe(Recipe newRecipe){
        allRecipes.add(newRecipe);
    }
}
