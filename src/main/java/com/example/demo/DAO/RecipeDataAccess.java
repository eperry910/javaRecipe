package com.example.demo.DAO;

import com.example.demo.Models.Ingredient;
import com.example.demo.Models.Recipe;
import com.example.demo.Models.Step;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecipeDataAccess {

    public ArrayList<Recipe> getAllRecipes() throws SQLException {
        ArrayList<Recipe> recipes = new ArrayList<>();
        String sql = "SELECT * FROM recipe";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            recipes.add(new Recipe(rs.getInt("id"), rs.getString("name")));
        }
        return recipes;
    }
    public void addRecipe(Recipe newRecipe){
        String sql = "INSERT INTO recipe (name) VALUES (\"" + newRecipe.name + "\")";
        try{
            DBConnection.setPreparedStatement(DBConnection.getConnection(), sql);

        PreparedStatement ps = DBConnection.getPreparedStatement();
        ps.execute();
        }
        catch(SQLException e){
            System.out.println("Error");
            return;
        }
    }
    public void addSteps(ArrayList<Step> steps){
        try{
            for (Step step: steps) {
                String sql = "INSERT into steps (recipeId, stepNumber, instruction) VALUES (?, ?, ?)";
                DBConnection.setPreparedStatement(DBConnection.getConnection(), sql);
                PreparedStatement ps = DBConnection.getPreparedStatement();
                ps.setInt(1, step.recipeId);
                ps.setInt(2, step.stepNumber);
                ps.setString(3, step.instruction);
                ps.execute();
            }
        } catch(SQLException e){

        }


    }
    public void addIngredients(ArrayList<Ingredient> ingredients){
        try{
            for (Ingredient ingredient: ingredients) {
                String sql = "INSERT into steps (recipeId, name, quantity) VALUES (?, ?, ?)";
                DBConnection.setPreparedStatement(DBConnection.getConnection(), sql);
                PreparedStatement ps = DBConnection.getPreparedStatement();
                ps.setInt(1, ingredient.recipeId);
                ps.setString(2, ingredient.name);
                ps.setString(3, ingredient.quantity);
                ps.execute();
            }
        } catch(SQLException e){

        }

    }
    public Recipe getRecipeById(int id){
        String sql = "Select * from recipe WHERE id = " + id;
        try{
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Recipe(rs.getInt("id"), rs.getString("name"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
