package com.example.demo.Services;

import com.example.demo.DAO.RecipeDataAccess;
import com.example.demo.Models.Recipe;

import java.util.ArrayList;

public class RecipeService {
    private final RecipeDataAccess recAccess;
    public RecipeService(){
        this.recAccess = new RecipeDataAccess();
    }
    public ArrayList<Recipe> getAllRecipes(){
        return recAccess.getAllRecipes();
    }
    public void writeNewRecipe(Recipe newRecipe){
        recAccess.addRecipe(newRecipe);
    }
}
