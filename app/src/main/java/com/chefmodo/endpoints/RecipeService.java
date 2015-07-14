package com.chefmodo.endpoints;

import com.chefmodo.homeActivity.Recipe;

import java.util.ArrayList;
import java.util.List;

import retrofit.http.GET;

public interface RecipeService {
    @GET("/recipes")
    ArrayList<Recipe> find();
}
