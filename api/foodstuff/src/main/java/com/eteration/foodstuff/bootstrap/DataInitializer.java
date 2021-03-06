package com.eteration.foodstuff.bootstrap;

import com.eteration.foodstuff.model.Direction;
import com.eteration.foodstuff.model.Ingredient;
import com.eteration.foodstuff.model.Recipe;
import com.eteration.foodstuff.model.User;
import com.eteration.foodstuff.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class DataInitializer implements CommandLineRunner {
    private final RecipeRepository recipeRepository;

    @Override
    public void run(String... args) throws Exception {

    }

    void loadData(){
        Recipe recipe = new Recipe();
        recipe.setTitle("Title");
        recipe.setChefTips("Tips");
        recipe.setDescription("Description");
        recipe.setImage("base64");
        recipe.setPrepTime("Time");
        recipe.setServing("Test");


        List<Ingredient> ingredientList = new ArrayList<>();
        Ingredient ingredient_1 = new Ingredient();
        ingredient_1.setName("test");

        Ingredient ingredient_2 = new Ingredient();
        ingredient_2.setName("test");

        ingredientList.add(ingredient_1);
        ingredientList.add(ingredient_2);

        recipe.setIngredients(ingredientList);

        List<Direction> directions = new ArrayList<>();
        Direction direction_1 = new Direction();
        direction_1.setStepNumber((byte) 1);
        direction_1.setDescription("Direction-1");

        Direction direction_2 = new Direction();
        direction_2.setStepNumber((byte) 2);
        direction_2.setDescription("Direction-2");
        directions.add(direction_1);
        directions.add(direction_2);
        recipe.setDirections(directions);

        User user = new User();
        user.setUsername("admin");
        user.setPassword("123");
        user.setAbout("bla bla");
        user.setEmail("admin@admin.com");
        recipe.setUser(user);

        Recipe recipe1 = recipeRepository.save(recipe);
        System.out.println(recipe1);
    }
}