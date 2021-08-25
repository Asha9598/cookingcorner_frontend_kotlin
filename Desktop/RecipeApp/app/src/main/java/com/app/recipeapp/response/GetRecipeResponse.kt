package com.app.recipeapp.response

import com.app.recipeapp.entity.Recipe

data class GetRecipeResponse(
    val data: ArrayList<Recipe>,
    val success: Boolean? = null
)