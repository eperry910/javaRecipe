package com.example.demo.Controllers;

import com.example.demo.Models.Recipe;
import com.example.demo.Services.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
