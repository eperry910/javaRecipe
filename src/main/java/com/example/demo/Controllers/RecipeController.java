package com.example.demo.Controllers;

import com.example.demo.Models.Ingredient;
import com.example.demo.Models.Recipe;
import com.example.demo.Models.Step;
import com.example.demo.Services.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class RecipeController {
    private final RecipeService recService;
    public RecipeController(){
        recService = new RecipeService();
    }
    @GetMapping("/all-recipes")
    public ArrayList<Recipe> getRecipes(){
        return recService.getAllRecipes();
    }
    @PostMapping("/newrecipe")
    public void AddRecipe(@RequestBody Recipe newRecipe){
        recService.writeNewRecipe(newRecipe);
    }
    @PostMapping("/recipe-parts")
    public void recipeParts(@RequestBody ArrayList<Step> steps, @RequestBody ArrayList<Ingredient> ingredients){
        recService.addSteps(steps);
        recService.addIngredients(ingredients);
    }
    @GetMapping("/recipe/{id}")
    public Recipe getSingleRecipe(@PathVariable int id){
        return recService.getRecipeById(id);
    }
}
