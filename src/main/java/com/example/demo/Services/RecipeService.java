package com.example.demo.Services;

import com.example.demo.DAO.RecipeDataAccess;
import com.example.demo.Models.Ingredient;
import com.example.demo.Models.Recipe;
import com.example.demo.Models.Step;

import java.sql.SQLException;
import java.util.ArrayList;

public class RecipeService {
    private final RecipeDataAccess recAccess;
    public RecipeService(){
        this.recAccess = new RecipeDataAccess();
    }
    public ArrayList<Recipe> getAllRecipes(){
        try{
            return recAccess.getAllRecipes();
        }
        catch(SQLException e){
            System.out.println("Error");
            return null;
        }

    }
    public void writeNewRecipe(Recipe newRecipe){
        recAccess.addRecipe(newRecipe);
    }
    public void addSteps(ArrayList<Step> steps){
        recAccess.addSteps(steps);
    }
    public void addIngredients(ArrayList<Ingredient> ingredients){
        recAccess.addIngredients(ingredients);
    }
    public Recipe getRecipeById(int id){
        return recAccess.getRecipeById(id);
    }
}
